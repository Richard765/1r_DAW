package ACT4_4;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class UtilitatsClasses {
        
    /**
     *
     * @param array
     */
    public static void mostrarArrayListInt(ArrayList<Integer> array) {
        System.out.print("[ ");
        for (Integer a : array) {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }
    
        public static void mostrarArrayListStr(ArrayList<String> array) {
        System.out.print("[ ");
        for (String a : array) {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }

    /**
     * Crear un ArraList 
     *      s'avalua cada element de l'array en l'ArrayList
     * @return ArrayList 
     */    
    public static ArrayList<Integer> mostrarDiferents(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        for (Integer num: array) {
            if (! resultat.contains(num)) // si 'num' no es troba en 'resultat', s'afegeix
                resultat.add(num);		
        }
        return resultat;
    }
    
    /**
     * Transforma un int[] a un ArrayList<Integer>
     * @param array --> int[]
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> arrayToArrayListInt(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int a : array) {
            arrayList.add(a);
        }
        
        return arrayList;
    }
    
    /**
    * Crear un ArrayList 
    *      s'avalua cada element de l'array en l'ArrayList
    *      si l'ArrayList es mantÃ© ordenat es poden estalviar 
    *      moltes lectures
    * @return ArrayList ordenat
    */
    public static ArrayList<Integer> mostrarDiferentsMillorat(int[] array) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        for (int num : array) {
            int i = 0; // index on cal insertar en 'resultat'
            boolean trobat = false;
            
            for (Integer r : resultat) { // es cerca 'num' dins 'resultat'
                if( r == num) { // trobat, no cal insertar
                    trobat = true;
                    break;
                } else if (r > num) // no trobat, ni es trobarà  si l'ArrayList es manté ordenat, cal insertar
                    break;
                else // seguir cercant dins 'resultat'
                    i++;
            }
            if (!trobat) // afegir 'num' en la posició 'i' per mantenir l'ArrayList ordenat
                resultat.add(i,num);
        }
        
        return resultat;
    }
    
}