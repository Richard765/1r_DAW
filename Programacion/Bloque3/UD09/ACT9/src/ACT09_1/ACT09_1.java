package ACT09_1;

import java.util.Scanner;

/**
 *
 * @author T.Vives
 */
public class ACT09_1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        
        try {
            System.out.print("Introdueixi el divident:");
            a = scanner.nextInt();
            System.out.print("Introdueixi el divisor:");
            b = scanner.nextInt();
            
            int c = a / b;
            System.out.println("La divisió és: " + c);
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            System.out.println("No és possible realitzar la divisió per 0");
        } finally {
            scanner.close();
        }
    }
}
