package ACT8_0A;

/**
 *
 * @author winadmin
 */
// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objecte de la classe 'Cercle'
        Cercle cercle = new Cercle("Vermell", 5.0);
        Quadrat quadrat = new Quadrat("Blau", 5.0);
        
        System.out.println("Área del cercle: " + cercle.calculaArea()); 
        System.out.println("Área del cercle: " + quadrat.calculaArea());
    }
}
