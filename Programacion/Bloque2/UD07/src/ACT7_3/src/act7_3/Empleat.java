/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_3;

/**
 *
 * @author Richard
 */
abstract public class Empleat {
    private String nom;
    private String llinatge;
    private double souBase;
    
    public Empleat (String nom, String llinatge, double souBase) {
        this.nom = nom;
        this.llinatge = llinatge;
        this.souBase = souBase;
    }
    
    public abstract double calculaSalari();
    
    @Override
    public String toString() {
        return "Nom empleat: " + nom + " " + llinatge + "\nSou base: " + souBase;
    }
    
    @Override
    public boolean equals(Object o) {
        Empleat empleat = (Empleat) o;
        
        return (this.nom.equals(empleat.nom)) && (this.llinatge.equals(empleat.llinatge));
    }

    
    public double getSouBase() {
        return souBase;
    }
    
    
}
