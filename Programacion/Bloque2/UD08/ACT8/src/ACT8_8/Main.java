package ACT8_8;

// Classe Main per a proves
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller("AutoFix");
        taller.afegeixVehicle(new Cotxe("ABC123","Toyota", "Corolla", 2020, 150));
        taller.afegeixVehicle(new Cotxe("DEF456","BMW", "M3", 2018, 300));
        taller.afegeixVehicle(new Cotxe("HIJ789","EBRO", "NNA", 2011, 800));
        taller.afegeixVehicle(new Bicicleta("X","Orbea", "MX40", 2022, false));
        taller.afegeixVehicle(new Bicicleta("Y","PatinY", "RB1290", 2024, true));
        taller.afegeixVehicle(new Bicicleta("Z","PatinZ", "zxB1320", 2025, true));
        taller.eliminaVehicle("Z");
        
        taller.getVehicles().get(0).afegeixReparacio(new Reparacio("Reparacio1", 100));
        taller.getVehicles().get(0).afegeixReparacio(new Reparacio("Reparacio2", 200));
        taller.getVehicles().get(0).afegeixReparacio(new Reparacio("Reparacio3", 300));
        taller.getVehicles().get(0).eliminaReparacio("Reparacio3");
        taller.getVehicles().get(0).eliminaReparacio("Reparacio4");  // no existeix
        System.out.println(taller);
    }
}
