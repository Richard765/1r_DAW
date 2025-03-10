package ACT8_8;

// Classe Cotxe que hereta de Vehicle i implementa VehicleMotor
class Cotxe extends VehicleMotor {

    public Cotxe(String matricula, String marca, String model, int any, double potencia) {
        super(matricula, marca, model, any, potencia);
    }
    
    //@Override
    //public double calculaManteniment() {
    //    return super.calculaManteniment() + 100;
    //}
}
