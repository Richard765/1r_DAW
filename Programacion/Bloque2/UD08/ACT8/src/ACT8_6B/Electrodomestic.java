package ACT8_6B;

public abstract class Electrodomestic extends Producte {
    private char classeEnergetica;

    public Electrodomestic(String nom, double preu, double consumEnergetic, int garantiaMesos, char classeEnergetica) {
        super(nom, preu, consumEnergetic, garantiaMesos);
        this.classeEnergetica = classeEnergetica;
    }
    
    @Override
    public double calculaDescompte() {
        return 0;
    }
    
    // Mètode concret, no cal implementar a les subclasses
    public final double calculaSuplement() {
        return super.getPreuBase() * (((this.classeEnergetica == 'A') ? 0.05 : (this.classeEnergetica == 'B') ? 0.10 : 0.15 ));
    }  
}
