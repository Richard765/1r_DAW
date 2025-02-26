/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT8_5.Productes;

/**
 *
 * @author Richard
 */
public class Hipoteca extends ProducteBancari {
    private double comisApertura;
    private int nombrePeriodes;

    public Hipoteca(double comisApertura, int nombrePeriodes, String codiProducte, String nom, double importContractat, double interesPeriode) {
        super(codiProducte, nom, importContractat, interesPeriode);
        this.comisApertura = comisApertura;
        this.nombrePeriodes = nombrePeriodes;
    }
    
    @Override
    public double calculaRemuneracio() {
        return (super.getImportContractat() * super.getInteresPeriode() * this.getNombrePeriodes() - this.comisApertura);
    }
    
    //GETTERS

    public double getComisApertura() {
        return comisApertura;
    }

    public int getNombrePeriodes() {
        return nombrePeriodes;
    }
    
    //SETTERS

    public void setComisApertura(double comisApertura) {
        this.comisApertura = comisApertura;
    }

    public void setNombrePeriodes(int nombrePeriodes) {
        this.nombrePeriodes = nombrePeriodes;
    }
    
    
}
