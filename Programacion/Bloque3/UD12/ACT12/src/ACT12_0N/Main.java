package ACT12_0N;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Anna", "Pere", "Joan", "Oriol", "Eva", "Maria", "Leo", "Marc");

        Collector<String, Map<Integer, List<String>>, Map<Integer, List<String>>> agruparPerLongitud = Collector.of(
            // 1. Supplier – crea un map buit
            HashMap::new,

            // 2. Accumulator – afegeix cada nom a la llista del map segons la seva longitud
            (mapa, nom) -> {
                int llargada = nom.length();
                mapa.computeIfAbsent(llargada, k -> new ArrayList<>()).add(nom);
            },

            // 3. Combiner – combina dos mapes (stream paral·lel)
            (mapa1, mapa2) -> {
                for (Map.Entry<Integer, List<String>> entry : mapa2.entrySet()) {
                    mapa1.merge(entry.getKey(), entry.getValue(), (llista1, llista2) -> {
                        llista1.addAll(llista2);
                        return llista1;
                    });
                }
                return mapa1;
            },

            // 4. Finisher – retorna el mapa acumulat
            Function.identity()
        );

        Map<Integer, List<String>> resultat = noms.stream().collect(agruparPerLongitud);

        resultat.forEach((longitud, nomsAmbLongitud) -> 
            System.out.println("Longitud " + longitud + ": " + nomsAmbLongitud)
        );
    }
}