package ACT10_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Biblioteca {
    private Set<Llibre> llibresDisponibles;  // Llibres disponibles
    private Queue<Llibre> llibresPrestats;  // Llibres prestats
    private Map<String, List<Llibre>> titolsDisponibles;  // Títols disponibles

    public Biblioteca() {
        llibresDisponibles = new HashSet<>();
        llibresPrestats    = new LinkedList<>();
        titolsDisponibles  = new HashMap<>();
    }

    public void afegeixLlibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        Llibre nouLlibre = new Llibre(idLlibre, titol, autor, anyPublicacio);
        this.llibresDisponibles.add(nouLlibre);

        if (!titolsDisponibles.containsKey(titol)) {  // si el llibre no es troba
            this.titolsDisponibles.put(titol, new ArrayList<>());
        }
        this.titolsDisponibles.get(titol).add(nouLlibre);  // afegeix el 'llibre' a la llista de títols
    }

    public Llibre cercaLlibreDisponible(String titol) {
        for (Llibre l : this.llibresDisponibles) {
            if (l.getTitol().equals(titol)) {
                return l;
            }
        }
        return null;
    }

    public void prestaLlibre(String titol) {
        Llibre llibrePerPrestar = cercaLlibreDisponible(titol);
        if ( llibrePerPrestar != null) {
            this.llibresDisponibles.remove(llibrePerPrestar);
            this.llibresPrestats.offer(llibrePerPrestar);
        }
    }

    public void tornaLlibre() {
        Llibre llibreRetornat = llibresPrestats.poll();
        if (llibreRetornat != null) {
            llibresDisponibles.add(llibreRetornat);
        }
    }
    
    public void mostraLlibresDisponibles() {
        System.out.println("Llibres disponibles:");
        for (Llibre llibre : llibresDisponibles) {
            System.out.println(llibre.toString());
        }
    }
    
    public void mostraTitolsDisponibles() {
        System.out.println("Llibres disponibles:");
        for (String titol : titolsDisponibles.keySet() ) {
            System.out.println(titol);
        }
    }

    public void mostraLlibresPrestats() {
        System.out.println("Llibres prestats:");
        for (Llibre llibre : llibresPrestats) {
            System.out.println(llibre.toString());
        }
    }
    
    public void afegeixAnomalia(int idLlibre, Anomalia anomalia) {
        boolean trobat = false;
        for (Llibre l : this.llibresDisponibles)
            if (l.getIdLlibre() == idLlibre) {
                trobat = true;
                afegeixAnomalia(l.getAnomalies(), anomalia);
            }
        if (!trobat)
            for (Llibre l : this.llibresPrestats) 
                if (l.getIdLlibre() == idLlibre)
                    afegeixAnomalia(l.getAnomalies(), anomalia);
    }

    private void afegeixAnomalia(List<Anomalia> anomalies, Anomalia anomalia) {
        boolean trobat = cercaAnomalia(anomalies, anomalia);
        if (!trobat) 
            anomalies.add(anomalia);
    }
    
    private boolean cercaAnomalia(List<Anomalia> anomalies, Anomalia anomalia) {
        for (Anomalia a : anomalies)
            if (a == anomalia) 
                return true;
        return false;
    }
    
    public boolean eliminaAnomalia(int idLlibre, Anomalia anomalia) {
        boolean trobat = false;
        
        // Llibres disponibles
        for (Llibre l : this.llibresDisponibles)
            trobat = l.getAnomalies().remove(anomalia);

        
        if (!trobat) {
            // Llibres prestats
            for (Llibre l : this.llibresPrestats) 
                trobat = l.getAnomalies().remove(anomalia);
        }
        
        return trobat;
    }
  
}
