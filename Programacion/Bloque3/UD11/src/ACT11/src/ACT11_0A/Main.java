package ACT11_0A;

import java.io.File;
import java.io.FileReader; import java.io.FileWriter;
import java.io.IOException; import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        char[] c = new char[128]; 
        int cLen = c.length;
        File nomArxiu = new File("c:\\temp\\arxiu.txt");  // o també 'String'
        File nomArxiu2 = new File("c:\\temp\\arxiu2.txt");  // o també 'String'
        // Example use of InputStream methods
        try ( FileReader lector = new FileReader(nomArxiu);
              FileWriter escriptor = new FileWriter(nomArxiu2)
            ) {
            int count = 0;
            int read = 0;
            while ((read = lector.read(c)) != -1) {
                if (read < cLen) 
                    escriptor.write(c, 0, read);
                else 
                    escriptor.write(c);
                count += read;
            }
            System.out.println("S'han escrit: " + count + " caràcters.");
        } catch (FileNotFoundException f) {
            System.out.println("Arxiu " + nomArxiu + " no trobat.");
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
