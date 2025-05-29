package ACT12_0L;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class MainC {
    public static void main(String[] args) {
        // BIFUNCTION
        BiFunction<Integer, String, String> toString = (k, v) -> "Clau: " + k + " Valor: " + v;
        
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Anna"); names.put(2,"Pere"); names.put(3,"Joan");
        
        names.forEach( (k, v) -> System.out.println( toString.apply(k, v) ) );
    }
}

