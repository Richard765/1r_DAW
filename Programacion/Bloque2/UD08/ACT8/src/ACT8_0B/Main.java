package ACT8_0B;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Crear un objecte de la classe Cercle
        Cercle cercle = new Cercle("Vermell",5.0);

        cercle.aplicaColor("Blau");
        System.out.println("Àrea del cercle: " + cercle.toString());
        System.out.println(cercle.toString() + " Àrea del cercle: " + cercle.calculaArea()); 
    }
}
