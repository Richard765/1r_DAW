package ACT12_1B;

import java.util.*;

public class ACT12_2B {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 1),
                                             new Persona("Jordi",2),
                                             new Persona("Joan", 3),
                                             new Persona("Pere", 4),
                                             new Persona("Maria", 5),
                                             new Persona("Joaquim", 6),
                                             new Persona("Jaume", 7),
                                             new Persona("Judith", 8) );

        System.out.println("Llista: " + persones);
        persones.stream()
            .filter(p -> p.getNom().startsWith("J")) // Filtrar noms que comencen amb "J"
            .skip(2) // Saltar els primers 2 noms
            .limit(3) // Mostrar només els primers 3 noms
            .forEach(System.out::println); // Mostrar el resultat
    }
}

