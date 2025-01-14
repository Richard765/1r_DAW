/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT5_2A;

/**
 *
 * @author Richard
 */
public class Compte {
    public String banc;  // codi banc: String 4 posicions
    public String oficina;  // codi oficina: String 4 posicions
    public String dc;  // digits control: String 2 posicions
    public String numeroCompte; // núm compte: String 10 posicions
    public double saldo;  // no és possible un valor negatiu per aquest atribut



    public void ingresa(double quantitat) {
        saldo = saldo + quantitat;
        
    }

    public void reintegra(double quantitat) {
        if (quantitat <= saldo) {
            saldo = saldo - quantitat;
        } else if (quantitat > saldo) {
           System.out.println("Saldo insuficiente.");
        }
    }
}