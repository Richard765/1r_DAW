package ACT8_8;

// Interfície per als vehicles de motor
abstract class VehicleMotor extends Vehicle {
    private double potencia;
    
    public VehicleMotor(String matricula, String marca, String model, int any, double potencia) {
        super(matricula, marca, model, any);
        this.potencia = potencia;
    }
    
    @Override
    public double calculaImposts() {
        return this.potencia * 0.02;
    }
    
    @Override
    public double calculaManteniment() {
        double total = this.potencia * 0.20;
        
        if (this instanceof Camio)
            total += 500;
        else if (this instanceof Cotxe)
            total += 100;
        else if (this instanceof Moto)
            total += 50;
        return total;
    }

}
