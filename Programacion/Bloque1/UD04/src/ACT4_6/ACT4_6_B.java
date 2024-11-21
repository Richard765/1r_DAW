package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_3.UtilitatsMatrius;

public class ACT4_6_B {
    static int SIMBOLO_MATAR = 1;
    static int SIMBOLO_TORRE = 9;
    static int[][] tablero;
    static int[] torre; // x,y del torre
    
    
    public static void main(String[] args) {
        final int NTABLERO = UtilitatsConsola.llegirSencer("Medidas del tablero: ");
        tablero = UtilitatsMatrius.generaMatriu(NTABLERO, 0, 0);  // matriu NTAULERxNTAULER
        torre = UtilitatsArrays.generaArray(2,0, tablero.length-1);     // (x,y) del cuc

        while () {
                colocaTorre(tablero, torre);
                utilizaTablero(tablero, torre);
                matarTorre(tablero, torre);

        } 
    }

    public static void colocaTorre(int[][] tauler, int[] cuc) {
        torre = UtilitatsArrays.generaArray(2, 0, tablero.length - 1);
    }
    
    public static void utilizaTablero(int[][] tauler, int[] torre) {

    }
        
    public static void matarTorre(int[][] tauler, int[] torre) {

    }
    
}

