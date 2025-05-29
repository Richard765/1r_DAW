package ACT10_6A;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArraySet'
        ArraySet<Tasca> tasques = new ArraySet<>();
       
        // Prova de 'ArraySet'
        tasques.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.add(new Tasca(LocalDate.now(), "Anar a classe"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Comprar menjar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Fer els ejercicis"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Sopar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Domir"));  // Error: no s'admeten 2 tasques pel mateix dia
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }

    }
}

