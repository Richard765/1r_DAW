package ACT8_2B;

/**
 *
 * @author winadmin
 */
public class Android extends Telefon {
    
    // Constructor
    public Android(String[] patrons, String marca, Persona persona) {
        super(patrons, marca, persona, false);
    }
    
    public Android(String marca, Persona persona) {
        super(marca, persona, false);
    }
}
