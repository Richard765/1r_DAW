/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT12_1A;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author Richard
 */
public class Main {
    public static void main(String[] args) {
        /*Filtra i processa la següent llista de nombres sencers per obtenir 
        només els números imparells, multiplicar-los per 2 i eliminar els duplicats.*/
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9); → [2, 6, 10, 14, 18];
        
        Predicate<Integer> numeros = x -> x % 2 == 0;
        
        /*Donada la següent llista de noms, mostra només els 3 primers noms 
        que comencen amb "J", saltant-se els 2 primers noms*/
        List<String> noms = Arrays.asList("Juan", "Jordi", "Joan", "Pere", "Maria", "Joaquim", "Jaume", "Judith"); → [Joan, Joaquim, Jaume];
        
        /*Comprovar si hi ha algun nom que conté la lletra "a" i comptar quants noms tenen més de 4 lletres.*/
        List<String> noms = Arrays.asList("Juan", "Jordi", "Joan", "Pere", "Maria", "Joaquim");

        /*Comprova si tots els números de la següent llista són positius i si cap número és major que 10.*/
        List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9);

        /*Donada la llista de preus de productes, calcular el preu amb descompte (descompte del 10%) 
        per a productes que tenen un preu superior a 50, eliminar els preus duplicats i mostrar només els primers 5 preus.*/
        List<Double> preus = Arrays.asList(120.5, 55.0, 75.0, 150.0, 50.0, 75.0, 120.5, 45.0, 60.0);

        /*Comptar quants estudiants tenen més de 18 anys, recollir els noms dels estudiants majors d'edat 
        en una llista i verificar si tots els estudiants són majors d'edat.*/
        List<Integer> edats = Arrays.asList(15, 19, 22, 17, 21, 18, 20, 16);

        /*Donada una llista de frases, filtrar aquelles que continguin la paraula "Java", eliminar 
        les duplicades i mostrar les primeres 3 frase.*/
        List<String> frases = Arrays.asList(
                    "Aprenent PHP és divertit", 
                    "Python és un llenguatge potent", 
                    "M'encanta programar en Java", 
                    "Java és potent", 
                    "PHP és fàcil d'aprendre");


        /*Donada una llista de nombres de telèfon, convertir-los a un format estàndard (eliminant els "-"), 
        eliminar els duplicats i finalment mostrar-los.*/
        List<String> telefons = Arrays.asList(
                    "123-456-789", 
                    "987-654-321", 
                    "123-456-789", 
                    "555-123-456", 
                    "987-654-321");

        /*Comprovar si cap número en una llista és negatiu, multiplicar per 10 els números positius i recollir el resultat en una llista.*/
        List<Integer> numeros = Arrays.asList(1, -2, 3, -4, 5);

    }
}
