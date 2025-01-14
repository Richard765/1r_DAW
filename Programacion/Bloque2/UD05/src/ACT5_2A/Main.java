/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT5_2A;

/**
 *
 * @author Richard
 */
public class Main {
    public static void main(String[] args) {
        Compte compte1 = new Compte();
        compte1.banc = "0001";
        compte1.oficina = "1100";
        compte1.dc = "01";
        compte1.numeroCompte= "1234567891";
        compte1.saldo = 0;
        
        Client client1 = new Client();
        client1.llinatge1 = "Exposito";
        client1.llinatge2 = "Medina";
        client1.nom = "Richard";
        client1.compte = compte1;
        
        client1.realitzaTransaccio(500.0);
        client1.realitzaTransaccio(-200.0);
        
        System.out.print("Cliente: " + client1.nom + " " + client1.llinatge1 + " " + client1.llinatge2 + "\nSaldo: " + client1.compte.saldo);
    }
}
