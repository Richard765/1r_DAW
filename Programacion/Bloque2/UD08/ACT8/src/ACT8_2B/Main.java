package ACT8_2B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> persones = new ArrayList<>();
        ArrayList<Telefon> telefons = new ArrayList<>();
        
        // Persones
        carregaPersones(persones);
        
        // Telefons
        carregaTelefons(telefons, persones);
        
        // Encenent dispositius
        encenDispositius(telefons);
        
        // Validacions
        validaDispositius(telefons, persones);
        validaPersones(telefons, persones);

        // Apagant dispositius
        apagaDispositius(telefons);
    }
    
    private static void carregaPersones(ArrayList<Persona> persones) {
        Persona persona;
        
        persona = new Persona("Joan");
        persona.setPatrons(new String[] {"1234", null, null, null});
        persones.add(persona);
        // Persona2
        persona = new Persona("Gemma");
        persona.setPatrons(new String[] {null, "Teclat2", null, null});
        persones.add(persona);
        // Persona3
        persona = new Persona("Pere");
        persona.setPatrons(new String[] {null, null, "Emprempta3", null});
        persones.add(persona);
        // Persona4
        persona = new Persona("Maria");
        persona.setPatrons(new String[] {null, null, null, "Rostre4"});
        persones.add(persona);
    }
    
    private static void carregaTelefons(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        Telefon telefon;
        telefon = new Android("Samsung", persones.get(0));
        telefon.setPatrons(new String[] {"1234", null, null, null});
        telefons.add(telefon);
        // Android
        telefon = new Android("Xiaomi", persones.get(1));
        telefon.setPatrons(new String[] {null, "Teclat2", null, null});
        telefons.add(telefon);
        // IPhone8
        telefon = new IPhone8("Apple",persones.get(2));
        telefon.setPatrons(new String[] {null, null, "Emprempta3", null});
        telefons.add(telefon);
        // IPhone10
        telefon = new IPhone10("Apple",persones.get(3));
        telefon.setPatrons(new String[] {null, null, null, "Rostre4"});
        telefons.add(telefon);
    }
    
    private static void validaDispositius(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        // Validacions Persona a Telefon
        System.out.print("\n");
        for (Telefon t : telefons) {
            for (Persona p : persones) {
                System.out.print("\t" + t.getMarca() + ": " + t.validaPatrons(p) + ": " + p.getNom() );
            }
            System.out.print("\n" );
        }
    }
    
    private static void validaPersones(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        // Validacions Telefon a Persona
        System.out.print("\n");
        for (Persona p : persones) {
            for (Telefon t : telefons) {
                System.out.print("\t" + p.getNom() + ": " + p.validaPatrons(t) + ": " + t.getMarca());
            }
            System.out.print("\n");
        }
    }
    
    private static void encenDispositius(ArrayList<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Apagant " + t.toString() + "...");
            t.on();
        }
    }
    
    private static void apagaDispositius(ArrayList<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Apagant " + t.toString() + "...");
            t.off();
        }
    }
}
