package ACT8_6B;

public final class Rentadora extends Electrodomestic {
    int capacitatCarrega;
    
    public Rentadora(String nom, double preu, double consumEnergetic, int garantiaMesos, int capacitatCarrega, char classeEnergetica) {
        super(nom, preu, consumEnergetic, garantiaMesos, classeEnergetica);
        this.capacitatCarrega = capacitatCarrega;
    }

    //@Override
    //public double calculaSuplement() {
    //    return 0;
    //}
}