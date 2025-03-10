package ACT8_6A;

/**
 *
 * @author winadmin
 */
class Telefon extends Producte {
    public Telefon(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla);
    }

    @Override
    public double calculaDescompte() {
        return (getGarantiaMesos() < 6) ? 0.10 * getPreu() : 0.05 * getPreu();
    }

    @Override
    public String toString() {
        return "Telèfon {" + super.toString() + "} Preu: " + super.getPreu() + " " + this.calculaDescompte();
    }
}