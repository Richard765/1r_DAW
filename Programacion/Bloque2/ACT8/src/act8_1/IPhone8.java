/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_1;

/**
 *
 * @author Richard
 */
public class IPhone8 extends Telefon implements ValidadorDispositius {
    private String patroCodiPin;
    private String patroEmprempta;

    // Constructors
    public IPhone8(String marca, Persona persona, String patroCodiPin, String patroEmprempta) {
        super(marca, persona, false);
        setPatrons(patroCodiPin,null,patroEmprempta,null);
    }
    
    /** Constructor sense patrons, a continuació utilizar 'setPatrons'
     * 
     * @param marca
     * @param persona 
     */
    public IPhone8(String marca, Persona persona) {
        super(marca, persona, false);
    }
    
    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroEmprempta(patroEmprempta);
    }
     
    @Override
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        
        if (super.getOnOff()) {
            if (persona.getPatroCodiPin()!= null)
                return persona.getPatroCodiPin().equals(patroCodiPin);
            if (persona.getPatroEmprempta()!= null)
                return persona.getPatroEmprempta().equals(patroEmprempta);
            return false;
        } else {
            System.out.println("Telèfon IPhone8 no encès");
            return false;
        }
    }

    public void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    } 
}