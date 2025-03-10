package ACT8_1;

/**
 *
 * @author winadmin
 */
public class Persona {
 
    private String nom;
    // Diferents sistemes de validació
    private String patroCodiPin;
    private String patroTeclat;
    private String patroEmprempta;
    private String patroRostre;
    
    Persona(String nom, String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre) {
        setNom(nom);
        setPatroCodiPin(patroCodiPin);
        setPatroTeclat(patroTeclat);
        setPatroEmprempta(patroEmprempta);
        setPatroRostre(patroRostre);
    }
   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
 
    public String getPatroCodiPin() {
        return patroCodiPin;
    }
 
    public void setPatroCodiPin(String patroCodiPin) {
        this.patroCodiPin = patroCodiPin;
    }
    
    public String getPatroTeclat() {
        return patroTeclat;
    }
 
    public void setPatroTeclat(String patroTeclat) {
        this.patroTeclat = patroTeclat;
    }
    
    public String getPatroEmprempta() {
        return patroEmprempta;
    }
 
    public void setPatroEmprempta(String patroEmprempta) {
        this.patroEmprempta = patroEmprempta;
    }
 
    public String getPatroRostre() {
        return patroRostre;
    }
 
    public void setPatroRostre(String patroRostre) {
        this.patroRostre = patroRostre;
    }

}