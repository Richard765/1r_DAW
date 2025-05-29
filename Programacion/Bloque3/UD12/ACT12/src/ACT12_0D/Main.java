package ACT12_0D;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona("Marc", 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );

        Collections.sort( persones,
                          new Comparator<Persona>() { @Override
                                                      public int compare(Persona p1, Persona p2) {
                                                          //return Integer.compare(p1.getEdat(), p2.getEdat());  // ordenat per 'edat'
                                                          return p1.getNom().compareTo(p2.getNom());  // ordenat per 'nom'
                                                      }
                                                     }
                         );
        System.out.println(persones);  // [Joan (25), Anna (30), Marc (35)]
    }
}

