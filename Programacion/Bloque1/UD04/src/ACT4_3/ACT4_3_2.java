package ACT4_3;

import ACT4_1.UtilitatsArrays;

/**
 *
 * @author Alumnat
 */

public class ACT4_3_2 {
    public static void main(String[] args) {
        final int MEDIDA = 5, MIN = 0, MAX = 10;
        String[] alumnos = new String[MEDIDA];
        int[][] notas = UtilitatsMatrius.generaMatriu(MEDIDA, MIN, MAX);
        
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = UtilitatsConsola.llegirCadena("Nombre alumno " + (i+1) + ": ");
        }
        
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(alumnos[i] + ": ");
            UtilitatsArrays.mostraArray(notas[i]);
            System.out.println("  Media: " + UtilitatsArrays.mitjanaArray(notas[i]));
        }
    } 
}
