package ACT11_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        String arxiu = "C:\\temp\\ACT11_1.cfg";
        Map<String, String> variables = new HashMap<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut línia a línia
            variables = LlegeixArxiu(bufferedReader);
            // Mostrar el map
            MostraVariables(variables);
            // Comprovar la seva correctessa
            if (ComprovaVariables(variables))
                System.out.println("OK");
            else
                System.out.println("KO");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<String,String> LlegeixArxiu(BufferedReader bufferedReader) throws IOException {
        Map<String, String> variables = new HashMap<>();
        String linea;
        String[] parts;
        String clau;
        String valor;
        
        while ((linea = bufferedReader.readLine()) != null) {
            // format: xxxx = yyyy
            if (!(linea.isEmpty() || linea.startsWith("#"))) {
            //if (!(linea.isEmpty() || linea.substring(0,1).equals("#"))) {
                parts = linea.split("=");
                if (parts.length == 2) {
                    clau = parts[0].trim();
                    valor = parts[1].trim();
                    variables.put(clau, valor);
                } 
            }
        }
        return variables;
    }

    private static void MostraVariables(Map<String,String> variables) {
        for (String k : variables.keySet()) {
            String v = variables.get(k);
            System.out.println(k + " = " + v);
        }
    }

    private static boolean ComprovaVariables(Map<String,String> variables) {
        String[] valorsPossibles = {"address","netmask","dns_server","interface","gateway"};
        
        for (String v:valorsPossibles) {
            if (variables.get(v) == null)
                return false;
        }
        
        return true;
    }
}

