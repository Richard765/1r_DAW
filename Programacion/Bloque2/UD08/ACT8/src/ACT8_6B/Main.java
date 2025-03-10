package ACT8_6B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Producte> productes = new ArrayList<Producte>();
        Client client = new Client("Pere", "Gómez");
        client.afegeixProducte(new Telefon("iPhone", 1200.0, 15.0, 8, 5, "Snapdragon", 16, 128));
        client.afegeixProducte(new Telefon("iPhone", 1200.0, 15.0, 8, 5, "Snapdragon", 16, 128));  // Repetit !!
        client.afegeixProducte(new Portatil("Dell XPS", 1500.0, 18.0, 12, 15, "Intel i5",16, 512));
        client.afegeixProducte(new Televisor("Samsung 4K", 800.0, 30.0, 36, 55, "Snapdragon",16, 256));
        client.afegeixProducte(new Gelera("Edesa no Frost", 500.0, 150.0, 24, 'A'));
        client.afegeixProducte(new Rentavaixelles("Electrolux", 450.0, 200.0, 24, 'B'));
        client.afegeixProducte(new Rentadora("AEG", 375.0, 175.0, 24,8, 'C'));
        //client.eliminaProducte("AEG");
        
        System.out.println(client.toString());       
    }
}
