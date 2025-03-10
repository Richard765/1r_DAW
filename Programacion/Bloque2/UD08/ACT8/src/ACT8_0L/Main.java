package ACT8_0L;

/**
 *
 * @author winadmin
 */

// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Circulo
        FiguraGeometrica figura1 = new Cercle("Vermell",5.0);
        FiguraGeometrica figura2 = new Quadrat("Rosa",5.0);
        
        System.out.println(figura1.toString() + " ÀREA: " + figura1.calculaArea());
        System.out.println(figura2.toString() + " ÀREA: " + figura2.calculaArea());
        
    }
}
