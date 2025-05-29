package ACT12_2C;

public class Client implements Comparable<Client>{
    int id;
    String nom;
    String email;

    public Client(int id, String nom, String email) {
        setId(id);
        setNom(nom);
        setEmail(email);
    }

    @Override
    public int compareTo(Client c) {
        if (this.id > c.id) return 1;
        else if (this.id < c.id) return -1;
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
        //if (nom == null || nom.isBlank())
        //    throw new IllegalArgumentException ("Client.Nom incorrecte");
        //else
            this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
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
        final Client other = (Client) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", email=" + email + '}';
    }

}