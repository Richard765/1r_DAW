package ACT09_1;

import java.util.Scanner;

/**
 *
 * @author T.Vives
 */
public class ACT09_2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int posicio;
        
        try {
            System.out.print("Introdueixi la posició de l'array a llegir (0-" + (array.length-1) + "): ");
            posicio = scanner.nextInt();
            System.out.println(array[posicio]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("S'ha excedit la longitud de l'array");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Error d'execució");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error general");
        } finally {
            scanner.close();
        }
    }
}
