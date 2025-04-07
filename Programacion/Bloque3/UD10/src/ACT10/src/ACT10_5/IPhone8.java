package ACT10_5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author winadmin
 */
class IPhone8 extends Telefon {

    public IPhone8(Map<TipusPatro,String> patrons, String marca, Persona persona) {
        super(patrons, marca, persona, false);
    }
}