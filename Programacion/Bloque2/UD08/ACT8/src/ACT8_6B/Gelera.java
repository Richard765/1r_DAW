package ACT8_6B;

public final class Gelera extends Electrodomestic {

    public Gelera(String nom, double preu, double consumEnergetic, int garantiaMesos, char classeEnergetica) {
        super(nom, preu, consumEnergetic, garantiaMesos, classeEnergetica);
    }
    
    @Override
    public String toString() {
        return "Gelera {" + super.toString() + "} Preu: " + super.getPreuBase() + " " + this.calculaSuplement();
    }
    
    //@Override
    //public double calculaSuplement() {
    //    return 0;
    //}
}
