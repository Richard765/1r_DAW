package ACT10_6D;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArrayMax'
        ArrayDeque<Tasca> tasques = new ArrayDeque<>();  // nombre màxim d'elements permès? 5
        
        // Prova de 'ArrayMax'
        tasques.push(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.push(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.push(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.push(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasques.push(new Tasca(LocalDate.now(), "Sopar"));
        tasques.push(new Tasca(LocalDate.now(), "Domir"));
        System.out.println(tasques.pop());
        System.out.println("-------------------");
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        
        System.out.println("-------------------");
        System.out.println(tasques.pop());
    }
}

