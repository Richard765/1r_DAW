package ACT8_0M;

/**
 *
 * @author winadmin
 */
class Cercle extends FiguraGeometrica {
    private double radi;

    // Constructor
    public Cercle(String color, double radi) {
        super(color);
        this.radi = radi;
    }

    @Override
    double calculaArea() {
        return Math.PI * Math.pow(radi, 2);
    }

    @Override
    double calculaPerimetre() {
        return Math.PI * 2 * radi;
    }
    
    @Override
    public int calculaNCostats() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Radi: " + this.radi; 
    }
    
    @Override
    public boolean equals(Object o) {
        Cercle c = (Cercle) o;
        return (super.equals(o)) &&
               (c.radi == this.radi); 
    }


    
    
}
