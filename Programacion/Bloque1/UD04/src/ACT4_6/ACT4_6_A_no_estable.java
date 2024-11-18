package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_3.UtilitatsMatrius;

/**
 *
 * @author Alumnat
 */
public class ACT4_6_A_no_estable {
    
    public static final int SIMBOLO_VACIO = 0;
    public static final int SIMBOLO_GUSANO = 1;
    static final int SIMBOLO_HOJA = 9;
    static final int NHOJAS = 4;
    
    public static void main(String[] args) {
        int[][] tablero;
        int[] gusano; // x,y del gusano
        int accion;

        final int NTABLERO = UtilitatsConsola.llegirSencer("Medida del tablero: ");
        tablero = UtilitatsMatrius.generaMatriu(NTABLERO, 0, 0); // matriz NTABLEROxNTABLERO
        gusano = UtilitatsArrays.generaArray(2, 0, tablero.length - 1); // (x,y) del gusano

        utilizaTablero(tablero, gusano);

        // Generar hojas
        for (int i = 0; i < NHOJAS; i++) {
            int[] hoja;
            do {
                hoja = UtilitatsArrays.generaArray(2, 0, tablero.length - 1);
            } while (tablero[hoja[0]][hoja[1]] != SIMBOLO_VACIO); // Evita superposición
            tablero[hoja[0]][hoja[1]] = SIMBOLO_HOJA;
        }

        do {
            mostrarTablero(tablero);
            UtilitatsArrays.mostraArray(gusano);

            accion = UtilitatsConsola.llegirSencer("Accion: 8 UP, 2 DOWN, 4 LEFT, 6 RIGHT: ");

            cambiaPosicion(tablero, gusano, accion);
        } while (accion != 0);
    }

    public static void utilizaTablero(int[][] tablero, int[] gusano) {
        tablero[gusano[0]][gusano[1]] = SIMBOLO_GUSANO;
    }
    
    public static void mostrarTablero(int[][] tablero) {
        char caracter = ' ';
        for (int[] array : tablero) {
            for (int a : array) {
                switch (a) {
                    case SIMBOLO_VACIO -> caracter = ' ';
                    case SIMBOLO_GUSANO -> caracter = 'O';
                    case SIMBOLO_HOJA -> caracter = '*';
                }
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }
    
    public static void cambiaPosicion(int[][] tablero, int[] gusano, int accion) {
        tablero[gusano[0]][gusano[1]] = SIMBOLO_VACIO; // Quitar el gusano en la antigua posicion
        final int MEDIDA = tablero.length;

        switch (accion) {
            case 8: // UP
                gusano[0] = (gusano[0] == 0) ? MEDIDA - 1 : gusano[0] - 1;
                break;
            case 6: // RIGHT
                gusano[1] = (gusano[1] == MEDIDA - 1) ? 0 : gusano[1] + 1;
                break;
            case 4: // LEFT
                gusano[1] = (gusano[1] == 0) ? MEDIDA - 1 : gusano[1] - 1;
                break;
            case 2: // DOWN
                gusano[0] = (gusano[0] == MEDIDA - 1) ? 0 : gusano[0] + 1;
                break;
        }

        tablero[gusano[0]][gusano[1]] = SIMBOLO_GUSANO; // Marcar la nueva posicion
    }
}
