package ACT8_6B;

public abstract class Electronic extends Producte {
    private int midaPantalla;
    private String processador;
    private int ram;
    private int hdd;

    public Electronic(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos);
        this.midaPantalla = midaPantalla;
        this.processador = processador;
        this.ram = ram;
        this.hdd = hdd;
    }
       
    // Mètode abstracte que cal implementar a les subclasses
    // public abstract double calculaDescompte();
    
    @Override
    public double calculaSuplement() {
        return 0;
    }

    public int getMidaPantalla() {
        return midaPantalla;
    }
    
}
