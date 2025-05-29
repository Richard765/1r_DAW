package ACT12_0P;

import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1,"Anna"); names.put(2,"Pere"); names.put(3,"Joan"); names.put(4, null);
        
        System.out.println(names);
        
        names.compute(1, (k, v) -> v + " Maria");  
        
        System.out.println(names);
    }
    
}
