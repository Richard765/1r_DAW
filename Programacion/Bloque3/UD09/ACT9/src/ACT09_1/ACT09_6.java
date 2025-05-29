package ACT09_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ACT09_6 {

    public static class ErrorFormatHTML extends Exception { 
        // Constructor
        public ErrorFormatHTML (String errorMessage) {
            super(errorMessage);
        }
    }
    
    public static void main(String[] args) {
        Queue<String> tags = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\a.html"))) {
            String linia;
            int startIndex=0, endIndex=0;
            String tag;
            
            while ((linia = br.readLine()) != null) {
                // Analitzant la 'linia'
                while ((startIndex = linia.indexOf('<', startIndex)) != -1) {
                    endIndex = linia.indexOf('>', startIndex+1);

                    if (endIndex != -1) {
                        tag = linia.substring(startIndex, endIndex+1);
                        
                        AnalitzaTags(tags, tag);

                        startIndex = endIndex + 1;
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
    
    private static void AnalitzaTags(Queue<String> tags, String tag) {
        int indexGreaterThan=tag.indexOf('>');
        int indexSpace=(tag.indexOf(' ')==-1 ? indexGreaterThan : tag.indexOf(' '));
      
        String tagtemp = tag.substring(0,Math.min(indexGreaterThan,indexSpace));
        
        
        // tags no analitzables: '<!DOCTYPE>', '<input ...>'
        if (! (tagtemp.startsWith("<input") | tagtemp.startsWith("<!DOCTYPE")) )
            
            if (tagtemp.startsWith("</")) {
                tags.poll();
                // System.out.println("OUT " + tag);
            } else {
                tags.offer(tag);
                //System.out.println("IN " + tag);
            }

    }
    
    private static void comprovaTags(Queue<String> tags) throws ErrorFormatHTML {
        if (tags.size() != 0) {
            for (String s:tags) 
                System.out.println(s);

            throw new ErrorFormatHTML("HTML amb format incorrecte");
        }
    }

}