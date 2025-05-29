package ACT12_0H;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // FUNCION: Rep 'T', retorna 'R'
        Function<String, Integer> longitud = s -> s.length();
        System.out.println(longitud.apply("Hola")); // 4
        
        // BiFunction
        BiFunction<Integer, Integer, Double> dividir = (numerador, divisor) -> Double.valueOf(numerador / divisor);
        System.out.println(dividir.apply(8,2));
    }
}

