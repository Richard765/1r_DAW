package ACT8_2A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> persones = new ArrayList<Persona>();
        ArrayList<Telefon> telefons = new ArrayList<Telefon>();
        
        // Persones
        carregaPersones(persones);
        
        // Telefons
        carregaTelefons(telefons, persones);
        
        // Encenent dispositius
        encenDispositius(telefons);
        
        // Validacions
        validaDispositius(telefons, persones);

        // Apagant dispositius
        apagaDispositius(telefons);
    }
    
    private static void carregaPersones(ArrayList<Persona> persones) {
        // Persona persona;
        
        persones.add(new Persona("Joan","1234", null, null, null));
        // Persona2
        persones.add(new Persona("Gemma",null, "Teclat2", null, null));
        // Persona3
        persones.add(new Persona("Pere",null, null, "Emprempta3", null));
        // Persona4
        persones.add(new Persona("Maria",null, null, null, "Rostre4"));
    }
    
    private static void carregaTelefons(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        Telefon telefon;
        
        // Android1
        telefon = new Android("Samsung", persones.get(0));
        telefon.on();
        telefon.setPatrons("1234", null, null,null);
        telefons.add(telefon);
        // Android2
        telefon = new Android("Xiaomi", persones.get(1));
        telefon.setPatrons(null, "Teclat2", null,null);
        telefons.add(telefon);
        // IPhone8
        telefon = new IPhone8("Apple",persones.get(2));
        telefon.setPatrons(null, "Emprempta3",null,null);
        telefons.add(telefon);
        // IPhone10
        telefon = new IPhone10("Apple",persones.get(3));
        telefon.setPatrons(null, null, null, "Rostre4");
        telefons.add(telefon);
    }
    
    private static void validaDispositius(ArrayList<Telefon> telefons, ArrayList<Persona> persones) {
        for (Persona p : persones) {
            for (Telefon t : telefons) {
                System.out.print("\t" + p.getNom() + " " + t.validaPatrons(p) + " ");
            }
            System.out.print("\n" );
        }
    }
    
    private static void encenDispositius(ArrayList<Telefon> telefons) {
        for (Telefon t : telefons) {
            System.out.println("Encenent " + t.toString() + "...");
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