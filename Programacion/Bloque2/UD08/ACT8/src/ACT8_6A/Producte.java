package ACT8_6A;

/**
 *
 * @author winadmin
 */
public abstract class Producte {
    private String nom;
    private double preu;
    private double consumEnergetic;
    private int garantiaMesos;
    private int midaPantalla;

    public Producte(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla) {
        this.nom = nom;
        this.preu = preu;
        this.consumEnergetic = consumEnergetic;
        this.garantiaMesos = garantiaMesos;
        this.midaPantalla = midaPantalla;
    }
    
    // Mètode abstracte que cal implementar a les subclasses
    public abstract double calculaDescompte();
    
    // Getters i setters
    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public double getConsumEnergetic() {
        return consumEnergetic;
    }

    public int getGarantiaMesos() {
        return garantiaMesos;
    }

    public int getMidaPantalla() {
        return midaPantalla;
    }

    @Override
    public String toString() {
        return "Producte {" +
                "Nom: " + nom + 
                ", Preu: " + preu +
                ", ConsumEnergetic: " + consumEnergetic +
                ", GarantiaMesos: " + garantiaMesos +
                ", MidaPantalla: " + midaPantalla +
                '}';
    }
}