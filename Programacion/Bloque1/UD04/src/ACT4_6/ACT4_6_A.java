package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_3.UtilitatsMatrius;
import java.util.LinkedList;

public class ACT4_6_A {

    public static final int SIMBOLO_VACIO = 0;
    public static final int SIMBOLO_GUSANO = 1;
    public static int puntuacion = 0;
    static final int SIMBOLO_HOJA = 9;
    static final int NHOJAS = 2;

    public static void main(String[] args) {
        int[][] tablero;
        LinkedList<int[]> gusano = new LinkedList<>(); // Cuerpo del gusano como lista de coordenadas
        int accion;

        final int NTABLERO = UtilitatsConsola.llegirSencer("Medida del tablero: ");
        tablero = UtilitatsMatrius.generaMatriu(NTABLERO, 0, 0); // matriz NTABLEROxNTABLERO

        // Inicializar el gusano con una posición inicial
        int[] posicionInicial = UtilitatsArrays.generaArray(2, 0, tablero.length - 1);
        gusano.add(posicionInicial);
        tablero[posicionInicial[0]][posicionInicial[1]] = SIMBOLO_GUSANO;

        generarHojas(tablero, NHOJAS); // Generar las hojas iniciales
        do {
            mostrarTablero(tablero);
            mostrarGusano(gusano);
            System.out.println("Puntuacion: " + puntuacion);
            accion = UtilitatsConsola.llegirSencer("Accion: 8 UP, 2 DOWN, 4 LEFT, 6 RIGHT: ");

            cambiaPosicion(tablero, gusano, accion);
        } while (accion != 0);
    }

    public static void generarHojas(int[][] tablero, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int[] hoja;
            do {
                hoja = UtilitatsArrays.generaArray(2, 0, tablero.length - 1);
            } while (tablero[hoja[0]][hoja[1]] != SIMBOLO_VACIO); // Evita superposicion
            tablero[hoja[0]][hoja[1]] = SIMBOLO_HOJA;
        }
    }

    public static void mostrarTablero(int[][] tablero) {
        char caracter = ' ';
        for (int[] fila : tablero) {
            for (int celda : fila) {
                switch (celda) {
                    case SIMBOLO_VACIO -> caracter = ' ';
                    case SIMBOLO_GUSANO -> caracter = 'O';
                    case SIMBOLO_HOJA -> caracter = '*';
                }
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarGusano(LinkedList<int[]> gusano) {
        System.out.print("Gusano: ");
        for (int[] segmento : gusano) {
            System.out.print("(" + segmento[0] + "," + segmento[1] + ") ");
        }
        System.out.println();
    }

    public static void cambiaPosicion(int[][] tablero, LinkedList<int[]> gusano, int accion) {
        int[] cabeza = gusano.getFirst();
        final int MEDIDA = tablero.length;

        // Calcula la nueva posicion de la cabeza
        int nuevaX = cabeza[0];
        int nuevaY = cabeza[1];
        switch (accion) {
            case 8: // UP
                nuevaX = (nuevaX == 0) ? MEDIDA - 1 : nuevaX - 1;
                break;
            case 6: // RIGHT
                nuevaY = (nuevaY == MEDIDA - 1) ? 0 : nuevaY + 1;
                break;
            case 4: // LEFT
                nuevaY = (nuevaY == 0) ? MEDIDA - 1 : nuevaY - 1;
                break;
            case 2: // DOWN
                nuevaX = (nuevaX == MEDIDA - 1) ? 0 : nuevaX + 1;
                break;
            case 0: // Salir
                System.out.println("Puntuacion final: " + puntuacion);
                System.out.println("Saliendo del juego");
                return;
        }

        // Verifica si la nueva posicion es una hoja
        boolean comeHoja = (tablero[nuevaX][nuevaY] == SIMBOLO_HOJA);

        // Mueve el gusano
        if (!comeHoja) {
            // Quitar la cola si no crece
            int[] cola = gusano.removeLast();
            tablero[cola[0]][cola[1]] = SIMBOLO_VACIO;
        } else {
            // Incrementar puntuacion y generar nueva hoja
            puntuacion++;
            generarHojas(tablero, 1);
        }

        // Añadir nueva cabeza
        gusano.addFirst(new int[]{nuevaX, nuevaY});
        tablero[nuevaX][nuevaY] = SIMBOLO_GUSANO;
    }
}
