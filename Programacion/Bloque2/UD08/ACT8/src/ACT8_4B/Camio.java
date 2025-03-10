package ACT8_4B;

/**
 *
 * @author winadmin
 */
public class Camio extends Vehicle {
    private double capacitatCarrega;

    public Camio(String marca, String model, double preu, String tipus, double capacitatCarrega) {
        super(marca, model, preu, tipus);
        this.capacitatCarrega = capacitatCarrega;
    }

    @Override
    public double calculaImpost() {
        return super.getPreu() * 0.15;  // Impuest del 15%
    }  
    
}
