package ACT8_7;

/**
 *
 * @author winadmin
 */
class Llibre {
    private String titol;
    private String autor;
    private int anyPublicacio;
    private double preu;

    public Llibre(String titol, String autor, int anyPublicacio, double preu) {
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.preu = preu;
    }

    // Getters i setters

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Llibre {" +
                "titol: '" + titol + '\'' +
                ", autor: '" + autor + '\'' +
                ", anyPublicacio: " + anyPublicacio +
                ", preu: " + preu +
                '}';
    }
}