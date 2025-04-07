package ACT10_0N;

import java.util.Comparator;

// Comparator per ordenar per Edat
class ComparadorPersonaPerEdat implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getEdat(), p2.getEdat());
    }
}

