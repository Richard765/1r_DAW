package ACT8_8;

// Interfície per als vehicles de motor
abstract class VehiclePersonal extends Vehicle {
    private boolean esElectric;
    
    public VehiclePersonal(String matricula, String marca, String model, int any, boolean esElectric) {
        super(matricula, marca, model, any);
        this.esElectric = esElectric;
    }
    
    @Override
    public double calculaImposts() {
        return (this.esElectric ? 50 : 0);
    }
    
    @Override
    public double calculaManteniment() {
        return 75;
    }
    
}