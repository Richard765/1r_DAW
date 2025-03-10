package ACT8_7;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Afegir alguns llibres a la biblioteca
        biblioteca.afegeixLlibre(new Llibre("El Senyor dels Anells", "J.R.R. Tolkien", 1954, 25.0));
        biblioteca.afegeixLlibre(new Llibre("Cien a?os de soledad", "Gabriel García Márquez", 1967, 20.0));
        biblioteca.afegeixLlibre(new Llibre("1984", "George Orwell", 1949, 18.0));

        // Mostrar els llibres disponibles a la biblioteca
        System.out.println(biblioteca.toString());

        // Crear un client de la biblioteca
        Client client = new Client("Anna", "Martínez");

        // Prestar alguns llibres al client
        Llibre llibrePrestat1 = biblioteca.cercaLlibre("El Senyor dels Anells");
        Llibre llibrePrestat2 = biblioteca.cercaLlibre("Cien a?os de soledad");

        if (llibrePrestat1 != null) {
            client.prestaLlibre(llibrePrestat1);
        }

        if (llibrePrestat2 != null) {
            client.prestaLlibre(llibrePrestat2);
        }

        // Mostrar els llibres prestats pel client
        System.out.println("\nLlibres prestats per " + client.getNom() + " " + client.getCognom() + ":");
        for (Llibre llibre : client.getLlibresPrestats()) {
            System.out.println(llibre);
        }
    }
}
