package ACT12_0P;

import java.util.HashMap;
import java.util.Map;

public class Main3 {

    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1,"Anna"); names.put(2,"Pere"); names.put(3,"Joan"); names.put(4, null);
        
        System.out.println(names);
        
        names.computeIfPresent(1, (k, v) -> v + " Maria"); // Modifica 1-"Anna Maria"
        names.computeIfPresent(3, (k, v) -> null); // Elimina 3-"Joan"
        names.computeIfPresent(5, (k, v) -> v + " Joana"); // No fa res
        
        System.out.println(names);
    }
    
}
