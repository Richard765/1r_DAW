package ACT8_0A;


/**
 *
 * @author winadmin
 */
class Cercle implements FiguraGeometrica {
    String color;
    private double radi;

    // Constructor
    public Cercle(String color, double radi) {
        this.color = color;
        this.radi = radi;
    }

    // Implementació del mètode de la interficie per a calcular l'àrea del cercle
    @Override
    public double calculaArea() {
        return Math.PI * Math.pow(radi, 2);
    }

    @Override
    public double calculaPerimetre() {
        return 0;
    }

    @Override
    public int calculaNCostats() {
        return 0;
    }
    
    
}
