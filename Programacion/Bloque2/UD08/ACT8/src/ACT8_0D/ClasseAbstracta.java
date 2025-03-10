package ACT8_0D;

/**
 *
 * @author gt
 */
abstract class ClasseAbstracta {
    protected int a1;
    
    public ClasseAbstracta(int a1) {
        this.a1 = a1;
    }
 
    // Mètodo abstracte per ser implementat en SubClasse
    public abstract void metodeAbstracte();
    
    // Mètode concret en la classe abstracta
    public void metodeConcret() {
        System.out.println("MÈTODE CONCRET en Classe abstracta");
    }
    
    public static void metodeEstatic() {
        System.out.println("MÈTODE ESTÀTIC en Classe abstracta");
    }
}