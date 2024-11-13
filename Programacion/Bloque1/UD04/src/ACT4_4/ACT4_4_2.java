/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT4_4;

import ACT4_1.UtilitatsArrays;
import java.util.ArrayList;
/**
 *
 * @author Alumnat
 */
public class ACT4_4_2 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(25, 0, 10);
        ArrayList<Integer> resultat = new ArrayList();
        
        UtilitatsArrays.mostraArray(array);
        resultat = UtilitatsClasses.mostrarDiferents(array);
        UtilitatsClasses.mostrarArrayListInt(resultat);
        
    }
}
