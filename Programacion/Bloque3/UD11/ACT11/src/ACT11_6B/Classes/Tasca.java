package ACT11_6B.Classes;

public class Tasca {
    private String descripcio;
    private EstatReparacio estat;

    public Tasca(String descripcio, EstatReparacio estat) {
        this.descripcio = descripcio;
        this.estat = estat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getEstat() {
        return estat.name();
    }

    public void setEstat(EstatReparacio estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {
        return "Tasca{" + "Descripcio=" + descripcio + ", estat=" + estat + '}';
    }

}
