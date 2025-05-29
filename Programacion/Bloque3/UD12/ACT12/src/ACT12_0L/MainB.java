package ACT12_0L;

import java.util.*;
import java.util.function.BiPredicate;

public class MainB {
    public static void main(String[] args) {
        List<String> grupA = List.of("Anna", "Pere", "Joan", "Maria");
        List<String> grupB = List.of("Maria", "Oriol", "Joan");

        BiPredicate<String, List<String>> existeix = (nom, llista) -> llista.contains(nom);

        grupA.stream()
             .filter(nom -> existeix.test(nom, grupB))
             .forEach(System.out::println);  // "Maria", "Joan"
    }
}