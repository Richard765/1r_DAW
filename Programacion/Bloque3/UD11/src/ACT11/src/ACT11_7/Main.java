package ACT11_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String arxiu = "C:\\temp\\ACT12_3A.log";
        Map<LocalDateTime, MissatgeError> variables = new TreeMap<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut línia a línia
            variables = LlegeixArxiu(bufferedReader);
            LlegeixVariables(variables);
            if (ComprovaVariables(variables))
                System.out.println("OK");
            else
                System.out.println("KO");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<LocalDateTime,MissatgeError> LlegeixArxiu(BufferedReader bufferedReader) throws IOException {
        Map<LocalDateTime, MissatgeError> variables = new TreeMap<>();
        String linea;
        String[] parts;
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: YYYY-MM-DD hh:mi:ss [tipus:9999] xxxxxxxxxxxxxxxxxxxxxxxxxxx
                // Descomposició de l'string
                parts = linea.split("\\s+(?=\\[)|(?<=\\])\\s+|\\s+(?=:)|(?<=\\[\\w+:)|(?<=:\\d{4})\\s+");
                
                //System.out.println(parts[0] +"-"+parts[1]+"-"+parts[2] + "-" +parts[3]);
                
                LocalDateTime diaHora = LocalDateTime.parse( parts[0], 
                                                     DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );

                // Obtener el tipo de error
                String tipoError = parts[1].substring(1,parts[1].length());

                // Obtener el código de error
                String codigoError = parts[2].substring(0,parts[2].length());

                // Obtener la descripción
                String descripcion = parts[3];
                MissatgeError missatgeError = new MissatgeError(TipusError.valueOf(tipoError),codigoError,descripcion);
                variables.put(diaHora, missatgeError);

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return variables;
    }

    private static void LlegeixVariables(Map<LocalDateTime,MissatgeError> variables) {
        for (LocalDateTime k : variables.keySet()) {
            MissatgeError v = variables.get(k);
            System.out.println(k + " = " + v.toString());
        }
    }

    private static boolean ComprovaVariables(Map<LocalDateTime,MissatgeError> variables) {
        TipusError[] valorsPossibles = {TipusError.ERROR, TipusError.WARNING};
        //for (TipusError v:valorsPossibles) {
        //    if (variables.get(v) == null)
        //        return false;
        //}
        return true;
    }
}

