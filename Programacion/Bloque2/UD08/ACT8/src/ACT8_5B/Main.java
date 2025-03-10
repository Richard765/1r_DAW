package ACT8_5B;

import java.util.ArrayList;

import ACT8_5B.Tarjetes.*;
import ACT8_5B.Productes.*;
import ACT8_5B.Classes.*;

// En comptes de:
// import ACT8_5B.Tarjetes.Tarjeta;
// import ACT8_5B.Productes.Deposit;
// import ACT8_5B.Classes.Persona;
// import ACT8_5B.Productes.CompteEstalvis;
// import ACT8_5B.Productes.Hipoteca;
// import ACT8_5B.Productes.ProducteBancari;
// import ACT8_5B.Productes.FonsInversio;

/**
    |-- src
        |-- Productes
            |-- ProducteBancari.java
            |-- CompteEstalvis.java
            |-- Deposit.java
            |-- Hipoteca.java
            |-- FonsInversio.java
        |-- Tarjetes
            |-- Tarjeta.java
            |-- Credit.java
            |-- Debit.java
        |-- Classes
            |-- Persona.java
    |-- Main.java

 * @author winadmin
 */

public class Main {

    public static void main(String[] args) {
        ArrayList<ProducteBancari> productesBancaris = new ArrayList<>();
        
        CompteEstalvis compteEstalvis = new CompteEstalvis("0001-0001-0001", "CompteEstalvis1", 0, 0, 1000, new ArrayList<>());
        productesBancaris.add(compteEstalvis);
        Deposit deposit = new Deposit("0001-0001-0002", "Deposit1", 100, 2.5, 10);
        productesBancaris.add(deposit);
        Hipoteca hipoteca = new Hipoteca("0001-0001-0003", "Hipoteca1", 100, 5, 1, 10);
        productesBancaris.add(hipoteca);
        FonsInversio fonsInversio = new FonsInversio("0001-0001-0004", "FonsInversio1", 100, 5, 1, 10);
        productesBancaris.add(fonsInversio);
        
        Persona persona = new Persona("Joana Moragues", 27, productesBancaris );
        
        System.out.println(persona.toString() + "\n Total Remuneració: " + persona.calculaRemuneracioTotal());
    }
    
}
