package ACT12_1B;

import java.util.*;

public class ACT12_2C {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 1),
                                                new Persona("Jordi",2),
                                                new Persona("Joan", 3),
                                                new Persona("Pere", 4),
                                                new Persona("Maria", 5),
                                                new Persona("Joaquim", 6),
                                                new Persona("Jaume", 7),
                                                new Persona("Judith", 8) );

        Long total = persones.stream()
                             .filter(p->p.getNom().contains("A") && p.getEdat()>5)
                             .count();
        
        System.out.println(total);
        
    }
}
