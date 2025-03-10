package ACT8_5A;

/**
 *
 * @author winadmin
 */
public abstract class ProducteBancari {
    protected String codiProducte;
    protected String nom;
    protected double importContractat;
    protected double interesPeriode;

    public ProducteBancari(String codiProducte, String nom, double importContractat, double interesPeriode) {
        this.codiProducte = codiProducte;
        this.nom = nom;
        this.importContractat = importContractat;
        this.interesPeriode = interesPeriode;
    }
    
    abstract double calculaRemuneracio();

    @Override
    public String toString() {
        return "ProducteBancari {" + "codiProducte=" + codiProducte + ", nom=" + nom + '}';
    }
}
