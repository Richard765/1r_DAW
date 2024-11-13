package ACT4_4;

import java.util.ArrayList;

/**
 *
 * @author Alumnat
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] notas;
        
        String cadena1 = "  Texto de prueba";
        String cadena2 = "Prueba de cadena";
        
        String nombre1 = "Richard Exposito";
        String nombre2 = "Exposito";
        
        String[] alumnos = new String[10];
        
        ArrayList<String> alumnes = new ArrayList();
        
        alumnes.add("Tomeu");
        alumnes.add("Pere");
        alumnes.add("Luis");
        alumnes.add("Edu");
        alumnes.add("Richard");
        
        for (String a : alumnes) {
            System.out.println(a);
        }
        
        
        System.out.println("----------------------");
        //Devuelve el numero de caracteres del String
        System.out.println(cadena1.length());
        System.out.println("----------------------");
        //Escribe todos los caracteres en mayuscula
        System.out.println(cadena1.toUpperCase());
        System.out.println("----------------------");
        //Elimina los espacios blancos del inicio y final
        System.out.println(cadena1.trim());
        System.out.println("----------------------");
        //Compara un String devolviendo un True/False
        System.out.println(cadena1.equals(cadena2));
        System.out.println("----------------------");
        //Devuelve el index de la primera aparicion de una subcadena
        System.out.println(nombre1.indexOf(nombre2));
        System.out.println("----------------------");
        //
        System.out.println(cadena1.substring(2,3));
    }
    
}
