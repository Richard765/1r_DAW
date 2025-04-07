package ACT11_0F;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) {
        // Dades de la connexió:
        String servidor = "jdbc:mysql://localhost:3306/";
        String bdades = "gbd";
        String usuari = "root";
        String passwd = "";
        String sql = "SELECT employee_id, last_name, first_name FROM employees WHERE department_id = ?";

        try ( Connection connexio = DriverManager.getConnection(servidor+bdades, usuari, passwd);
              PreparedStatement stmt = connexio.prepareStatement(sql) ) {

            // Assignem un valor al paràmetre de la sentència SQL
            int departmentId = 80; // Exemple: departament amb ID 10
            stmt.setInt(1, departmentId);

            // Executem la consulta parametritzada
            try (ResultSet resultSet = stmt.executeQuery()) {
                // Processar els resultats de la Query
                System.out.println("ID\tLlinatge, nom");
                while (resultSet.next()) {
                    System.out.println( resultSet.getInt("employee_id") + "\t" + 
                                        resultSet.getString("last_name") + ", " + 
                                        resultSet.getString("first_name")
                                      );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al connectar a la base de dades o al executar la consulta: " + e.getMessage());
        }
    }
}