package ACT12_0E;

// import java.util.Comparator;
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
        return this.nom.compareTo(p.nom); // Ordre per Nom
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nom.equals(persona.nom) && edat == persona.edat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, edat);
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }
}

