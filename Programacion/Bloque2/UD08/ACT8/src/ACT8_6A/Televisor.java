package ACT8_6A;

/**
 *
 * @author winadmin
 */
public class Televisor extends Producte {
    public Televisor(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla);
    } 

    @Override
    public double calculaDescompte() {
        return (getMidaPantalla() > 40) ? 0.12 * getPreu() : 0.08 * getPreu();
    }

    @Override
    public String toString() {
        return "Televisor {" + super.toString() + "} Preu: " + super.getPreu() + " " + this.calculaDescompte();
    }
}