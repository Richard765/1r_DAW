package ACT8_0Z;

/**
 *
 * @author winadmin
 */

public interface Document{
    abstract void afegeixDocument(String texte);
    
    default void obreDocument() {
        System.out.println("Obrir document");
    }
    
    default void guardaDocument() {
        System.out.println("Guardant document");
    }
    
    default void tancaDocument() {
        System.out.println("Tancar document");
    }
}