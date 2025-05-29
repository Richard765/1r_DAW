package ACT12_2B;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
    
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Anna"); names.put(2,"Pere"); names.put(3,"Joan");

        // Connexió a la base de dades
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {
            names.entrySet().stream()
                 .forEach( tupla -> { 
                                     try {
                                            gestorBBDD.executaSQL(conn, "INSERT INTO usuaris (id, nom) VALUES (?, ?)",
                                                                  tupla.getKey(), tupla.getValue());
                                         } catch (SQLException e) {
                                             try {
                                                if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                                                    gestorBBDD.executaSQL( conn, "UPDATE usuaris SET nom = ? WHERE id = ?",
                                                                           tupla.getValue(), tupla.getKey() );
                                                else 
                                                    throw new RuntimeException (e);  // en un 'forEach' cal disparar aquesta exception
                                             } catch (SQLException e2) {
                                                 throw new RuntimeException (e2);  // en un 'forEach' cal disparar aquesta exception
                                             }
                                         }
                                    }
                         );

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
