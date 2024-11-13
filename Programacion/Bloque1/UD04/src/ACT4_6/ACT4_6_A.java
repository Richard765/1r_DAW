package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_3.UtilitatsMatrius;
import java.util.Scanner;

/**
 *
 * @author Alumnat
 */
public class ACT4_6_A {
    
    public static final int SIMBOLO_VACIO = 0;
    public static final int SIMBOLO_GUSANO = 1;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[][] tablero;
        int[] gusano; // x,y del gusano
        int accion;

        final int NTABLERO = UtilitatsConsola.llegirSencer("Medida del tablero: ");
        tablero = UtilitatsMatrius.generaMatriu(NTABLERO, 0, 0); // matriz NTABLEROxNTABLERO
        gusano = UtilitatsArrays.generaArray(2, 0, tablero.length - 1); // (x,y) del gusano
        
        utilizaTablero(tablero, gusano);
        
        do {
            UtilitatsMatrius.mostrarMatriu(tablero);
            UtilitatsArrays.mostraArray(gusano);
            
            accion = UtilitatsConsola.llegirSencer("Accion: 8 UP, 2 DOWN, 4 LEFT, 6 RIGHT: ");
            
            cambiaPosicion(tablero, gusano, accion);
        } while (accion != 0);
    }
    
    public static void utilizaTablero(int[][] tablero, int[] gusano) {
        tablero[gusano[0]][gusano[1]] = SIMBOLO_GUSANO;
    }
    
    public static void cambiaPosicion(int[][] tablero, int[] gusano, int accion) {
        tablero[gusano[0]][gusano[1]] = SIMBOLO_VACIO;  // Quitar el gusano en la antigua posicion
        
        switch(accion) {
            case 8: // UP
                gusano[0]--;
                break;
            case 6: // RIGHT
                gusano[1]++;
                break;
            case 4: // LEFT
                gusano[1]--;
                break;
            case 2: // DOWN
                gusano[0]++;
                break;
        }

        tablero[gusano[0]][gusano[1]] = SIMBOLO_GUSANO;  // Marcar la nueva posicion
    }
}
