package ACT8_0F;

/**
 *
 * @author winadmin
 */

// Clase abstracta
abstract class ClasseAbstracta {
    public String atributAbstracte;
    
    // Mètode abstracte que ha de ser implementat en la SubClasse
    public abstract void metodeAbstracteClasse();
    
    // Mètode concret en la classe abstracta
    public void metodeConcret() {
        metodePrivat();
        System.out.println("Implementació del mètode concret en 'ClasseAbstracta'");
    }
    
    public static void metodeEstatic() {
        System.out.println("Implementació d'un mètode estàtic1 en 'ClasseAbstracta'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementació d'un mètode privat en mètode concret de 'ClasseAbstracta'");
    }

}



