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

    //Constructor
    public PublicacioBase(String titol, int anyPublicacio) {
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
    }

    //Getters
    public String getTitol() {
        return titol;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    //Setters
    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }
    
    @Override
    public String toString() {
        return "Publicacion {" + "titulo: " + this.getTitol() + "any publicacio: " + this.getAnyPublicacio() + "}";
    }
}
