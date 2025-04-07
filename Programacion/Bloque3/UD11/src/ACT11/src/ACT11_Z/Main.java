package ACT11_Z;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    // Configuración de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contrase?a";

    public static void main(String[] args) {
        int empleadoId = 5;
        String nombreEmpleado = "Laura Martinez";
        int departamentoId = 2;

        try {
            // 1. Establecer la conexión a la base de datos
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Comprobar si el departamento existe
            if (departamentoExiste(conn, departamentoId)) {
                // 3. Insertar el empleado
                insertarEmpleado(conn, empleadoId, nombreEmpleado, departamentoId);
                System.out.println("Empleado insertado correctamente.");
            } else {
                System.out.println("El departamento con ID " + departamentoId + " no existe.");
            }

            // Cerrar la conexión
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para comprobar si el departamento existe
    private static boolean departamentoExiste(Connection conn, int departamentoId) throws SQLException {
        String sql = "SELECT id FROM departamentos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departamentoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Retorna true si hay al menos una fila
            }
        }
    }

    // Método para insertar un empleado
    private static void insertarEmpleado(Connection conn, int empleadoId, String nombre, int departamentoId) throws SQLException {
        String sql = "INSERT INTO empleados (id, nombre, departamento_id) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empleadoId);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, departamentoId);
            pstmt.executeUpdate();
        }
    }
}
