package ACT10_0N;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona("Marc", 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );

        // Collections.sort(persones, new ComparadorPersonaPerEdat());
        persones.sort(new ComparadorPersonaPerEdat());  // Ordena segons 'ComparadorPersonaPerEdat'
        
        System.out.println(persones);  // [Joan (25), Anna (30), Marc (35)]
    }
}
