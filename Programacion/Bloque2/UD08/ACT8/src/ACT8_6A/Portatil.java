package ACT8_6A;

/**
 *
 * @author winadmin
 */
public class Portatil extends Producte {
    public Portatil(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla);
    }

    @Override
    public double calculaDescompte() {
        return (getConsumEnergetic() > 20) ? 0.15 * getPreu() : 0.10 * getPreu();
    }

    @Override
    public String toString() {
        return "Portàtil {" + super.toString() + "} Preu: " + super.getPreu() + " " + this.calculaDescompte();
    }
}