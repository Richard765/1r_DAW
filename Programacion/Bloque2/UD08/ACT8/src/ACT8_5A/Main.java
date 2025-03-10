package ACT8_5A;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ProducteBancari> productesBancaris = new ArrayList<>();
        
        CompteEstalvis compteEstalvis = new CompteEstalvis("0001-0001-0001", "CompteEstalvis1", 0, 0, 1000, new ArrayList<Tarjeta>());
        productesBancaris.add(compteEstalvis);
        Deposit deposit = new Deposit("0001-0001-0002", "Deposit1", 100, 2.5, 10);
        productesBancaris.add(deposit);
        Hipoteca hipoteca = new Hipoteca("0001-0001-0003", "Hipoteca1", 100, 5, 1, 10);
        productesBancaris.add(hipoteca);        
        
        Persona persona = new Persona("Joana Moragues", 27, productesBancaris );
        
        System.out.println(persona.toString() + "\n Total Remuneració: " + persona.calculaRemuneracioTotal());
    }
    
}
