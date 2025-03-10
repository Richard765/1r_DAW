package ACT8_0M;

/**
 *
 * @author Administrador
 */
public class Rectangle extends FiguraGeometrica {
    private double amplada, alcada;

    public Rectangle(String color, double amplada, double alcada) {
        super(color);
        this.amplada = amplada;
    }

    @Override
    public double calculaArea() {
        return Math.pow(this.amplada,this.alcada);
    }

    @Override
    double calculaPerimetre() {
        return (this.amplada * 2) + (this.alcada * 2);
    }

    @Override
    int calculaNCostats() {
        return 4;
    }

    
    
}
