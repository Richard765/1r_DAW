package ACT8_0F;

/**
 *
 * @author winadmin
 */

// Interfaz
interface Interficie {
    public final String atributInterficie="Interficie";  // 'final' no és obligatòria
    
    
    public abstract void metodeAbstracteInterficie();  // 'abstract' no és obligatòria
    
    default void metodePerDefecte() {
        metodePrivat();
        System.out.println("Implementació del mètode per defecte en 'Interficie'");
    }
    
    public static void metodeEstatic() {
        System.out.println("Implementació d'un mètode estàtic2 en 'Interficie'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementació d'un mètode privat en mètode per defecte de 'Interficie'");
    }
}

