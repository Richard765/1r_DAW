package ACT09_1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author T,Vives
 */
public class ACT09_4 {

    public static void main(String[] args) {
        // Utilitza try-with-resources per obrir el Scanner per a lectura de teclat
        try (Scanner scanner = new Scanner(System.in)) {
            int numero;
            
            System.out.print("Introdueixi un número sencer: ");
            numero = scanner.nextInt();
            System.out.println("Ha introduit: " + numero);
        } catch (InputMismatchException e) {
            // Captura i maneja l'excepció si l'usuari no introdueix un enter
            System.err.println("Error: ha d'introduir número sencer.");
        }
    }
}

