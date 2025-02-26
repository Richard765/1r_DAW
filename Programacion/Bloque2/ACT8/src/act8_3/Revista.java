/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_3;

/**
 *
 * @author Richard
 */
public class Revista extends PublicacioBase{
    private int numeroEdicio;

    //Constructor
    public Revista(int numeroEdicio, double preu, String titol, int anyPublicacio) {
        super(titol, anyPublicacio, preu);
        this.numeroEdicio = numeroEdicio;
    }
    
    @Override
    public double calculaPreu() {
        return getPreu() * 1.10;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Revista: " + getTitol() + " | Numero edicion: " + numeroEdicio + 
                " | Fecha publicacion: " + getAnyPublicacio() + " | Precio: " + calculaPreu() + " euros" + "}";
    }
}
