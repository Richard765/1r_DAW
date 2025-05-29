package ACT12_0I;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // SUPPLIER: No rep cap argument retorna 'T'
        Supplier<Double> numAleatori = () -> Math.random();  // 'return' explícit
        System.out.println(numAleatori.get());  // Ex: 0.75432
        
        Supplier<Persona> personaGenerator = () -> new Persona();
        Persona p = personaGenerator.get();
    }
}

