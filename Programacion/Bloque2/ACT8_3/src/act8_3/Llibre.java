/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_3;

/**
 *
 * @author Richard
 */
public class Llibre extends PublicacioBase {
    private String autor;
    private double preu;

    public Llibre(String autor, double preu, String titol, int anyPublicacio) {
        super(titol, anyPublicacio);
        this.autor = autor;
        this.preu = preu;
    }
    
    @Override
    public double calculaPreu() {
        return preu * 1.21;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Libro: " + getTitol() + " Autor: " + autor + " Año publicacion: " + getAnyPublicacio() + " Precio: " + calculaPreu();
    }
}
