package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ACT4_6_B {
    static final char SIMBOLO_MATAR = 'X';
    static final char SIMBOLO_TORRE = 'T';
    static final char VACIO = 'O';
    static char[][] tablero;

    public static void main(String[] args) {
        // Leer dimensiones del tablero
        int NTABLERO = UtilitatsConsola.llegirSencer("Medidas del tablero: ");

        // Inicializar tablero vacío
        tablero = new char[NTABLERO][NTABLERO];
        inicializarTablero(tablero);

        // Leer número de torres
        int numTorres = UtilitatsConsola.llegirSencer("Numero de torres: ");

        // Generar posiciones de las torres
        int[][] posicionesTorres = new int[numTorres][2];
        for (int i = 0; i < numTorres; i++) {
            int[] nuevaPosicion;
            do {
                nuevaPosicion = UtilitatsArrays.generaArray(2, 0, NTABLERO - 1);
            } while (tablero[nuevaPosicion[0]][nuevaPosicion[1]] == SIMBOLO_TORRE);

            posicionesTorres[i] = nuevaPosicion;
            tablero[nuevaPosicion[0]][nuevaPosicion[1]] = SIMBOLO_TORRE;
        }

        // Marcar las líneas de ataque
        for (int[] torre : posicionesTorres) {
            marcarLineasAtaque(tablero, torre);
        }

        // Mostrar el tablero
        System.out.println("Tablero con torres y líneas de ataque:");
        imprimeTablero(tablero);

        // Identificar qué torres pueden matarse entre sí
        System.out.println("Torres que se matan entre ellas:");
        identificarTorresQueSeMatan(posicionesTorres);
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    public static void marcarLineasAtaque(char[][] tablero, int[] torre) {
        int x = torre[0];
        int y = torre[1];
        int N = tablero.length;

        // Marca filas y columnas alcanzables sin sobrescribir torres
        for (int i = 0; i < N; i++) {
            if (tablero[x][i] != SIMBOLO_TORRE) tablero[x][i] = SIMBOLO_MATAR; // Horizontal
            if (tablero[i][y] != SIMBOLO_TORRE) tablero[i][y] = SIMBOLO_MATAR; // Vertical
        }
    }

    public static void identificarTorresQueSeMatan(int[][] posicionesTorres) {
        int n = posicionesTorres.length;
        List<String> mensajes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x1 = posicionesTorres[i][0];
            int y1 = posicionesTorres[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = posicionesTorres[j][0];
                int y2 = posicionesTorres[j][1];

                // Verificar si están en la misma fila o columna
                if (x1 == x2 || y1 == y2) {
                    mensajes.add(String.format("La torre en (%d, %d) puede matar a la torre en (%d, %d)", x1, y1, x2, y2));
                    mensajes.add(String.format("La torre en (%d, %d) puede matar a la torre en (%d, %d)", x2, y2, x1, y1));
                }
            }
        }

        // Ordenar mensajes alfabéticamente
        Collections.sort(mensajes);

        // Imprimir mensajes
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }

    public static void imprimeTablero(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}