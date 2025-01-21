package ACT5_1B;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Instituto {

    public static void main (String[] args) {
        // Mňduls DAW
        Modulo modulo1 = new Modulo();
        modulo1.idModulo = Modulo.contadorModulos++; modulo1.nombre = "Programació"; modulo1.horasSemanales=7;
        Modulo modulo2 = new Modulo();
        modulo2.idModulo = Modulo.contadorModulos++; modulo2.nombre = "Gestió de Base de Dades"; modulo2.horasSemanales=8;
        Modulo modulo3 = new Modulo();
        modulo3.idModulo = Modulo.contadorModulos++; modulo3.nombre = "Llenguatge de Marques"; modulo3.horasSemanales=4;
        Modulo modulo4 = new Modulo();
        modulo4.idModulo = Modulo.contadorModulos++; modulo4.nombre = "Sistemes d'Informació"; modulo4.horasSemanales=7;
        Modulo modulo5 = new Modulo();
        modulo5.idModulo = Modulo.contadorModulos++; modulo5.nombre = "Entorns de Desenvolupament"; modulo5.horasSemanales=3;
        // Mňduls d'ASIX
        // ...
        // Mňduls d'SMX
        // ...

        // Cicle DAW
        Ciclo ciclo1 = new Ciclo();
        ciclo1.idCiclo = Cicle.contadorCiclos++; ciclo1.nom = "Desenvolupament Aplicacions Web"; ciclo1.numAlumnos = 25; ciclo1.modulos = new ArrayList<Modulo>();

        ciclo1.colocarModulo(modulo1);  // cicle1.moduls.add(modul1);
        ciclo1.colcoarModulo(modulo2);  // cicle1.moduls.add(modul2);
        ciclo1.colocarModulo(modulo3);  // cicle1.moduls.add(modul3);
        ciclo1.colocarModulo(modulo4);  // cicle1.moduls.add(modul4);
        ciclo1.colocarModulo(modulo5);  // cicle1.moduls.add(modul5);

        // Cicle ASIX
        Ciclo ciclo2 = new Ciclo();
        ciclo2.idCiclo = Ciclo.contadorCiclos++; ciclo2.nombre = "Administració de sistemes en xarxa"; ciclo2.numAlumnos = 25; ciclo2.modulos = new ArrayList<Modulo>();
        // ...

        // Cicle SMX
        // ...

        // Mostrar
        System.out.println(ciclo1.muestraCiclo());
        System.out.println(ciclo2.muestraCiclo());
        // System.out.println(cicl3.mostraCicle());
            
    }
}