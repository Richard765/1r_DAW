package ACT10_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa cada un dels moduls associats a un cicle formatiu
 * @author T.Vives
 */
public class Modul {
    protected String nom;
    protected int horesSetmanals;
    protected List<Persona> matricula = new ArrayList<>();
    //
    private static int comptadorModuls=1;

    // Constructors
    public Modul(String nom, int horesSetmanals, List<Persona> matricula) {
        this.nom = nom;
        this.horesSetmanals = horesSetmanals;
        this.matricula = matricula;
    }
    
    // Getters i Setters
    public String getNom() {
        return nom;
    }

    public int getHoresSetmanals() {
        return horesSetmanals;
    }

    public static int getComptadorModuls() {
        return comptadorModuls++;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHoresSetmanals(int horesSetmanals) {
        this.horesSetmanals = horesSetmanals;
    }

    @Override
    public String toString() {
        String texte = "";
        texte += "Modul{" + "nom=" + nom + ", horesSetmanals=" + horesSetmanals + ", matricula={";
        for (Persona p : matricula) 
            texte += "\n\t" + p.toString();
        texte += '}';
        
        return texte;
    }

}
