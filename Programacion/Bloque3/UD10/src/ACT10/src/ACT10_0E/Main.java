package ACT10_0E;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, Persona> mapa = new HashMap<>();  // No cal implementar 'hashCode()', 'equals()' d''Integer'
        mapa.put(1, new Persona("Joan", 23)); // "Clau-valor": 1-Persona
        mapa.put(2, new Persona("Aina", 25));
        mapa.put(3,  new Persona("Maria", 30));
        
        Persona persona = mapa.get(1); // Obté el 'valor' de 'clau' = 1
        System.out.println(persona);
    }
    
}
