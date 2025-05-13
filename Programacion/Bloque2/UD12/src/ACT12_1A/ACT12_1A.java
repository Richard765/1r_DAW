/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT12_1A;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Richard
 */

public class ACT12_1A {
    public static void main(String[] args) {
        /*Filtra i processa la següent llista de nombres sencers per obtenir només 
        els números imparells, multiplicar-los per 2 i eliminar els duplicats.*/
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);

        List<Integer> resultat = numeros.stream()
                                        .filter(n -> n % 2 != 0) // Filtrar nombres imparells
                                        .map(n -> n * 2) // Multiplicar per 2
                                        .distinct() // Eliminar duplicats
                                        .collect(Collectors.toList()); // Recollir el resultat en una llista

        System.out.println("Llista: " + numeros);
        System.out.println(resultat); // Mostrar el resultat
    }
}