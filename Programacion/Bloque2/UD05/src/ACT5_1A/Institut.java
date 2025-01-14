/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT5_1A;

/**
 *
 * @author Richard
 */
public class Institut {

    public static void main (String[] args) {
        // Cicle
        Cicle cicle = new Cicle();
        cicle.idCicle = 1; cicle.nom = "Desenvolupament Aplicacions Web"; cicle.numAlumnes = 25;

        // Mňduls DAW
        Modul modul1 = new Modul();
        modul1.idModul = 1; modul1.nom = "Programació"; modul1.idCicle=1; modul1.horesSetmanals=7;
        Modul modul2 = new Modul();
        modul2.idModul = 2; modul2.nom = "Gestió de Base de Dades"; modul2.idCicle=1; modul2.horesSetmanals=8;
        Modul modul3 = new Modul();
        modul3.idModul = 3; modul3.nom = "Llenguatge de Marques"; modul3.idCicle=1; modul3.horesSetmanals=4;
        Modul modul4 = new Modul();
        modul4.idModul = 4; modul4.nom = "Sistemes d'Informació"; modul4.idCicle=1; modul4.horesSetmanals=7;
        Modul modul5 = new Modul();
        modul5.idModul = 5; modul5.nom = "Entorns de Desenvolupament"; modul5.idCicle=1; modul5.horesSetmanals=3;
        // Mňduls d'ASIX
        // ...
        // Mňduls d'SMX
        // ...

        // Mostrar
        System.out.println(cicle.mostraCicle());
        System.out.println("\t"+modul1.mostraModul(cicle.idCicle));
        System.out.println("\t"+modul2.mostraModul(cicle.idCicle));
        System.out.println("\t"+modul3.mostraModul(cicle.idCicle));
        System.out.println("\t"+modul4.mostraModul(cicle.idCicle));
        System.out.println("\t"+modul5.mostraModul(cicle.idCicle));
        
        // Falta afegir els mňduls d'ASIX i SMX
        // ...

    }
}