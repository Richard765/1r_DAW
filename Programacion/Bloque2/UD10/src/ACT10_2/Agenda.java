/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT10_2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Richard
 */
public class Agenda {
    Set<Dia> dies;  // sols emmagatzema els 'Dia' on hi ha tasques

    // Mètodes:
    public Dia cercaDia(String data) {
        for (Dia d : this.dies) {
            if (d.data.isEqual(data))
                return d;
        }
        return null;
    }
    //cerca en l''Agenda' la 'data' cercada, si es troba torna 'Dia' , sino 'null' 
    
    public void afegeixDia(String data, String ... atasques)  {
        Queue<String> tasques = new LinkedList<>();
        Dia dia = cercaDia(data);

        if (dia == null) {
            for (String a:atasques)
                tasques.offer(a);
            Dia nouDia = new Dia(data, tasques);
            this.dies.add(nouDia);
        } else {
            for (String a:atasques)
                dia.tasques.offer(a);
        }
    }
    //afegeix una 'data' a l''Agenda' amb la llista de 'atasques'
    public String obteTasca(LocalDate data) {
        Dia dia = cercaDia(data);
        if (dia != null)
            return dia.tasques.poll();
        else
            return null;
    }
    
    //mostra la primera tasca disponible per el dia consultat, 'null' si no hi ha tasques
    //NOTA: l'estructura 'Set' planteja la implementació d''equals' i 'hashcode()' que cal avaluar

}
