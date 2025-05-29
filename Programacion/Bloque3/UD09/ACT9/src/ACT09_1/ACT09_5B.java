package ACT09_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ACT09_5B {

    public static void main(String[] args) {
        // S'utilitza un recurs que implementa la interfície AutoCloseable (per exemple, BufferedReader)
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\a.html"))) {
            // Aquí les operacions que poden llançar una 'excepció'
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            // Capturar y manejar la excepción si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
        // No cal un bloc final i explícit, ja que el recurs es tancarà automàticament.
    }
}



