package ACT10_0F;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Persona, Integer> mapaPersones = new HashMap<>();
        mapaPersones.put(new Persona("Maria", 30), 3);
        mapaPersones.put(new Persona("Joan", 25), 2);

        Integer dadesMaria = mapaPersones.get(new Persona("Maria", 30));  // ???
        System.out.println(dadesMaria);

    }
    
}
