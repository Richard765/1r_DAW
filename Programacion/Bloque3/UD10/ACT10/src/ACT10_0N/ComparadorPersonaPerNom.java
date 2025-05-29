package ACT10_0N;

import java.util.Comparator;

// Comparator per ordenar per Nom
class ComparadorPersonaPerNom implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNom().compareTo(p2.getNom());
    }
}

