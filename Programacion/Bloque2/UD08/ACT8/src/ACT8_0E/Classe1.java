package ACT8_0E;

/**
 *
 * @author gt
 */
class Classe1 implements Interficie {
    private int b1;
    private String b2;

    // Constructor
    public Classe1(int b1, String b2) {
        // super(a1);  no es possible
        this.b1 = b1 * a1;
        this.b2 = b2;
    }

    @Override
    public void metodeAbstracte() {
        System.out.println("MÈTODE ABSTRACTE en Classe1: " + a1);
    }
    
    // La SubClasse1 hereda automàticament el 'metodePerDefecte()' de la interfície
    
    // Getters i Setters
    //public static int getA1() {
    //    return a1;
    //}
    
    public int getB1() {
        return b1;
    }

    public String getB2() {
        return b2;
    }
}

