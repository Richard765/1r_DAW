package ACT8_0F;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        SubClasse instancia = new SubClasse();
        
        instancia.metodeAbstracteClasse(); // Implementació del mètode abstracte de classe en 'SubClasse'
        instancia.metodeAbstracteInterficie(); // Implementación del mètode abstracte de interfície en 'SubClasse'
        //
        instancia.metodeConcret(); // Implementació concreta en la 'classe abstracta'
        instancia.metodePerDefecte();  // Implementació del mètode per defecte en 'Interficie'
        //
        SubClasse.metodeEstatic();
        Interficie.metodeEstatic();
        //
        instancia.atributAbstracte = "Abstracte";  // o amb 'setter()'
        //instancia.atributInterficie = "InterficieX";  // no és possible, és final
        System.out.println(instancia.atributInterficie);
        System.out.println(instancia.atributAbstracte);
    }
}
