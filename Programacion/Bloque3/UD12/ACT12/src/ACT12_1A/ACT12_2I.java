package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2I {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);

        boolean capNegatiu = numeros.stream()
                                    .noneMatch(n -> n < 0); // Comprovar si cap número és negatiu

        List<Integer> resultats = numeros.stream()
                                         .filter(n -> n > 0) // Filtrar només els números positius
                                         .map(n -> n * 10) // Multiplicar per 10
                                         .collect(Collectors.toList()); // Recollir en una llista

        double suma = numeros.stream().mapToDouble(n->n).sum();
        int max = numeros.stream().mapToInt(n->n).max().orElse(0);
        int min = numeros.stream().mapToInt(n->n).min().orElse(0);
        double avg = numeros.stream().mapToInt(n->n).average().orElse(0);

        System.out.println("Llista: " + numeros);
        System.out.println("Cap numero és negatiu?: " + capNegatiu);
        System.out.println("Resultat multiplicat per 10: " + resultats);
        System.out.println("Suma/ Màxim / Mínim / Mitjana: " + suma + " / " + max + " / " + min + " / " + avg);
    }
}

