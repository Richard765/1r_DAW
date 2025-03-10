package ACT8_7;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Biblioteca {
    private ArrayList<Llibre> llibres;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    public void afegeixLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre cercaLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equals(titol)) {
                return llibre;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String text = "Llibres disponibles a la biblioteca: ";
        for (Llibre llibre : llibres)
            text += "\n\t" + llibre;
        
        return text;
    }
}