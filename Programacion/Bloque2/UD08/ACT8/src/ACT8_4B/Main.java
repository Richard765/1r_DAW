package ACT8_4B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        // Creació de concessionaris i vehicles
        ConcessionariAutos concessionariAutos = new ConcessionariAutos();
        creaConcessionariAutos(concessionariAutos);

        ConcessionariMotos concessionariMotos = new ConcessionariMotos();
        creaConcessionariMotos(concessionariMotos);

        // Mostrar resultats
        System.out.println(concessionariAutos.toString());
        System.out.println(concessionariMotos.toString());
        System.out.println("Ingressos del Concesionari de Autos: " + concessionariAutos.calculaIngressos());
        System.out.println("Ingressos del Concesionari de Motos: " + concessionariMotos.calculaIngressos());
        
        // -----------------------------------------
        
        ArrayList<ArrayList<Vehicle>> concesionari = new ArrayList<Vehicle>();
        
        ArrayList<Vehicle> motos = new ArrayList<Vehicle>();
        motos.add(new Motocicleta("Vespa", "Primavera", 2000.0, "Scotter", 125));
        
        ArrayList<Vehicle> autos = new ArrayList<Vehicle>();
        autos.add(new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0));
        
        ArrayList<Vehicle> camions = new ArrayList<Vehicle>();
        camions.add(new Camio("Ebro", "Santana",10000, "Truck", 500.0));
        
        
        concesionari.add(motos);
        concesionari.add(autos);
        concesionari.add(camions);
    }
    
    private static void creaConcessionariAutos(ConcessionariAutos concessionariAutos) {
        concessionariAutos.setVehicle(new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0));
        concessionariAutos.setVehicle(new Automobil("Honda", "Civic", 22000.0, "Turisme", 4, 450.0));
        concessionariAutos.setVehicle(new Camio("Pegasus", "Brabus",15000,"Trucker", 5000.0));
        concessionariAutos.setVehicle(new Camio("Ebro", "Santana",10000, "Truck", 500.0));
        concessionariAutos.setVehicle(new Motocicleta("Labretta", "Model D", 3300.0, "Scotter", 125));
        
    }
    
    private static void creaConcessionariMotos(ConcessionariMotos concessionariMotos) {
        concessionariMotos.setMotocicleta(new Motocicleta("Vespa", "Primavera", 2000.0, "Scotter", 125));
        concessionariMotos.setMotocicleta(new Motocicleta("Honda", "CBR", 15000.0, "Deportiva", 600));
    }

}
