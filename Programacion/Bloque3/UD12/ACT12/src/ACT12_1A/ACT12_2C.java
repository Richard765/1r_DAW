package ACT12_1A;

import java.util.Arrays;
import java.util.List;


public class ACT12_2C {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Juan", "Jordi", "Joan", "Pere", "Maria", "Joaquim");

        boolean algunAmbA = noms.stream().anyMatch(n -> n.contains("a")); // Comprovar si hi ha algun nom amb "a"
        
        long nomsLlarg = noms.stream()
            .filter(n -> n.length() > 4) // Filtrar noms amb més de 4 lletres
            .count(); // Comptar el nombre de noms

        System.out.println("Llista: " + noms);
        System.out.println("Hi ha algun nom amb la lletra 'a': " + algunAmbA);
        System.out.println("Noms amb més de 4 lletres: " + nomsLlarg);
    }
}
