package ACT8_2B;

/**
 *
 * @author winadmin
 */
public class IPhone8 extends Telefon {
    
    // Constructors
    public IPhone8(String[] patrons, String marca, Persona persona) {
        super(patrons, marca, persona, false);
    }
    
    public IPhone8(String marca, Persona persona) {
        super(marca, persona, false);
    }
}