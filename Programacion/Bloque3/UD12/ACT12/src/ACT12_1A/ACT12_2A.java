package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2A {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 5, 3, 9, 2, 5, 6, 1, 8, 7);

        List<Integer> resultat = numeros.stream()
                                        .filter(n -> n % 2 != 0) // Filtrar nombres imparells
                                        .map(n -> n * 2) // Multiplicar per 2
                                        .distinct() // Eliminar duplicats
                                        .sorted()   // Ordenar-los
                                        .collect(Collectors.toList()); // Recollir el resultat en una llista

        System.out.println("Llista: " + numeros);
        System.out.println(resultat); // Mostrar el resultat
    }
}

