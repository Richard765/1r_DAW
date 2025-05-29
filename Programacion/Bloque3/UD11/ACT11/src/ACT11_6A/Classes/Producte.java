package ACT11_6A.Classes;

public class Producte implements Comparable <Producte>{
    int id;
    String nom;
    double preu;
    Categoria categoria;

    public Producte(int id, String nom, double preu, Categoria categoria) {
        setId(id);
        setNom(nom);
        setPreu(preu);
        setCategoria(categoria);
    }

    @Override
    public int compareTo(Producte p) {
        if (this.id > p.id) return 1;
        else if (this.id < p.id) return -1;
        else return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        if (preu < 0)
            throw new IllegalArgumentException ("Producte.Preu incorrecte");
        else
            this.preu = preu;
    }

    public String getCategoria() {
        return categoria.name();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producte other = (Producte) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Producte{" + "id=" + id + ", nom=" + nom + ", preu=" + preu + ", categoria=" + categoria.toString() + '}';
    }
    
}
