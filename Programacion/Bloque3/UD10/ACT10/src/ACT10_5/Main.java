package ACT10_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        List<Persona> persones = new ArrayList<>();
        List<Telefon> telefons = new ArrayList<>();

        carregaPersones(persones);
        carregaTelefons(telefons, persones);

        encenDispositius(telefons);
        validaDispositius(telefons, persones);
        validaPersones(telefons, persones);
        apagaDispositius(telefons);
    }

    private static void carregaPersones(List<Persona> persones) {
        // Patrons
        Map<TipusPatro, String> patrons1 = new HashMap<>(); patrons1.put(TipusPatro.CODIPIN, "CodiPin1");
        Map<TipusPatro, String> patrons2 = new HashMap<>(); patrons2.put(TipusPatro.TECLAT, "Teclat2");
        Map<TipusPatro, String> patrons3 = new HashMap<>(); patrons3.put(TipusPatro.EMPREMTA, "Emprempta3");
        Map<TipusPatro, String> patrons4 = new HashMap<>(); patrons4.put(TipusPatro.ROSTRE, "Rostre1");
        // Persones
        persones.add(new Persona("Joan", patrons1));
        persones.add(new Persona("Gemma", patrons2));
        persones.add(new Persona("Pere", patrons3));
        persones.add(new Persona("Maria", patrons4));
    }

    private static void carregaTelefons(List<Telefon> telefons, List<Persona> persones) {
        // Patrons
        Map<TipusPatro, String> patrons1 = new HashMap<>(); patrons1.put(TipusPatro.CODIPIN, "CodiPin1");
        Map<TipusPatro, String> patrons2 = new HashMap<>(); patrons2.put(TipusPatro.TECLAT, "Teclat2");
        Map<TipusPatro, String> patrons3 = new HashMap<>(); patrons3.put(TipusPatro.EMPREMTA, "Emprempta3");
        Map<TipusPatro, String> patrons4 = new HashMap<>(); patrons4.put(TipusPatro.ROSTRE, "Rostre1");
        // Telefons
        telefons.add(new Android(patrons1,"Samsung", persones.get(0)));
        telefons.add(new Android(patrons2, "Xiaomi", persones.get(1)));
        telefons.add(new IPhone8(patrons3, "Apple", persones.get(2)));
        telefons.add(new IPhone10(patrons4, "Apple", persones.get(3)));
    }

    private static void validaDispositius(List<Telefon> telefons, List<Persona> persones) {
        System.out.print("\n");
        for (Persona p : persones) {
            for (Telefon t : telefons) {
                System.out.print("\t" + p.getNom() + " " + t.validaPatrons(p) + " ");
            }
            System.out.print("\n");
        }
    }
    
    private static void validaPersones(List<Telefon> telefons, List<Persona> persones) {
        System.out.print("\n");
        for (Telefon t : telefons) {
            for (Persona p : persones) {
                System.out.print("\t" + p.getNom() + " " + p.validaPatrons(t) + " ");
            }
            System.out.print("\n");
        }
    }

    private static void encenDispositius(List<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Encenent " + t.toString() + "...");
            t.on();
        }
    }

    private static void apagaDispositius(List<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Apagant " + t.toString() + "...");
            t.off();
        }
    }
}