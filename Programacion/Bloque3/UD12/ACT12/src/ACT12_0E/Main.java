package ACT12_0E;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList(
            new Persona("Marc", 35),
            new Persona("Joan", 25),
            new Persona("Anna", 30)
        );

        // EMPRANT 'Collections.sort' 
        Collections.sort(persones);  // ordenat per l''ordre natural'
        System.out.println(persones);  // [Persona{nom=Anna, edat=30}, Persona{nom=Joan, edat=25}, Persona{nom=Marc, edat=35}]
        
        // EMPRANT 'Collections.sort'
        // Collections.sort(persones, new ComparadorPersonaPerEdat());
        
        // EMPRANT 'list.sort' 
        persones.sort(null);  // ordenat per l''ordre natural'
        System.out.println(persones);  // [Persona{nom=Anna, edat=30}, Persona{nom=Joan, edat=25}, Persona{nom=Marc, edat=35}]
        // EMPRANT la classe explícita
        // persones.sort( new ComparadorPersonaPerEdat() );  
        
        // EMPRANT una classe (interfícia) anònima 
        persones.sort( new Comparator<Persona>() {
                                                    @Override
                                                    public int compare(Persona p1, Persona p2) {
                                                        return Integer.compare(p1.getEdat(), p2.getEdat());
                                                    }
                                                  }
                     );
        
        // EMPRANT funcions lambda de la interfície funcional 'Comparator'
        // versió lambda detallada
        persones.sort( (Persona p1, Persona p2) -> { int resultat;
                                                     resultat = Integer.compare(p1.getEdat(), p2.getEdat());
                                                     return resultat;
                                                   }
                      );
        // versió lambda reduïda
        persones.sort( (p1, p2) -> Integer.compare(p1.getEdat(), p2.getEdat()) );  // ordenat segons la Interfície funcional 'Comparator' (o la seva lambda)
        System.out.println(persones);  // [Persona{nom=Joan, edat=25}, Persona{nom=Anna, edat=30}, Persona{nom=Marc, edat=35}]
        
    }
}
