package ACT12_1A;


import java.util.*;
import java.util.stream.*;

public class ACT12_2B {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Juan", "Jordi", "Joan", "Pere", "Maria", "Joaquim");

        System.out.println("Llista: " + noms);
        noms.stream()
            .filter(n -> n.startsWith("J")) // Filtrar noms que comencen amb "J"
            .skip(2) // Saltar els primers 2 noms
            .limit(3) // Mostrar només els primers 3 noms
            .forEach(System.out::println); // Mostrar el resultat
    }
}

