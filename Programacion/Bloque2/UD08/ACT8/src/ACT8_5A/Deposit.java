package ACT8_5A;

/**
 *
 * @author winadmin
 */
public class Deposit extends ProducteBancari {
    private int nombrePeriodes;

    public Deposit(String codiProducte, String nom, double importContractat, double interesPeriode, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.nombrePeriodes = nombrePeriodes;
    }

    @Override
    double calculaRemuneracio() {
        return + (super.importContractat * super.interesPeriode * this.nombrePeriodes);
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
}
