package ACT8_0E;

/**
 *
 * @author gt
 */
public class Main {
    public static void main(String[] args) {
        Classe1 classe1 = new Classe1(1, "aaa");
        
        classe1.metodePerDefecte(); // Cridada a 'mètodePerDefecte()' d''Interficie'
        classe1.metodeAbstracte();  // Cridada a 'mètodeAbtracte()' de Classe1'
        System.out.println(Interficie.getA1());  // també podriem fer System.out.println(classe1.getA1());
        System.out.println(classe1.getB1());
        
        Classe2 classe2 = new Classe2();
        classe2.metodePerDefecte(); // Cridada a 'mètodePerDefecte()' de Classe2'
        classe2.metodeAbstracte();  // Cridada a 'mètodeAbtracte()' de Classe2'
    }
}