package ACT12_0M;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona("Marc", 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );
        
        Collector<Integer, int[], Integer> sumaIntegers = Collector.of(
            () -> new int[1],
            (acc, elem) -> acc[0] += elem,
            (acc1, acc2) -> {
                acc1[0] += acc2[0];
                return acc1;
            },
            acc -> acc[0]
        );

        Integer total = persones.stream().map(p->p.getEdat()).collect(sumaIntegers);
        
        System.out.println(total);
    }
}
