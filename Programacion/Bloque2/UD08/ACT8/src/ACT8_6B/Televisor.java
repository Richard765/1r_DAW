package ACT8_6B;

public final class Televisor extends Electronic {

    public Televisor(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla, processador, ram, hdd);
    } 

    @Override
    public double calculaDescompte() {
        return super.getPreuBase() * ((getMidaPantalla() > 40) ? 0.12 : 0.08);
    }
    
    @Override
    public String toString() {
        return "Televisor {" + super.toString() + "}";
    }
}