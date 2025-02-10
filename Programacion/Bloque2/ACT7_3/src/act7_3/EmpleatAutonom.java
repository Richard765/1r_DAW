/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_3;

/**
 *
 * @author Richard
 */
public class EmpleatAutonom extends Empleat{
    private int horesTreballades;
    
    public EmpleatAutonom(String nom, String llinatge, double souBase, int horesTreballades) {
        super(nom, llinatge, souBase);
        this.horesTreballades = horesTreballades;
    }
    
    public String ToString() {
        return super.toString() + "\nSalario: " + calculaSalari();
    }
    
    @Override
    public double calculaSalari() {
        return getSouBase() * this.horesTreballades;
    }
}
