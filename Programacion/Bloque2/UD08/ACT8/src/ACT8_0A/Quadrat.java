package ACT8_0A;

/**
 *
 * @author winadmin
 */
class Quadrat implements FiguraGeometrica {
    String color;
    private double costat;
    
    // Constructor
    public Quadrat(String color, double costat) {
        this.color = color;
        this.costat = costat;
    }
  
    // No getters ni setters

    // Implementació del mètode de la interficie per a calcular l'àrea del quadrat
    @Override
    public double calculaArea() {
        return Math.pow(costat, 2);
    }

    @Override
    public double calculaPerimetre() {
        return 0;
    }

    @Override
    public int calculaNCostats() {
        return 4;
    }
      
}
