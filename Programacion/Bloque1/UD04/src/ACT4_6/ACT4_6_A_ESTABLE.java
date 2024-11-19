package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_3.UtilitatsMatrius;

public class ACT4_6_A_ESTABLE {

    public static final int SIMBOLO_VACIO = 0;
    public static final int SIMBOLO_GUSANO = 1;
    public static final int SIMBOLO_GUSANO_MEDIO = 2;
    public static final int SIMBOLO_GUSANO_FINAL = 3;
    public static int puntuacion = 0;
    static final int SIMBOLO_HOJA = 9;
    static final int NHOJAS = 5;

    public static void main(String[] args) {
        int[][] tablero;
        int[] gusano; // x,y del gusano
        int accion;

        final int NTABLERO = UtilitatsConsola.llegirSencer("Medida del tablero: ");
        tablero = UtilitatsMatrius.generaMatriu(NTABLERO, 0, 0); // matriz NTABLEROxNTABLERO
        gusano = UtilitatsArrays.generaArray(2, 0, tablero.length - 1); // (x,y) del gusano

        utilizaTablero(tablero, gusano);
        generarHojas(tablero, NHOJAS); // Generar las hojas iniciales
        do {
            mostrarTablero(tablero);
            UtilitatsArrays.mostraArray(gusano);

            System.out.println("Puntuacion: " + puntuacion);
            accion = UtilitatsConsola.llegirSencer("Accion: 8 UP, 2 DOWN, 4 LEFT, 6 RIGHT: ");

            cambiaPosicion(tablero, gusano, accion);
        } while (accion != 0);
    }

    public static void utilizaTablero(int[][] tablero, int[] gusano) {
        tablero[gusano[0]][gusano[1]] = SIMBOLO_GUSANO;
    }

    public static void generarHojas(int[][] tablero, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int[] hoja;
            do {
                hoja = UtilitatsArrays.generaArray(2, 0, tablero.length - 1);
            } while (tablero[hoja[0]][hoja[1]] != SIMBOLO_VACIO); // Evita superposición
            tablero[hoja[0]][hoja[1]] = SIMBOLO_HOJA;
        }
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

        // Calcula la nueva posición
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
            case 0: // Salir
                System.out.println("Puntuacion final: " + puntuacion);
                System.out.println("Saliendo del juego");
                return;
        }

        // Verifica si hay una hoja en la nueva posición
        if (tablero[gusano[0]][gusano[1]] == SIMBOLO_HOJA) {
            generarHojas(tablero, 1); // Generar una nueva hoja
            puntuacion++;
        }

        // Mueve el gusano
        tablero[gusano[0]][gusano[1]] = SIMBOLO_VACIO; // Limpia la posición anterior
        tablero[gusano[0]][gusano[1]] = SIMBOLO_GUSANO; // Marca la nueva posición
    }
}