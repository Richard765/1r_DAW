package ACT10_2A;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author winadmin
 */
public class Agenda {
    Set<Dia> dies;

    // Constructor
    public Agenda(Set<Dia> dies) {
        this.dies = dies;
    }
    
    public void afegeixDia(LocalDate data, String ... atasques) {
        Dia dia = cercaDia(data);
        
        if ( dia == null) {  // afegir atasques a tasques
            Queue<String> tasques = new LinkedList<>();
            for (String a:atasques)
                // Afegir tasques
                tasques.offer(a);
            this.dies.add( new Dia(data, tasques) );
        } else {
            for (String a:atasques)
                dia.tasques.offer(a);
        }
    }
    
    public Dia cercaDia(LocalDate data) {
        for (Dia d :this.dies) {
            if (d.data.isEqual(data))
                return d;
        }
        return null;
    }
    
    public String obteTasca(LocalDate data) {
        Dia dia = cercaDia(data);
        if (dia != null)
            return dia.tasques.poll();
        else
            return null;
    }

}
