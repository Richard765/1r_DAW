package ACT8_5B.Productes;

public abstract class ProducteBancari {
    private String codiProducte;
    private String nom;
    private double importContractat;
    private double interesPeriode;

    public ProducteBancari(String codiProducte, String nom, double importContractat, double interesPeriode) {
        this.codiProducte = codiProducte;
        setNom(nom);
        setImportContractat(importContractat);
        setInteresPeriode(interesPeriode);
    }
    
    public abstract double calculaRemuneracio();

    @Override
    public String toString() {
        return "ProducteBancari {" + "codiProducte=" + codiProducte + ", nom=" + nom + '}';
    }

    public String getCodiProducte() {
        return codiProducte;
    }

    public String getNom() {
        return nom;
    }

    public double getImportContractat() {
        return importContractat;
    }

    public double getInteresPeriode() {
        return interesPeriode;
    }

    public void setCodiProducte(String codiProducte) {
        this.codiProducte = codiProducte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImportContractat(double importContractat) {
        this.importContractat = importContractat;
    }

    public void setInteresPeriode(double interesPeriode) {
        this.interesPeriode = interesPeriode;
    }
    
}
