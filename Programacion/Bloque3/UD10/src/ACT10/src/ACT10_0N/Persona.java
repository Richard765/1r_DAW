package ACT10_0N;

import ACT10_0M.*;
import static java.lang.CharSequence.compare;
import java.util.Objects;

/**
 *
 * @author winadmin
 */
public class Persona implements Comparable<Persona> {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    @Override
    public int compareTo(Persona p) {
        return compare(this.nom, p.nom); // Ordre per Nom
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nom.equals(persona.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }
    
    
}

