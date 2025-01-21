package ACT5_1B;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Ciclo {
    public int idCiclo;
    public String nommbre;
    public int numAlumnos;
    public ArrayList<Modulo> modulos;
    //
    public static int contadorCiclos=1;
    
    public String muestraCiclo() {
        String text;
        
        text = "Ciclo: " + "ID=" + idCiclo + ", nombre=" + nombre + ", numAlumnos=" + numAlumnos + 
               "; \n\t" +
               "Mòduls: {";
        for (Modul modul: modulos) {
            text = text + modul.idModulo + "-" + modulo.nombre + " ";
        }
        text = text +"}";
        
        return text;
    }   
    
    private int cercaModul(String nom) {
        for (int i=0; i<modulos.size(); i++) {
            if (modulos.get(i).nom.equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return -1;
    }
    
    public void afegeixModul(Modul modul) {
        modulos.add(modulo);
    }
    
    public boolean eliminaModul(String nom) {
        int i = buscarModulo(nombre);
        
        if (i >= 0) {
            modulos.remove(i);
            return true;
        }
        return false;
    }
    
}