package ACT8_6B;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String cognom;
    private ArrayList<Producte> productes;

    public Client(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
        this.productes = new ArrayList<Producte>();
    }
    
    public boolean afegeixProducte(Producte p) {
        if (!(this.productes.contains(p)))
            return this.productes.add(p);
        return false;
    }
    
    public boolean eliminaProducte(String s) {
        return this.productes.remove(this.cercaProducte(s));
    }
            
    
    public Producte cercaProducte(String s) {
        for (Producte p : this.productes) {
            if (p.getNom().equals(s))
                return p;
        }
        return null;
    }

    // Mètode per calcular preu total del 'productes' 
    public double calculaPreuTotal() {
        double preuTotal = 0.0;
        
        for (Producte p : this.productes)
            preuTotal += p.calculaPreu();
        
        return preuTotal;
    }

    @Override
    public String toString() {
        String text = "Client {Nom: " + this.nom + ", Cognom: " + this.cognom + " Productes={";
        
        for (Producte p : productes)
            text += "\n\t " + p.toString();
        
        text += "\n} Preu Total: " + this.calculaPreuTotal();
        return text;
    }
    
    
}