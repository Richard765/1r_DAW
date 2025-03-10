package ACT8_2A;

/**
 *
 * @author winadmin
 */
public class Android extends Telefon {
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
 
    // Constructors
    /*
    public Android(String marca, Persona persona, String patroCodiPin, String patroTeclat, String patroEmprempta) {
        super(marca, persona, false);
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
    } */
    
    /** Constructor sense patrons, a continuació utilizar 'setPatrons'
     * 
     * @param marca
     * @param persona 
     */
    public Android(String marca, Persona persona) {
        super(marca, persona);
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
                return persona.getPatroCodiPin().equals(this.patroCodiPin);
            if (persona.getPatroTeclat() != null) 
                return persona.getPatroTeclat().equals(this.patroTeclat);
            if (persona.getPatroEmprempta() != null) 
                return persona.getPatroEmprempta().equals(this.patroEmprempta);
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
