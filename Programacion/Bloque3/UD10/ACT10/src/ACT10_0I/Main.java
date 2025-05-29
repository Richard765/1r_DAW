package ACT10_0I;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Set<String> conjunt = new HashSet<>(); 
        conjunt.add("Element1");
        conjunt.add("Element2");
        Iterator<String> iterator = conjunt.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Element: " + element);
            //iterator.remove();
        }
    }
}
