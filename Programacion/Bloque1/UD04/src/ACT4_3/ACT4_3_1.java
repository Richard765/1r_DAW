package ACT4_3;

import ACT4_1.UtilitatsArrays;

/**
 *
 * @author Alumnat
 */
public class ACT4_3_1 {
    public static void main(String[] args) {
        int cantidadNotas = UtilitatsConsola.llegirSencer("Cuantas notas tiene el alumno? ");
        int[] notas = new int[cantidadNotas];
        
        for (int i = 0; i < notas.length; i++) {
            notas[i] = UtilitatsConsola.llegirSencer("Nota " + (i+1) + ": ");
        }
        
        System.out.print("Notas: ");
        UtilitatsArrays.mostraArray(notas);
        System.out.println("Media: " + UtilitatsArrays.mitjanaArray(notas));
    } 
}
