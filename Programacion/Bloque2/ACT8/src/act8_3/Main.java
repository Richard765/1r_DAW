/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act8_3;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Main {
    public static void main(String[] args) {
        Llibre llibre = new Llibre("John Doe", "Alas de sangre", 2019, 15.0);
        Revista revista = new Revista(24, 8.0, "El corazon", 2025);

        Publicacio[] publicacions = {llibre, revista};

        for (Publicacio p : publicacions) {
            System.out.println(p.toString());
            System.out.println("--------------");
        }
    }
}