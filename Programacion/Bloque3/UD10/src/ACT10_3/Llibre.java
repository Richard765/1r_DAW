/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT10_3;

/**
 *
 * @author Richard
 */
public class Llibre {
    private int idLlibre;
    private String titol;
    private String autor;
    private int anyPublicacio;

    //Constructor
    public Llibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        this.idLlibre = idLlibre;
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
    }
    
    //Getters
    public int getIdLlibre() {
        return idLlibre;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }
    
    //Equals y hash
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idLlibre;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Llibre other = (Llibre) obj;
        return this.idLlibre == other.idLlibre;
    }
    
    //toString

    @Override
    public String toString() {
        return "Llibre{" + "idLlibre=" + idLlibre + ", titol=" + titol + ", autor=" + autor + ", anyPublicacio=" + anyPublicacio + '}';
    }
    
}