/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT10_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Richard
 */
public class Biblioteca {
    private Set<Llibre> llibresDisponibles;
    private Queue<Llibre> llibresPrestats;
    private Map<String, List<Llibre>> titolsDisponibles;

    //Constructor
    public Biblioteca() {
        llibresDisponibles = new HashSet<>();
        llibresPrestats = new LinkedList<>();
        titolsDisponibles = new HashMap<>();
    }
    
    //Metodos
    public void afegeixLlibre(int idLlibre, String titol, String autor, int anyPublicacio) {
        Llibre llibre = new Llibre(idLlibre, titol, autor, anyPublicacio);
        this.llibresDisponibles.add(llibre);
        
        if (!titolsDisponibles.containsKey(titol)) {
            this.titolsDisponibles.put(titol, new ArrayList<>());
        }
        
        this.titolsDisponibles.get(titol).add(llibre);
    }
    
    public Llibre cercaLlibreDisponible(String titol) {
        for (Llibre l : this.llibresDisponibles) {
            if (l.getTitol().equals(titol)) {
                return l;
            }
        }
        return null;
    }
    
    public void prestaLlibre(String titol){
        Llibre l = cercaLlibreDisponible(titol);
        if (l != null) {
            this.llibresDisponibles.remove(l);
            this.llibresPrestats.offer(l);
        }
    }
    
    public void tornaLlibre() {
        Llibre l = llibresPrestats.poll();
        if (llibresPrestats != null) {
            this.llibresDisponibles.add(l);
        }
    }
    
    public void mostraLlibresDisponibles() {
        for (Llibre l : llibresDisponibles) {
            System.out.println(l.toString());
        }
    }
    
    public void mostraTitolsDisponibles() {
        for (String t : titolsDisponibles.keySet()) {
            System.out.println(t + " " + this.titolsDisponibles.get(t).toString());
        }
    }
    
    public void mostraLlibresPrestats() {
        for (Llibre l : llibresPrestats) {
            System.out.println(l.toString());
        }
    }
}
