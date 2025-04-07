package ACT10_3;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.afegeixLlibre(1,"El Quijote", "Miguel de Cervantes", 1605);
        biblioteca.afegeixLlibre(2,"El Quijote", "Miguel de Cervantes", 1605);
        biblioteca.afegeixLlibre(3, "Don Segundo Sombra", "Joan Cruz", 1926);
        biblioteca.afegeixLlibre(4, "La Sombra del Viento", "Carlos Ruiz Zafón", 2001);
        
        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();
        System.out.println("-----------------------------------------");
        
        biblioteca.prestaLlibre("El Quijote");
        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();
        System.out.println("-----------------------------------------");

        biblioteca.tornaLlibre();       
        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();
        
        System.out.println("-----------------------------------------");
        biblioteca.mostraTitolsDisponibles();

    }
}
