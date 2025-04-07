package ACT11_99;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Deque;

public class MainC {

    public static class ErrorFormatHTML extends Exception { 
        // Constructor
        public ErrorFormatHTML (String errorMessage) {
            super(errorMessage);
        }
    }
    
    public static void main(String[] args) {
        Deque<String> tags = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\a.html"))) {
            String linia;
            int indexInici=0, indexFinal=0;
            String tag;
            while ((linia = br.readLine()) != null) {  // tractament de cada línia
                while ((indexInici = linia.indexOf('<', indexInici)) != -1) {  // tractament de tots els tags de cada línia
                    indexFinal = linia.indexOf('>', indexInici+1);

                    if (indexFinal != -1) {
                        tag = linia.substring(indexInici, indexFinal+1);
                        
                        AnalitzaTags(tags, tag);

                        indexInici = indexFinal + 1;
                    } else {
                        break;
                    }
                }
            }
            
            comprovaTags(tags);
            
            System.out.println("HTML Ok");
            
        } catch (ErrorFormatHTML e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // Capturar y manejar la excepción si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
    private static void AnalitzaTags(Deque<String> tags, String tag) {
        int indexMajor = tag.indexOf('>');
        int indexEspai = (tag.indexOf(' ')==-1 ? indexMajor : tag.indexOf(' '));
      
        String tagEntrada = tag.substring(0,Math.min(indexMajor,indexEspai));
        
        // tags no analitzables: '<!DOCTYPE>', '<input ...>'
        if (! (tagEntrada.startsWith("<input") | tagEntrada.startsWith("<!DOCTYPE")) )
            
            if (tagEntrada.startsWith("</")) {
                String tagSortida = tags.pop();
                //System.out.println("OUT " + tagEntrada + " abans " + tagSortida);
                
                if (tagSortida.substring(1,tagSortida.length()).equals(tagEntrada.substring(2,tagEntrada.length())))
                    System.out.println("Ordre OK " + tagSortida);
                else
                    System.out.println("Ordre KO");

            } else {
                tags.push(tagEntrada);
                //System.out.println("IN " + tagEntrada);
            }
    }
    
    private static void comprovaTags(Deque<String> tags) throws ErrorFormatHTML {
        if (tags.size() != 0) {
            for (String s:tags) 
                System.out.println(s);

            throw new ErrorFormatHTML("HTML amb format incorrecte");
        }
    }

}