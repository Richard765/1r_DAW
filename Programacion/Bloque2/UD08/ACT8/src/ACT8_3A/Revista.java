package ACT8_3A;

/**
 *
 * @author winadmin
 */
// Clase Revista
class Revista extends PublicacioBase {
    private int numeroEdicio;
    private double preu;

    public Revista(String titol, int anioPublicacio, int numeroEdicio, double preu) {
        super(titol, anioPublicacio);
        setNumeroEdicio(numeroEdicio);
        setPreu(preu);
    }

    @Override
    public double calculaPrecio() {
        return preu * 1.10;
    }

    public void setNumeroEdicio(int numeroEdicio) {
        this.numeroEdicio = numeroEdicio;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return super.toString() + " Revista: " + getTitol() + ", Número d'Edició: " + numeroEdicio + ", A?o: " + getAnyPublicacio();
    }
    
}