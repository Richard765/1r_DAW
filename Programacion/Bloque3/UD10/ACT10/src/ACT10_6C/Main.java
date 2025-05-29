package ACT10_6C;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArrayMax'
        ArrayQueue<Tasca> tasques = new ArrayQueue<>();  // nombre màxim d'elements permès? 5
        
        // Prova de 'ArrayMax'
        tasques.offer(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.offer(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.offer(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.offer(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasques.offer(new Tasca(LocalDate.now(), "Sopar"));
        tasques.offer(new Tasca(LocalDate.now(), "Domir"));
        System.out.println(tasques.poll());
        System.out.println("-------------------");
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        System.out.println("-------------------");
        System.out.println(tasques.poll());
    }
}

