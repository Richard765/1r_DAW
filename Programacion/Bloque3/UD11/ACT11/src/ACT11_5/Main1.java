package ACT11_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Establir la connexió
        try ( Connection connexio = getConnectionFromFile("c:\\temp\\mysql.con")  ) {
            System.out.println("Connexió establerta.");
 
            connexio.setAutoCommit(false);
            llegeixArxiuABBDD(connexio, "c:\\temp\\ACT11_5.txt");
            
            System.out.println("Connexió tancada.");
        } catch (Exception e) {
            System.err.println("S'ha produït l'error general: " + e.getMessage());
        }
    }
    
    private static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
        String servidor = "";
        String bdades = "";
        String usuari = "";
        String passwd = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split("=");
                    String clau = parts[0].trim();
                    String valor = parts[1].trim();
                    
                    switch (clau) {
                        case "SERVER" -> servidor = valor;
                        case "DBASE" -> bdades = valor;
                        case "USER" -> usuari = valor;
                        case "PASSWD" -> passwd = valor;
                        default -> System.err.println("Clau no vàlida: " + clau);
                    }
                } catch (IndexOutOfBoundsException e) {
                    // En cas de '#', l'split no fnciona
                    // No fer res
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e;  // Es propaga l'excepció al mètode anterior
        }

        // Estableix la connexió a la BD Mysql
        return DriverManager.getConnection(servidor + bdades, usuari, passwd);
    }
    
    private static void llegeixArxiuABBDD(Connection connexio, String filename) throws SQLException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Es descarta la primera línia
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String departmentId = parts[0];
                String departmentName = parts[1];
                String managerId = parts[2];
                String locationId = parts[3];

                try {
                    // Comprovar integritat referencial amb 'employees'
                    if (!SQLCheckPK(connexio, "employees", Integer.parseInt(managerId)))
                        SQLInsert(connexio, "employees", parts[2], "S/D","S/D", "IT_PROG");
                    
                    // Comprovar integritat referencial amb 'locations'
                    if (!SQLCheckPK(connexio, "locations", Integer.parseInt(locationId)))
                        SQLInsert(connexio, "locations", parts[3], "S/D");
                    
                    // Insertar la fila a 'departments'
                    SQLInsert(connexio, "departments", departmentId, departmentName, managerId, locationId );
                    System.out.println("Insertant departament: " + parts[0]);

                    connexio.commit();
                } catch (SQLException e) {
                    connexio.rollback();
                    System.err.println("Error executant la instrucció SQL: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
            throw e; // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static void SQLInsert(Connection connexio, String table, String... valors) throws SQLException  {
        String sql="";
        PreparedStatement statement;
        
        // Cal millorar aquest mètode accedint al diccionari MySQL:
        //    - information_schema.tables:
        //    SELECT TABLE_NAME 
        //    FROM information_schema.TABLES 
        //    WHERE TABLE_SCHEMA = &&esquema
        //    AND   TABLE_NAME = &&tabla;
        //
        //    - information_schema.columns:
        //    SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_KEY, COLUMN_DEFAULT
        //    FROM information_schema.COLUMNS
        //    WHERE TABLE_SCHEMA = &&esquema
        //    AND   TABLE_NAME = &&tabla;

        try {
            if (table.equals("employees")) {
                sql = "INSERT INTO employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID) VALUES (?, ?, ?, ?)";
                statement = connexio.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(valors[0]));
                statement.setString(2, valors[1]);
                statement.setString(3, valors[2]);
                statement.setString(4, valors[3]);
                statement.executeUpdate();
            } else if (table.equals("locations")) {
                sql = "INSERT INTO locations (LOCATION_ID, CITY) VALUES (?,?)";
                statement = connexio.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(valors[0]));
                statement.setString(2, valors[1]);
                statement.executeUpdate();
            } else if (table.equals("departments")) {
                sql = "INSERT INTO departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?, ?, ?, ?)";
                statement = connexio.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(valors[0]));
                statement.setString(2, valors[1]);
                statement.setInt(3, Integer.parseInt(valors[2]));
                statement.setInt(4, Integer.parseInt(valors[3]));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        } 

    }
    
    private static boolean SQLCheckPK(Connection connexio, String taula, int primaryKey) throws SQLException  {
        String sql="";
        
        // Cal millorar aquest mètode accedint al diccionari MySQL
        try {
            if (taula.equals("employees"))
                sql = "SELECT '1' FROM employees WHERE employee_id = ?";
            else if (taula.equals("locations"))
                sql = "SELECT '1' FROM locations WHERE location_id = ?";
            
            PreparedStatement statement = connexio.prepareStatement(sql);
            statement.setInt(1, primaryKey);

            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next(); // si existeix al manco 1 fila ?
        } catch (SQLException e) {
            throw new SQLException (e.getMessage() );
        } 
    }
}