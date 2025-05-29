package ACT10_0M;

import java.util.Objects;

/**
 *
 * @author winadmin
 */
public class Persona implements Comparable<Persona> {  // <Persona> evita la 'Classe Genèric',
    private String nom;                                //           per tant evita fer un casting posterorment a 'compareTo'
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    @Override
    public int compareTo(Persona p) {
        if (this.nom == null && p.nom == null) return 0; // Si tots dos són null, són iguals
        if (this.nom == null) return 1; // Si this.nom és null, va al final
        if (p.nom == null) return -1; // Si p.nom és null, this va primer

        return this.nom.compareTo(p.nom); // Comparació normal
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
}

