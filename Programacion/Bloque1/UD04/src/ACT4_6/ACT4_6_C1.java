package ACT4_6;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;
import java.util.Arrays;


 /**
  * Crea una classe que inicialitzi una matriu quadrada,
  * A continuació gestiona el joc del cuc.
  *     SIMBOL_FULLA --> fulla
  *     SIMBOL_BUIT  --> res
  *     des de 1 fins a (FULLA-1) --> part del cuc
  */

public class ACT4_6_C1 { 
    static int NTAULER;
    static int NFULLES;
    static final int SIMBOL_BUIT = 0;
    static final int SIMBOL_FULLA = 9;
    static final int SIMBOL_CUC = 1;
    static final int SIMBOL_CAPCUC = 2;
    static int[][] tauler;
    static ArrayList<int[]> cuc = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> [a,b] és el cap, [m,n] és la cua 
    static ArrayList<int[]> fulles = new ArrayList<>();  // [[m,n][k,l]...[a,b]] --> posició de les fulles
    static int accio;

    public static void main(String[] args) {
        NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        emplenaTauler(tauler, cuc, fulles);
        
        do {
            mostrarTauler(tauler, cuc, fulles);
            accio = UtilitatsConsola.llegirSencer("Puntuació: " + cuc.size() +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            if ((accio == 2) | (accio == 4)| (accio == 6)| (accio == 8))
                if (cambiaPosicio(tauler, cuc, fulles, accio)) {
                    if (fulles.size() == 0) {
                        System.out.println("YOU WIN !!");
                        accio = 0;
                    }
                } else {
                    System.out.println("YOU LOSE !!");
                    accio = 0;
                }
        } while (accio != 0);
    }
    
    public static void emplenaTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        // Genera posició Inicial cuc
        int[] posCuc = UtilitatsArrays.generaArray(2,0, tauler.length-1);
        cuc.add(posCuc);
      
        // Genera posició de cada fulla 
        for (int i=0; i<NFULLES; i++) {
            afegeixFulla(tauler, cuc, fulles);
        }
    }
    
    public static void afegeixFulla(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        ArrayList<int[]> cucIfulles = new ArrayList<>();
        int[] posNovaFulla;  // posicio nova fulla
        boolean okFulla = true;

        cucIfulles.addAll(cuc);
        cucIfulles.addAll(fulles);
        
        do {
            posNovaFulla  = UtilitatsArrays.generaArray(2,0, NTAULER-1); // genera posició de la fulla
            // Recorre 'fulles' per veure que 'posFulla' és correcta
            okFulla = true;
            for (int[] pos : cucIfulles) {
                if (Arrays.equals(pos,posNovaFulla)) {
                    okFulla = false;
                    break;
                }
            }
        } while (!okFulla);
        
        // Afegeix fulla
        fulles.add(posNovaFulla);
    }
    
    public static boolean cambiaPosicio(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles, int accio) {  // torna 'true' si el 'cuc' es tropitja, 'false' en cas contrari
        int mida = tauler.length;
        int[] posFulla, posCuc;
        int[] posCucCap = new int[] { cuc.get(cuc.size()-1)[0],
                                      cuc.get(cuc.size()-1)[1] }; // posició actual del cap és la darrera posició de l'arraylist
        
        switch (accio) {
            case 4 -> // ESQ
                posCucCap[1] = (posCucCap[1] == 0 ? mida-1 : posCucCap[1]-1); 
            case 6  -> // DRETA
                posCucCap[1] = (posCucCap[1] == mida-1 ? 0 : posCucCap[1]+1); 
            case 8  -> // ALT
                posCucCap[0] = (posCucCap[0] == 0 ? mida-1 : posCucCap[0]-1); 
            case 2 -> //BAIX
                posCucCap[0] = (posCucCap[0] == mida-1 ? 0 : posCucCap[0]+1); 
        }
        
        // Cuc menja fulla ?
        for (int i=0; i < fulles.size(); i++) {
            posFulla = fulles.get(i);
            if (Arrays.equals(posFulla,posCucCap)) {
                cuc.add(posCucCap);
                fulles.remove(i);
                return true;
            }
        }
        
        // Cuc es tropitja ?
        for (int i=0; i < cuc.size(); i++) {
            posCuc = cuc.get(i);
            if (Arrays.equals(posCuc,posCucCap)) {
                return false;
            }
        }
        
        // Cuc es mou
        cuc.add(posCucCap); // afegim posCuc a cuc
        cuc.remove(0);  // eliminam cua a cuc

        return true;       
    }

    
    public static void netejaTauler(int[][] tauler){
        for (int i = 0; i < tauler.length; i++) 
            for (int j = 0; j < tauler[i].length; j++)
                tauler[i][j] = SIMBOL_BUIT;
    }    

    public static void situaCuc(int[][] tauler, ArrayList<int[]> cuc){
        int i=0;
        for (int[] posCuc : cuc) {
            tauler[posCuc[0]][posCuc[1]] = (i==cuc.size()-1 ? SIMBOL_CAPCUC: SIMBOL_CUC);
            i++;
        }
    }
    
    public static void situaFulles(int[][] tauler, ArrayList<int[]> fulles){
        for (int[] posFulla : fulles) {
            tauler[posFulla[0]][posFulla[1]] = SIMBOL_FULLA;
        }
    }
 
    public static void mostrarTauler(int[][] tauler, ArrayList<int[]> cuc, ArrayList<int[]> fulles) {
        String car="";
        
        netejaTauler(tauler);
        situaCuc(tauler, cuc);
        situaFulles(tauler, fulles);
              
        for (int i = 0; i < tauler.length; i++) {
            System.out.print('|');
            for (int j = 0; j < tauler[i].length; j++) {
                switch (tauler[i][j]) {
                    case SIMBOL_BUIT -> car = "   ";
                    case SIMBOL_FULLA -> car = " * ";
                    case SIMBOL_CAPCUC -> car = " O ";
                    case SIMBOL_CUC -> car = " . ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
}