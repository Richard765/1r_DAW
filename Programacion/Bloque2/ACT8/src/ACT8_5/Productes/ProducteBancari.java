/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT8_5.Productes;

/**
 *
 * @author Richard
 */
abstract class ProducteBancari {
    private String codiProducte;
    private String nom;
    private double importContractat;
    private double interesPeriode;

    //CONSTRUCTOR
    public ProducteBancari(String codiProducte, String nom, double importContractat, double interesPeriode) {
        this.codiProducte = codiProducte;
        this.nom = nom;
        this.importContractat = importContractat;
        this.interesPeriode = interesPeriode;
    }  
    
    //GETTERS
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
    
    //SETTERS

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

    @Override
    public String toString() {
        return "ProducteBancari{" + "codiProducte=" + codiProducte + ", nom=" + nom + ", importContractat=" + importContractat + ", interesPeriode=" + interesPeriode + '}';
    }
    
    public double calculaRemuneracio() {
        return 0.00;
    }
    
    
}
