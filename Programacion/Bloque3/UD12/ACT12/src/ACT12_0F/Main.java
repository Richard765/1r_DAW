package ACT12_0F;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // CONSUMER: Rep 'T' i no retorna cap resultat
        Consumer<String> imprimir = s -> System.out.println("Hola, " + s);
        imprimir.accept("Anna"); // Hola, Anna
        
        List<String> names = new ArrayList<>();
        names.add("Anna"); 
        names.add("Pere"); 
        names.add("Joan");
        names.add("Patricia");
        
        
        // Versión imperativa
        for (String n : names) 
            System.out.println(n);
        
        // Versió funcional
        // names.forEach( name -> System.out.println(name) );  // Consumer
        // 'forEach' admet un 'Consumer'
        names.forEach( imprimir );  // Consumer
    }
}

