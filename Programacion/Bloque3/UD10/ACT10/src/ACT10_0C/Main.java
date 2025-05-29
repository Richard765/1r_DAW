package ACT10_0C;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        List<String> llista = new ArrayList<>();
        llista.add("Element1");
        llista.add("Element2");
        llista.add("Element1");  // No es permeten duplicats
        for (String l : llista)
            System.out.println(l);
    }
    
}
