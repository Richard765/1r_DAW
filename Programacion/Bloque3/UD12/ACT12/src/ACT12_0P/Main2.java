package ACT12_0P;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1,"Anna"); names.put(2,"Pere"); names.put(3,"Joan"); names.put(4, null);
        
        System.out.println(names);
        
        names.computeIfAbsent(1, k -> "Maria"); // No farà res
        names.computeIfAbsent(4, k -> "Marc"); // Modifica 4-"Msrc"
        names.computeIfAbsent(5, k -> "Nuria"); // Afegeix 5-"Nuria"
        
        System.out.println(names);
    }
    
}
