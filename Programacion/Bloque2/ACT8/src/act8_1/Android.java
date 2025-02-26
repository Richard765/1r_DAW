    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_1;

/**
 *
 * @author Richard
 */
public class Android extends Telefon implements ValidadorDispositius {
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
 
    public Android(String marca, Persona persona, String patroCodiPin, String patroTeclat, String patroEmprempta) {
        super(marca, persona, false);
        this.patroCodiPin = patroCodiPin;
        this.patroTeclat = patroTeclat;
        this.patroEmprempta = patroEmprempta; 
    }

    public Android(String marca, Persona persona) {
        super(marca, persona, false);
    }

    @Override
    public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
    }
    
    @Override
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        if (super.getOnOff()) {
            if (persona.getPatroCodiPin() != null) 
                return persona.getPatroCodiPin().equals(patroCodiPin);
            if (persona.getPatroTeclat() != null) 
                return persona.getPatroTeclat().equals(patroTeclat);
            if (persona.getPatroEmprempta() != null) 
                return persona.getPatroEmprempta().equals(patroEmprempta);
            return false;
        } else {
            System.out.println("Telèfon Android no encès");
            return false;
        }
    }

    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }

    public void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    public void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
}