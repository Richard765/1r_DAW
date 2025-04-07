package ACT10_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Persones
        List<Persona> persones = new ArrayList<>();
        persones.add(new Persona("Joan",23));
        persones.add(new Persona("Gemma",30));
        persones.add(new Persona("Pere",36));
        persones.add(new Persona("Maria",18));
        
        // Mòduls
        Map<Integer, Modul> moduls = new HashMap<>();
        moduls.put(1, new Modul("Programació",7, persones));
        moduls.put(2, new Modul("Gestió de Base de Dades",8, persones));
        moduls.put(3, new Modul("Llenguatge de Marques",4, persones));
        moduls.put(4, new Modul("Sistemes d'Informació",7, persones));
        moduls.put(5, new Modul("Entorns de Desenvolupament",3, persones));
        
        for (Integer k : moduls.keySet()) {
            Modul modul = moduls.get(k);
            System.out.println("Clau: " + k + ", Valor: " + modul.toString());
        }

        
        // Del mòdul amb clau=1, Nom del mòdul i a continuació Nom de la tercera persona matriculada
        System.out.println(moduls.get(1).nom + ": " + moduls.get(1).matricula.get(2).nom );
        
        // Del mòdul amb clau=2, Nom del mòdul i a continuació Total de persones matriculades
        System.out.println(moduls.get(2).nom + ": " + moduls.get(2).matricula.size());
        
        // Del mòdul amb clau=3, Nom del mòdul i a continuació: Llista totes les persones matriculades
        System.out.println(moduls.get(3).nom + ":");
        for (Persona p : moduls.get(3).matricula) {
            System.out.print("\t" + p.nom);
        }
        System.out.print("\n");
    }
}
