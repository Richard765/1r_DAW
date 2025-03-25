/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT10_2;

import java.time.LocalDate;
import java.util.HashSet;

/**
 *
 * @author Richard
 */
public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(new HashSet<>());
                
        // DIA 1/1/2004: Tasca1, Tasca2, Tasca3
        // Afegir un dia a l'agenda
        agenda.afegeixDia(LocalDate.of(2024, 1, 1), "Tasca1","Tasca2","Tasca3");
             
        // DIA 2/1/2004: Tasca1 
        agenda.afegeixDia(LocalDate.of(2024, 1, 2), "Tasca1");
        
        // DIA 3/1/2004: Tasca2, Tasca3 
        agenda.afegeixDia(LocalDate.of(2024, 1, 3), "Tasca1", "Tasca2");
        
        // DIA 2/1/2004: Tasca2, Tasca3 
        agenda.afegeixDia(LocalDate.of(2024, 1, 2), "Tasca2", "Tasca3");
        
        System.out.println(agenda.obteTasca(LocalDate.of(2024, 01, 02)));
    }
}
