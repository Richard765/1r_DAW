package ACT10_0L;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        DiaSetmana[] dies = DiaSetmana.values();
        
        for (DiaSetmana d : dies) {
            System.out.println( d.getAbreviacio() + " " + d.getActivitat() );
        }
    }

}
