package ACT11_3B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {
        String arxiu = "C:\\temp\\ACT11_3B.log";
        Map<LocalDateTime, MissatgeEvent> events = new TreeMap<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut línia a línia
            events = LlegeixArxiu(bufferedReader);
            LlegeixVariables(events);
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<LocalDateTime,MissatgeEvent> LlegeixArxiu(BufferedReader bufferedReader) throws IOException {
        Map<LocalDateTime, MissatgeEvent> events = new TreeMap<>();
        String linea;
        int indexInici=0,indexFinal=0;
        String[] parts = { "","","","","","","" }; 
        int i=0;
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: YYYY-MM-DD hh:mi:ss | xxxxx | xxxxx | xxxxx | xxxxx | xxxxx
                // Descomposició de l'string
                indexInici = 0;
                indexFinal = linea.indexOf('|',indexInici+1);
                i=0;
                parts[i] = linea.substring(indexInici,indexFinal);
                while (indexFinal!=-1) {  // si hi ha algun 'tag', s'itera per cercar el 2n, 3r ...
                    parts[i++] = linea.substring(indexInici,indexFinal);
                    indexInici = indexFinal+1;
                    
                    indexFinal = linea.indexOf('|',indexFinal+1);
                }
                parts[i++] = linea.substring(indexInici,linea.length());
                
                // Obtenir data i hora
                String data = parts[0].substring(0,10);  // en format: yyyy-MM-dd
                String hora = parts[0].substring(11,19);  // en format: HH:mi:ss
                LocalDateTime diaHora = LocalDateTime.parse(data + " " + hora,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                
                // Obtenir IP origen
                String ipOrigen = parts[1].trim();

                // Obtenir Port origen
                String portOrigen = parts[2].trim();
                
                // Obtenir IP destí
                String ipDesti = parts[3].trim();

                // Obtenir Port destí
                String portDesti = parts[4].trim();

                // Obtenir la descripción
                String descripcio = parts[5].trim();
                
                for (String s:parts)
                    System.out.println(s);
                
                MissatgeEvent missatgeError = new MissatgeEvent(ipOrigen, portOrigen, ipDesti, portDesti, descripcio);
                events.put(diaHora, missatgeError);
            } catch(Exception e) {  // Les línies que no tenen el format esmentat generen una 'Excepció'
                System.out.println(e.getMessage());
            }
        }
        return events;
    }

    private static void LlegeixVariables(Map<LocalDateTime,MissatgeEvent> variables) {
        for (LocalDateTime k : variables.keySet()) {
            MissatgeEvent v = variables.get(k);
            System.out.println(k + " = " + v.toString());
        }
    }

}

