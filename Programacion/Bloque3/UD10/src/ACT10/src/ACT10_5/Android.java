package ACT10_5;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Android que extiende de la clase Telefon.
 */
class Android extends Telefon {
    public Android(Map<TipusPatro,String> patrons, String marca, Persona persona) {
        super(patrons, marca, persona, false);
    }  
}

