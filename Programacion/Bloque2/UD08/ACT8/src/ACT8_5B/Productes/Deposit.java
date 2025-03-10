package ACT8_5B.Productes;

public class Deposit extends ProducteBancari {
    private int nombrePeriodes;

    public Deposit(String codiProducte, String nom, double importContractat, double interesPeriode, int nombrePeriodes) {
        super(codiProducte, nom, importContractat, interesPeriode);
        setNombrePeriodes(nombrePeriodes);
    }

    @Override
    public double calculaRemuneracio() {
        return + (super.getImportContractat() * super.getInteresPeriode() * this.getNombrePeriodes());
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
}
