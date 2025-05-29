package ACT12_0K;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Bernat", "Carla", "Anna");
        
        // MAP
        List<Integer> nameLengths = names.stream().map(name -> name.length()).collect(Collectors.toList());
        List<String> nameUpperCase = names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        
        // FILTER
        List<String> namesStartWithA = names.stream().filter(name -> name.startsWith("a")).collect(Collectors.toList());
        
        // SORTED
        List<String> nameSorted   = names.stream().sorted().collect(Collectors.toList());
        
        // DISTINCT
        List<String> uniqueNames = names.stream().distinct().collect(Collectors.toList());
        
        // LIMIT
        List<String> uniqueNames3 = names.stream().limit(3).collect(Collectors.toList());
        
        // SKIP
        List<String> uniqueNames2 = names.stream().skip(2).collect(Collectors.toList());
        
        // COLLECT
        List<String> names2 = names.stream().collect(Collectors.toList());
        
        // FOREACH
        names.stream().forEach(name -> System.out.println(name)); // Equivalent a System.out::println
        
        // COUNT
        long count = names.stream().count();
        
        // ANYMATCH
        boolean hasAnyA = names.stream().anyMatch(name -> name.startsWith("a"));
        
        // ALLMATCH
        boolean hasAllA = names.stream().allMatch(name -> name.startsWith("a"));
        
        // NONEMATCH
        boolean hasNoneA = names.stream().noneMatch(name -> name.startsWith("a"));
        
        
        System.out.println(names);
        System.out.println(nameUpperCase);
        
    }
    
}
