package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2F {
    public static void main(String[] args) {
        List<Integer> edats = Arrays.asList(15, 19, 22, 17, 21, 18, 20, 16);

        long nombreMajors = edats.stream()
            .filter(edat -> edat > 18) // Filtrar majors d'edat
            .count(); // Comptar el nombre d'estudiants majors d'edat

        List<Integer> majors = edats.stream()
                                    .filter(edat -> edat > 18) // Filtrar majors d'edat
                                    .collect(Collectors.toList()); // Recollir els majors en una llista

        boolean totsMajors = edats.stream()
            .allMatch(edat -> edat >= 18); // Comprovar si tots els estudiants són majors d'edat

        System.out.println("Llista: " + edats);
        System.out.println("Nombre d'estudiants majors d'edat: " + nombreMajors);
        System.out.println("Estudiants majors d'edat: " + majors);
        System.out.println("Tots els estudiants son majors d'edat: " + totsMajors);
    }
}
