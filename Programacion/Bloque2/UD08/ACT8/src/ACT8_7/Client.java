package ACT8_7;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Client {
    private String nom;
    private String cognom;
    private ArrayList<Llibre> llibresPrestats;

    public Client(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
        this.llibresPrestats = new ArrayList<>();
    }

    public void prestaLlibre(Llibre llibre) {
        llibresPrestats.add(llibre);
    }

    // Getters i setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public ArrayList<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void setLlibresPrestats(ArrayList<Llibre> llibresPrestats) {
        this.llibresPrestats = llibresPrestats;
    }
}