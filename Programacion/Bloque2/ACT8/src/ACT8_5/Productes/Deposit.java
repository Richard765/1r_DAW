/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT8_5.Productes;

import ACT8_5.Tarjetes.Tarjeta;

/**
 *
 * @author Richard
 */
public class Deposit extends ProducteBancari {
    private int nombrePeriodes;

    public Deposit(String codiProducte, String nom, double importContractat, double interesPeriode) {
        super(codiProducte, nom, importContractat, interesPeriode);
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
