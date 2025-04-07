package ACT11_0B;

import java.io.BufferedReader; import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader; import java.io.FileWriter;
import java.io.FileNotFoundException; import java.io.IOException;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        File nomArxiu = new File("c:\\temp\\arxiu.txt");  // o també 'String'
        File nomArxiu2 = new File("c:\\temp\\arxiu2.txt");  // o també 'String'
        
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu));
              BufferedWriter bufOutput = new BufferedWriter(new FileWriter(nomArxiu2))
            ) {
            String line;
            while ((line = bufInput.readLine()) != null) {
                System.out.println(line);
                
                bufOutput.write(line);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
