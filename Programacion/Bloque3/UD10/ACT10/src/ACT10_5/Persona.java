package ACT10_5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Persona extends ValidadorDispositius {
    private String nom;

    Persona(String nom, Map<TipusPatro, String> patrons) {
        super(patrons);
        setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<TipusPatro, String> getPatrons() {
        return patrons;
    }

    @Override
    public void setPatrons() {
        this.patrons = patrons;
    }
    
    /*
    @Override
    public boolean validaPatrons(Object o) {
        Telefon telefon = (Telefon) o;
        if (telefon.getOnOff()) {
            for (Map.Entry<TipusPatro, String> entryPersona : this.patrons.entrySet()) {
                TipusPatro patroClauPersona = entryPersona.getKey();
                String patroValorPersona = entryPersona.getValue();
                for (Map.Entry<TipusPatro, String> entryTelefon : telefon.getPatrons().entrySet()) {
                    TipusPatro patroClauTelefon = entryTelefon.getKey();
                    String patroValorTelefon = entryTelefon.getValue();
                    if (patroClauTelefon == patroClauPersona)
                        return patroClauTelefon.equals(patroClauPersona);
                }
            }
            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }
    }
    */
}