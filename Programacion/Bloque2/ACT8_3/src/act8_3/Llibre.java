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

    public Llibre(String autor, String titol, int anyPublicacio, double preu) {
        super(titol, anyPublicacio, preu);
        this.autor = autor;
    }



    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public double calculaPreu() {
        return getPreu() * 1.21;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Libro: " + getTitol() + " | Autor: " + autor + 
                " | Fecha publicacion: " + getAnyPublicacio() + " | Precio: " + calculaPreu() + " euros"+ "}";
    }
}
