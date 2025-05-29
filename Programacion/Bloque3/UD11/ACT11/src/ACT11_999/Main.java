package ACT11_999;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = """
                     SELECT employee_id, first_name,last_name,email,phone_number,
                     hire_date, job_title, salary, commission_pct, department_name
                     FROM departments d, jobs j, employees e
                     WHERE d.department_id = e.department_id
                     AND   j.job_id = e.job_id""";
        
        List<Employee> employees = new ArrayList<>();

        // Establir la connexió
        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);
              Statement statement = connexio.createStatement();
              ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Connexió amb la base de dades MySQL exitosa.");
            
            // Processar els resultats de la Query
            while (resultSet.next()) {
                Employee employee = new Employee( resultSet.getInt("employee_id"),
                                                   resultSet.getString("first_name"),
                                                    resultSet.getString("last_name"), 
                                                      resultSet.getString("email"),
                                    resultSet.getString("phone_number"),
                                    resultSet.getString("hire_date"),
                                    resultSet.getString("job_title"),
                                    resultSet.getDouble("salary"),
                                    resultSet.getDouble("commission_pct"),
                                    resultSet.getString("department_name")
                                  );
                employees.add(employee);
            }

            // Serialització
            try ( FileOutputStream fos = new FileOutputStream("C:\\temp\\ACT11_4.ser");
                  ObjectOutputStream out = new ObjectOutputStream(fos)
                ) {
                // Iterar cada 'employee'
                for (Employee e : employees) {
                    System.out.println(e.toString());
                    out.writeObject(e);
                }
                
            } catch (IOException i) {
                System.out.println("Exception writing 'Empleats': " + i);
            }

            
            // Deserialització
            // ...
            // ...
            // ...
            
            System.out.println("Connexió tancada.");
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de dades: " + e.getMessage());
        }
    }
}