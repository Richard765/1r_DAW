/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_3;

/**
 *
 * @author Richard
 */
public class EmpleatAssalariat extends Empleat {

    public EmpleatAssalariat(String nom, String llinatge, double souBase) {
        super(nom, llinatge, souBase);
    }
    
    @Override
    public double calculaSalari() {
        return 160 * getSouBase();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSalario: " + calculaSalari();
        
    }
}
