package ACT8_8;

// Classe Cotxe que hereta de Vehicle i implementa VehicleMotor
class Camio extends VehicleMotor {
    boolean esFrigorific;

    public Camio(String matricula, String marca, String model, int any, double potencia, boolean esFrigorific) {
        super(matricula, marca, model, any, potencia);
        this.esFrigorific = esFrigorific;
    }
    
    @Override
    public double calculaImposts() {
 
        return super.calculaImposts() + (this.esFrigorific ? 5 : 0);

    }
    //@Override
    //public double calculaManteniment() {
    //    return super.calculaManteniment() + 500;
    //}
}
