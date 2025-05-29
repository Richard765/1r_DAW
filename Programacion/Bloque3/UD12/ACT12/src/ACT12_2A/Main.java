package ACT12_2A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (Stream<String> linies = Files.lines(Paths.get("c:\\temp\\clients.csv"))) {

            List<Client> clients = 
                   linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .sorted((parts1, parts2) -> parts1[1].compareTo(parts2[1])) // ordenat per nom
                  .map(parts -> new Client( Integer.parseInt(parts[0].trim()),
                                            parts[1].trim(),
                                            parts[2].trim()
                                          )
                      )
                  .collect(Collectors.toList());
            
            // Imprimeix la llista
            clients.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

