package ACT11_99;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainB {
    
    public static class ErrorFormatHTML extends Exception { 
        // Constructor
        public ErrorFormatHTML (String errorMessage) {
            super(errorMessage);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\a.html"))) {
            String linia;
            String tag="";
            int indexInici=0,indexFinal=0;
            while ((linia = br.readLine()) != null) {
                indexInici = linia.indexOf('<',indexInici);
                indexFinal = linia.indexOf('>',indexInici+1);
                while (indexInici!=-1) {  // si hi ha algun 'tag', s'itera per cercar el 2n, 3r ...
                    tag = linia.substring(indexInici,indexFinal);
                    indexInici = indexFinal+1;
                    System.out.println(tag);
                    
                    indexInici = linia.indexOf('<',indexInici);
                    indexFinal = linia.indexOf('>',indexInici+1);
                }
           }
            
          
            System.out.println("HTML Ok");
            
        } catch (IOException e) {
            // Capturar y manejar la excepción si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
}
