package ACT8_0F;

/**
 *
 * @author winadmin
 */
// Clase que extiende la clase abstracta e implementa la interfaz
class SubClasse extends ClasseAbstracta implements Interficie {
    
    // Implementació del mètode de la classe abstracta
    @Override
    public void metodeAbstracteClasse() {
        metodePrivat();
        System.out.println("Implementació del mètode de la classe abstracta en 'SubClasse'");
    }

    // Implementació del mètode de la Interfície
    @Override
    public void metodeAbstracteInterficie() {
        metodePrivat();
        System.out.println("Implementació del mètode de la Interfície en 'SubClasse'");
    }
    
    private void metodePrivat() {
        System.out.println("Implementació d'un mètode privat en metodes sobreescrits de 'Subclasse'");
    }
}
