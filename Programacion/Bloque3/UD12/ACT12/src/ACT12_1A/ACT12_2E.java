package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2E {
    public static void main(String[] args) {
        List<Double> preus = Arrays.asList(120.5, 55.0, 75.0, 150.0, 50.0, 75.0, 120.5, 45.0, 60.0);

        List<Double> preusAmbDescompte = preus.stream()
                                              .filter(p -> p > 50) // Filtrar productes amb preu superior a 50
                                              .map(p -> p * 0.9) // Aplicar descompte del 10%
                                              .distinct() // Eliminar duplicats
                                              .limit(5) // Mostrar només els primers 5 preus
                                              .collect(Collectors.toList()); // Recollir el resultat en una llista

        System.out.println("Llista: " + preus);
        System.out.println(preusAmbDescompte); // Mostrar els preus amb descompte
    }
}

