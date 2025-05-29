package ACT10_2A;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main(String[] args) {
        Agenda agenda = new Agenda(new HashSet<>());
                
        // DIA 1/1/2004: Tasca1, Tasca2, Tasca3
        // Afegir un dia a l'agenda
        agenda.afegeixDia(LocalDate.of(2024, 1, 1), "Tasca1", "Tasca2", "Tasca3");
             
        // DIA 2/1/2004: Tasca1 
        agenda.afegeixDia(LocalDate.of(2024, 1, 2), "Tasca1");
        
        // DIA 3/1/2004: Tasca2, Tasca3 
        agenda.afegeixDia(LocalDate.of(2024, 1, 3), "Tasca1", "Tasca2");
        
        // DIA 2/1/2004: Tasca2, Tasca3 
        agenda.afegeixDia(LocalDate.of(2024, 1, 2), "Tasca2", "Tasca3");
        
        System.out.println(agenda.obteTasca(LocalDate.of(2024, 01, 02)));
        
        List agendaOrdenada = new ArrayList<>(agenda.dies);  // un 'Set' no es pot ordenar , cal transformar el 'Set' a 'ArrayList'
        
        Collections.sort(agendaOrdenada);
        
        System.out.println(agendaOrdenada);
    }
    
}
