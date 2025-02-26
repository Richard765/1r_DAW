/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_3;

/**
 *
 * @author Richard
 */
abstract class PublicacioBase implements Publicacio{
    private String titol;
    private int anyPublicacio;
    private double preu;

    //Constructor
    public PublicacioBase(String titol, int anyPublicacio, double preu) {
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
        this.preu = preu;
    }

    //Getters
    public String getTitol() {
        return titol;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public double getPreu() {
        return preu;
    }

    //Setters
    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    @Override
    public String toString() {
        return "Publicacion {";
    }
}
