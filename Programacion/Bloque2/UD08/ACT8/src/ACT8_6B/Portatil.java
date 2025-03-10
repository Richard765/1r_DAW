package ACT8_6B;

public final class Portatil extends Electronic {
    public Portatil(String nom, double preu, double consumEnergetic, int garantiaMesos, int midaPantalla, String processador, int ram, int hdd) {
        super(nom, preu, consumEnergetic, garantiaMesos, midaPantalla, processador, ram, hdd);
    }

    @Override
    public double calculaDescompte() {
        return super.getPreuBase() * ((getConsumEnergetic() > 20) ? 0.15 : 0.10);
    }

    @Override
    public String toString() {
        return "Portàtil {" + super.toString() + "}";
    }
}