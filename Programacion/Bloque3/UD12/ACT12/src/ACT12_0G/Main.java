package ACT12_0G;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // CONSUMER
        Consumer<String> imprimir = s -> System.out.println("Hola, " + s);
        imprimir.accept("Anna"); // Hola, Anna
        
        // PREDICATE: Rep 'T', retorna 'true' o 'false'
        Predicate<String> validador = name -> name.length() > 5;  // amb 1 instrucción, no cal explicitar el 'return'
        System.out.println(validador.test("Pere"));  // false
        
        List<String> names = List.of("Anna", "Pere", "Joan", "Patricia");
        
        // Versión imperativa
        for (String name : names)
            // if (name.length() > 5)
            if (validador.test(name))
                System.out.println(name);
        
        // Versió funcional
        // names.stream().
        //       filter( name -> name.length() > 5).  // Predicate
        //       forEach( name->System.out.println(name) );  // Consumer
        // 'filter' admet un 'Predicate'; 'forEach' admet un 'Consumer'
        names.stream().filter( validador ).forEach( imprimir );  // "Patricia"
    }
}

