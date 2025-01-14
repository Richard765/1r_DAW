/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT5_2A;

/**
 *
 * @author Richard
 */
public class Client {
    public String llinatge1;
    public String llinatge2;
    public String nom;
    public Compte compte = new Compte(); //Compte unic del client


    //Metodos
    public void realitzaTransaccio(double quantitat) {
        if (quantitat > 0) {
            compte.ingresa(quantitat);
        } else if (quantitat < 0) {
            compte.reintegra(Math.abs(quantitat));
        }
    } 
}
    
