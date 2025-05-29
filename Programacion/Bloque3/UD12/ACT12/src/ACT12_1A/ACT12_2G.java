package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2G {
    public static void main(String[] args) {
        List<String> frases = Arrays.asList(
            "Aprenent PHP és divertit", 
            "Python és un llenguatge potent", 
            "M'encanta programar en Java", 
            "Java és potent", 
            "PHP és fàcil d'aprendre");

        System.out.println("Llista: " + frases);
        frases.stream()
              .filter(f -> f.contains("Java")) // Filtrar frases que continguin la paraula "Java"
              .distinct() // Eliminar duplicats
              .skip(0) // Saltar cap frase (opcional, afegit per mostrar el funcionament de skip)
              .limit(3) // Mostrar només les primeres 3 frases
              .forEach(f -> System.out.println(f)); // Mostrar les frases resultants
    }
}

