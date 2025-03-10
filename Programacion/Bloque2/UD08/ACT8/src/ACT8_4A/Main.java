package ACT8_4A;

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
    }
    
    private static void creaConcessionariAutos(ConcessionariAutos concessionariAutos) {
        concessionariAutos.setAutomobil(new Automobil("Renault", "Megane", 25000.0, "Turisme", 4, 500.0));
        concessionariAutos.setAutomobil(new Automobil("Honda", "Civic", 22000.0, "Turisme", 4, 450.0));
    }
    
    private static void creaConcessionariMotos(ConcessionariMotos concessionariMotos) {
        concessionariMotos.setMotocicleta(new Motocicleta("Vespa", "Primavera", 2000.0, "Scotter", 125));
        concessionariMotos.setMotocicleta(new Motocicleta("Honda", "CBR", 15000.0, "Deportiva", 600));
    }

}
