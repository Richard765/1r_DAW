package ACT10_4;

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
        biblioteca.afegeixAnomalia(1, Anomalia.LLOM);
        biblioteca.afegeixAnomalia(1, Anomalia.LLOM);

        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();
        System.out.println("-----------------------------------------");

        biblioteca.tornaLlibre(); 
        biblioteca.eliminaAnomalia(1, Anomalia.LLOM);
        biblioteca.mostraLlibresDisponibles();
        biblioteca.mostraLlibresPrestats();
        System.out.println("-----------------------------------------");

    }
}
