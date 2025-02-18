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
    private double preu;

    //Constructor
    public Revista(int numeroEdicio, double preu, String titol, int anyPublicacio) {
        super(titol, anyPublicacio);
        this.numeroEdicio = numeroEdicio;
        this.preu = preu;
    }
    
    @Override
    public double calculaPreu() {
        return preu * 1.10;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Revista: " + getTitol() + " Numero edicion: " + numeroEdicio + " Año publicacion: " + getAnyPublicacio() + " Precio: " + calculaPreu();
    }
}
