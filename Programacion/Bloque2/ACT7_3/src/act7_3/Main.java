/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act7_3;

/**
 *
 * @author Richard
 */

public class Main {
    public static void main(String[] args) {
        // Crear empleados
        EmpleatAssalariat assalariat = new EmpleatAssalariat("Joan", "Garcia", 15.0);
        EmpleatAutonom autonom = new EmpleatAutonom("Maria", "Lopez", 20.0, 120);

        // Mostrar información de los empleados
        System.out.println("=== Empleat Assalariat ===");
        System.out.println(assalariat);
        
        System.out.println("\n=== Empleat Autonom ===");
        System.out.println(autonom);
        
        // Comparar empleados con equals
        EmpleatAssalariat assalariat2 = new EmpleatAssalariat("Joan", "Garcia", 18.0);
        System.out.println("\nSon iguales assalariat y assalariat2? " + assalariat.equals(assalariat2));
    }
}
