package ACT10_0K;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        DiaSetmana[] dies = DiaSetmana.values();  // Transformació 1
        List<DiaSetmana> llistaDies = Arrays.asList(dies);  // Transformació 2
        Iterator<DiaSetmana> iterator = llistaDies.iterator();
        while (iterator.hasNext()) {
            DiaSetmana dia = iterator.next();
            System.out.println(dia.getAbreviacio() + " " + dia);
            //iterator.remove();
        }
    }

}
