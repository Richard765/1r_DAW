package examen;

import java.util.Scanner;

public class UtilitatsConsola {

    /**
     * Llegeix un sencer del scanner.
     *
     * @param prompt El missatge que mostra al'usuari indicant quina dada ha
     *               d'escriure.
     * @return El sencer escrit per l'usuari
     */
    public static int llegirSencer(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int sencer = 0;
        
        System.out.print(prompt);
        sencer = scanner.nextInt();
        //scanner.close();
        return sencer;
    }

    /**
     * Llegeix una cadena del scanner.
     *
     * @param prompt El missatge que mostra al'usuari indicant quina dada ha
     *               d'escriure.
     * @return La cadena escrita per l'usuari
     */
    public static String llegirCadena(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String cadena;


        System.out.print(prompt);
        cadena = scanner.nextLine();
        //scanner.close();
        return cadena;
    }
    
    /**
     * Llegeix una cadena del scanner.
     *
     * @param prompt El missatge que mostra al'usuari indicant quina dada ha
     *               d'escriure.
     * @return La cadena escrita per l'usuari
     */
    public static char llegirCar(String prompt) {
        char car;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(prompt);
            if (scanner.hasNext()) {
                car = scanner.next().charAt(0);
            } else {
                // Manejo de error o valor predeterminado en caso de que no haya entrada.
                car = 'X'; // Por ejemplo, devolver un espacio en blanco.
            }

        } 
        return car;
    }

    /**
     * Llegeix un real del scanner. 
     *
     * @param prompt El missatge que mostra al'usuari indicant quina dada ha
     *               d'escriure.
     * @return El real escrit per l'usuari
     */
    public static double llegirDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double real = 0;

        System.out.print(prompt);
        real = scanner.nextDouble();
        //scanner.close();
        return real;
    }   

    // ACT4_3_2
    /**
     * Mostra el menu per pantalla i demana a l'usuari l'opció a executar fins
     * que l'usuari en pitja una de correcta.
     *
     * @param titol    El titol del menu
     * @param opcions  La llista d'opcions, sense numero
     * @param pregunta La pregunta que es fa a l'usuari
     * @return L'opció vàlida elegida per l'usuari.
     */
    public static int gestionarMenu(String titol, String[] opcions, String pregunta) {
        System.out.println(titol);
        int sencer;
        
        for (int i = 0; i < opcions.length; i++) {
            System.out.println((i + 1) + ". " + opcions[i]);
        }
        do {
            sencer = llegirSencer(pregunta);
        } while (sencer != 0);
        return sencer;
    }
    
}
