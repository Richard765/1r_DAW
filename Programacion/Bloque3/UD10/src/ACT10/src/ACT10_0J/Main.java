package ACT10_0J;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();  
        map.put(1,"Element1"); map.put(2, "Element2");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();  // Transformació
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Integer clau = entry.getKey();
            String valor = entry.getValue();
            System.out.println("Clave: " + clau + ", Valor: " + valor);
            //iterator.remove();
        }

    }
}
