package ACT8_4B;

/**
 *
 * @author winadmin
 */
// Clase para Motocicletas
public class Motocicleta extends Vehicle {
    private int cilindrada;

    public Motocicleta(String marca, String modelo, double preu, String tipus, int cilindrada) {
        super(marca, modelo, preu, tipus);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calculaImpost() {
        return 0.05 * getPreu(); // Impost del 5%
    }
}
