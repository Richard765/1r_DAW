package ACT8_0D;

/**
 *
 * @author gt
 */
class SubClasse2 extends ClasseAbstracta {

    public SubClasse2(int a1) {
        super(a1);
    }
    
    // No es necesari sobre-escriure el mètode concret de la 'clase abstracta'

    // Implementació del Mètodo abstracte de la Classe abstracta  
    @Override
    public void metodeAbstracte() {
        System.out.println("MÈTODE ABSTRACTE implementat en 'Classe2'");
    }
}
