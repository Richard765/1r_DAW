package ACT8_5A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Persona {
    private String nom;
    private int edat;
    private ArrayList<ProducteBancari> productesBancaris;
    
    public Persona(String nom, int edat, ArrayList<ProducteBancari> productesBancaris) {
        this.nom = nom;
        this.edat = edat;
        this.productesBancaris = productesBancaris;
    }
    
    double calculaRemuneracioTotal() {
        double remuneracio = 0;
        for (ProducteBancari p : productesBancaris) {
            remuneracio += p.calculaRemuneracio();
        }
        
        return remuneracio;
    }

    @Override
    public String toString() {
        String text;
        text = "Persona nom=" + nom + ", edat=" + edat;
        for (ProducteBancari p : productesBancaris)
            text += "\n\t" + p.toString() + " Remuneració: " + p.calculaRemuneracio();;
        
        return text;
    }

}
