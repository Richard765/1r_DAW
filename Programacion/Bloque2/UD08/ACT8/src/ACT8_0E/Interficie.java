package ACT8_0E;

/**
 *
 * @author gt
 */
interface Interficie {
    static int a1 = 0;   // o 'final'
    
    abstract public void metodeAbstracte();
    
    default void metodePerDefecte() {
        System.out.println("MÈTODE PER DEFECTE en la interfície.");
    }
    
    public static int getA1() {
        return a1;
    }
   
}
