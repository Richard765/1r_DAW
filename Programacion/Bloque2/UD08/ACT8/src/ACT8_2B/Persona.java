package ACT8_2B;

/**
 *
 * @author winadmin
 */
public class Persona extends ValidadorDispositius {
    private String nom;
    
    // Constructors
    public Persona(String[] patrons, String nom) {
        super(patrons);
        this.nom = nom;
    }
    
    public Persona(String nom) {
        super(new String[] {null, null, null, null});
        this.nom = nom;
    }

    
    @Override
    public boolean validaPatrons(Object o) {
        Telefon telefon = (Telefon) o;
        
        if (telefon.getOnOff()) {
            for (String patroPersona : this.getPatrons())
                for (String patroDispositiu : telefon.getPatrons())
                    if (patroPersona != null)
                        return patroPersona.equals(patroDispositiu);
            
            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }     
    }


    public String getNom() {
        return this.nom;
    }
    
}
