package ACT11_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = """
                     SELECT department_id, department_name FROM departments WHERE department_id = ?
                     """;
      
        // Establir la connexió
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);
              PreparedStatement stmt = connexio.prepareStatement(sql) ) {
            int departmentId = 10;  // simulant un Scanner
            
            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            
            stmt.setInt(1, departmentId);
            try (ResultSet resultSet = stmt.executeQuery()) {

                // Processar els resultats de la Query
                while (resultSet.next()) {
                    System.out.println( resultSet.getInt("department_id") + " " +
                                        resultSet.getString("department_name")
                                      );
                }
            } catch (SQLException e) {
                System.err.println("Error al executar la instrucció SQL: " + e.getMessage());
            }
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de dades: " + e.getMessage());
        }
    }
}