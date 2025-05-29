package ACT12_1A;

import java.util.*;
import java.util.stream.*;

public class ACT12_2D {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9);

        boolean totsPositius = numeros.stream().allMatch(n -> n > 0); // Comprovar si tots els números són positius

        boolean capMajorDe10 = numeros.stream()
            .noneMatch(n -> n > 10); // Comprovar si cap número és major que 10

        System.out.println("Llista: " + numeros);
        System.out.println("Tots els numeros son positius: " + totsPositius);
        System.out.println("Cap numero es major que 10: " + capMajorDe10);
    }
}

