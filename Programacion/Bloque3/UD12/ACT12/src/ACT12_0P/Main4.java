package ACT12_0P;

import java.util.HashMap;
import java.util.Map;

public class Main4 {

    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1,"Anna"); names.put(2,"Pere"); names.put(3,"Joan"); names.put(4, null);
        
        System.out.println(names);
        
        names.putIfAbsent(1, "Albert"); // No fa res
        names.putIfAbsent(4, "Joana"); // No fa res
        names.putIfAbsent(6, "Julia"); // Afegeix 6-"Julia"
        
        System.out.println(names);
    }
    
}
