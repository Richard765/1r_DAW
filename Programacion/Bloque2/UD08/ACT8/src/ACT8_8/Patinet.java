package ACT8_8;

// Classe Bicicleta que només hereta de Vehicle
class Patinet extends VehiclePersonal {

    public Patinet(String matricula, String marca, String model, int any, boolean esElectrica) {
        super(matricula, marca, model, any, esElectrica);
    }
    
    //@Override
    //public double calculaImposts() {
    //    return super.calculaImposts() + 20;
    //}
}

