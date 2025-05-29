package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2H {
    public static void main(String[] args) {
        List<String> telefons = Arrays.asList(
            "123-456-789", 
            "987-654-321", 
            "123-456-789", 
            "555-123-456", 
            "987-654-321");

        System.out.println("Llista: " + telefons);
        telefons.stream()
                .map(t -> t.replace("-", "")) // Eliminar els guions per obtenir el número en format continu
                .distinct() // Eliminar duplicats
                .forEach(n -> System.out.println(n)); // Mostrar els números de telèfon resultants
    }
}
