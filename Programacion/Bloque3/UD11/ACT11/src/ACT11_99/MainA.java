package ACT11_99;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author winadmin
 */
public class MainA {
    
    public static class ErrorFormatHTML extends Exception { 
        // Constructor
        public ErrorFormatHTML (String errorMessage) {
            super(errorMessage);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\ACT11_2.html"))) {
            String linia;
            String tag="";
            int indexInici=0, indexFinal=0;
            while ((linia = br.readLine()) != null) {
                indexInici = linia.indexOf('<',indexInici);
                indexFinal = linia.indexOf('>',indexInici+1);
                if (indexInici != -1)  // o també 'indexFinal'
                    tag = linia.substring(indexInici,indexFinal);

                System.out.println(tag);
           }
            
           System.out.println("HTML Ok");
            
        } catch (IOException e) {
            // Capturar y manejar la excepción si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
}