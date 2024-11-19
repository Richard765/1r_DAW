package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import ACT4_3.UtilitatsMatrius;

public class ACT4_6_C {
    int[][] tablero;
    final int NTABLERO = UtilitatsConsola.llegirSencer("Medida del tablero: ");
    tablero = UtilitatsMatrius.generaMatriu(NTABLERO, 0, 0); // matriz NTABLEROxNTABLERO
}
