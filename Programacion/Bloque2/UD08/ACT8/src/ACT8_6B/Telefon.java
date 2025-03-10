package ACT8_6B;

public final class Telefon extends Electronic {
    public Telefon(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla, processador, ram, hdd);
    }

    @Override
    public double calculaDescompte() {
        return super.getPreuBase() * ((getGarantiaMesos() < 6) ? 0.10 : 0.05);
    }

    @Override
    public String toString() {
        return "Telèfon {" + super.toString() + "}";
    }
}