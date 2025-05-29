package ACT12_2C;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        
        try (Stream<String> linies = Files.lines(Paths.get("c:\\temp\\clients.csv"));
             Connection conn = gestorBBDD.getConnectionFromFile()) {

            linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .forEach(parts -> {
                      try {
                          gestorBBDD.executaSQL(conn,
                                  "INSERT INTO clients (id, nom, email) VALUES (?, ?, ?)",
                                  Integer.parseInt(parts[0].trim()), parts[1].trim(),parts[2].trim());

                      } catch (SQLException e) {
                          try {
                              if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                                  // Clau primària duplicada → fem UPDATE
                                  int id = Integer.parseInt(parts[0].trim());
                                  String nom = parts[1].toUpperCase().trim();
                                  String email = parts[2].toLowerCase().trim();

                                  gestorBBDD.executaSQL(conn,
                                          "UPDATE clients SET nom = ?, email = ? WHERE id = ?",
                                          nom, email, id);
                              } else {
                                  throw new RuntimeException(e);
                              }
                          } catch (SQLException e2) {
                              throw new RuntimeException(e2);
                          }
                      }
                  });

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

