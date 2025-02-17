/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_1;

/**
 *
 * @author Richard
 */
public interface ValidadorDispositius {
    
    abstract void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre);
    abstract boolean validaPatrons(Object o);
    
}
    