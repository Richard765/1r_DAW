package ACT09_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ACT09_5A {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            // Intentar obrir i llegir un arxiu
            br = new BufferedReader(new FileReader("c:\\temp\\a.html"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            // Capturar i manejar l'excepció si passa un error de lectura
            System.err.println("Error de lectura: " + e.getMessage());
        } finally {
            // El bloc finally s'executarà sempre, independentment de si es llença una excepció o no
            try {
                if (br != null) {
                    br.close(); // Tancar el recurs (en aquest cas, el BufferedReader)
                }
            } catch (IOException e) {
                System.err.println("Error al tancar el 'BufferedReader': " + e.getMessage());
            }
        }
    }
}


