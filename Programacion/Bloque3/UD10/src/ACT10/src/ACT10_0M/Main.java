package ACT10_0M;
    
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona(null, 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );

        Collections.sort(persones);  // Ordena segons 'compareTo()'
        System.out.println(persones);  // [Anna (30), Joan (25), Marc (35)]
    }
}
