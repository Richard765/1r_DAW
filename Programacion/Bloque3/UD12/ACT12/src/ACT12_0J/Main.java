package ACT12_0J;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        Stream.of("A", "B", "C").forEach(System.out::println);
        //
        Stream.ofNullable(null).forEach(System.out::println);
        //
        Stream.empty().forEach(System.out::println);
        //
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
        //
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
        Stream.generate(() -> UUID.randomUUID().toString()).limit(5).forEach(System.out::println);
        //
        Arrays.stream(new String[]{"Anna", "Pere", "Joan"}).forEach(System.out::println);
        //
        List.of("Anna", "Pere", "Joan").stream().forEach(System.out::println);
        
    }
    
}
