package ACT4_6;

import java.util.Scanner;
import java.util.Random;

public class ACT4_6_B_PRUEBA {
    static char SIMBOLO_MATAR = 'X';
    static char SIMBOLO_TORRE = '9';
    static char VACIO = 'O';
    static char[][] tablero;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Medidas del tablero (NxN): ");
        int NTABLERO = sc.nextInt();

        tablero = new char[NTABLERO][NTABLERO];
        inicializarTablero(tablero);

        System.out.print("Número de torres: ");
        int numTorres = sc.nextInt();

        int[][] posicionesTorres = new int[numTorres][2]; // Para almacenar posiciones de las torres

        // Coloca las torres en posiciones aleatorias
        for (int i = 0; i < numTorres; i++) {
            int[] nuevaPosicion;
            do {
                nuevaPosicion = generaPosicionAleatoria(NTABLERO);
            } while (tablero[nuevaPosicion[0]][nuevaPosicion[1]] == SIMBOLO_TORRE);
            posicionesTorres[i] = nuevaPosicion;
            tablero[nuevaPosicion[0]][nuevaPosicion[1]] = SIMBOLO_TORRE;
        }

        // Marca las líneas de ataque en el tablero
        for (int[] torre : posicionesTorres) {
            marcarLineasAtaque(tablero, torre);
        }

        // Imprime el tablero con las líneas de ataque
        System.out.println("Tablero con líneas de ataque:");
        imprimeTablero(tablero);

        // Identificar qué torres se matan entre sí
        System.out.println("Torres que se matan entre ellas:");
        identificarTorresQueSeMatan(posicionesTorres);
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = VACIO; // Llena el tablero con 'O'
            }
        }
    }

    public static int[] generaPosicionAleatoria(int limite) {
        Random random = new Random();
        return new int[]{random.nextInt(limite), random.nextInt(limite)};
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

        for (int i = 0; i < n; i++) {
            int x1 = posicionesTorres[i][0];
            int y1 = posicionesTorres[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = posicionesTorres[j][0];
                int y2 = posicionesTorres[j][1];

                // Verificar si están en la misma fila o columna
                if (x1 == x2 || y1 == y2) {
                    System.out.printf("La torre en (%d, %d) puede matar a la torre en (%d, %d)\n", x1, y1, x2, y2);
                    System.out.printf("La torre en (%d, %d) puede matar a la torre en (%d, %d)\n", x2, y2, x1, y1);
                }
            }
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
