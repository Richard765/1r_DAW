package ACT12_0L;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class MainA {
    public static void main(String[] args) {
        // BICONSUMER
        BiConsumer<Integer, String> concatenar = (k, v) -> System.out.println(k + " " + v);
        
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Anna"); names.put(2,"Pere"); names.put(3,"Joan");
        
        names.forEach( (k, v) -> concatenar.accept(k, v) );
    }
}

