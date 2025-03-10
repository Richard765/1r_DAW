package ACT8_0N;

/** Classe principal per demostrar el polimorfisme
 * 
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crea instàncies de diferents empleats
        Empleat empleat1 = new EmpleatAssalariat("Pere","March",2000);
        Empleat empleat2 = new EmpleatAutonom("Joan", "Marcus", 15, 40);

        // Realitza operacions en cada empleat
        System.out.println(empleat1.toString() + " " + calculaSalari(empleat1));
        System.out.println("------------------------");
        System.out.println(empleat2.toString() + " " +  calculaSalari(empleat2));
    }

    // Realitza operacions amb empleata
    private static double calculaSalari(Empleat e) {

        if (e instanceof EmpleatAssalariat)
            System.out.println("Empleat Assalariat");
        else if (e instanceof EmpleatAutonom)
            System.out.println("Empleat Autònom");
        
        return e.calculaSalari();
    }
}