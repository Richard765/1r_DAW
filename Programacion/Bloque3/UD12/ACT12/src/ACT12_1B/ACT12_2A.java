package ACT12_1B;

import java.util.*;
import java.util.stream.*;

public class ACT12_2A {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 1),
                                                new Persona("Jordi",2),
                                                new Persona("Joan", 3),
                                                new Persona("Pere", 4),
                                                new Persona("Maria", 5),
                                                new Persona("Joaquim", 6),
                                                new Persona("Jaume", 7),
                                                new Persona("Judith", 8) );

        List<Persona> resultat = persones.stream()
                                        .filter(p -> p.getEdat() % 2 != 0) // Filtrar nombres imparells
                                        .distinct() // Eliminar duplicats
                                        .collect(Collectors.toList()); // Recollir el resultat en una llista

        System.out.println("Llista: " + persones);
        System.out.println(resultat); // Mostrar el resultat
    }
}

