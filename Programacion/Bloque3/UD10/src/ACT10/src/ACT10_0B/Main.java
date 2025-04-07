package ACT10_0B;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Set<Persona> persones = new HashSet<>();   // Cal implementar 'hashCode()', 'equals()' de 'Persona'
        persones.add(new Persona("Maria", 25));
        persones.add(new Persona("Joana", 30));
        persones.add(new Persona("Maria", 25));  // No duplicats
        for (Persona p : persones)
            System.out.println(p.toString()); // ? 2
    }
}

