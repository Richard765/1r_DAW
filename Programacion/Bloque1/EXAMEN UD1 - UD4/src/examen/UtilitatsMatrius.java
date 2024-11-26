package examen;

/**
 *
 * @author Tomeu Vives
 */
public class UtilitatsMatrius {
    // ACT4_7
    /**
     * Assigna a cada posicio de la matriu la suma de les seves coordenades
     * @param longitud
     * @param minim
     * @param maxim
     * @return matriu
     */
    public static int[][] generaMatriu(int longitud, int minim, int maxim) {
        int[][] matriu = new int[longitud][longitud];
        
        for (int i = 0; i < matriu.length; i++) {
            matriu[i] = UtilitatsArrays.generaArray(longitud, minim, maxim);
        }
        return matriu;
    }

    // ACT4_7
    /**
     * Mostra la matriu
     * @param matriu
     */
    public static void mostrarMatriu(int[][] matriu) {
        String separador = "  ";
        System.out.println('[');
        for (int i = 0; i < matriu.length; i++) {
            System.out.print(separador);
            UtilitatsArrays.mostraArray(matriu[i]); 
            separador = ", ";
        }
        System.out.println(']');
    }
 
    // ACT4_7
    /**
     * Mostra per consola la diagonal principal de la matriu
     * @param matriu
     */
    public static int[] generaDiagonalPrincipal(int[][] matriu) {
        int[] sortida = new int[matriu.length];
        
        for (int i = 0; i < matriu.length; i++) {
            sortida[i] = matriu[i][i];
        }
        return sortida;
    }
 
    // ACT4_7
    /**
     * Mostra per consola la diagonal secundaria de la matriu
     * @param matriu
     */
    public static int[] generaDiagonalSecundaria(int[][] matriu) {
        int[] sortida = new int[matriu.length];
        
        for (int i = 0, j=matriu.length-1; i < matriu.length; i++, j--) {
            sortida[i] = matriu[i][j];
        }
        return sortida;
    }

}
