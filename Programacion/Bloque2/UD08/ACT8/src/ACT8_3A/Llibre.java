package ACT8_3A;

/**
 *
 * @author winadmin
 */
// Clase Libro
class Llibre extends PublicacioBase {
    private String autor;
    private double preu;

    public Llibre(String titulo, int anioPublicacion, String autor, double preu) {
        super(titulo, anioPublicacion);
        setAutor(autor);
        setPreu(preu);
    }

    @Override
    public double calculaPrecio() {
        return getPreu() * 1.21;
    }

    public double getPreu() {
        return preu;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Libre: " + getTitol() + ", Autor: " + autor + ", Any: " + getAnyPublicacio();
    }
}
