package ACT11_0G;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author winadmin
 */
public class Persona implements Serializable {
    protected static int idEmpresa = 1;
    protected String nom;
    protected transient int edat; // Atribut calculat

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();  // assegura el procés normal
        // Write additional fields
        oos.writeObject(new java.util.Date());
    }
    
    // This method is called post-serialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();  // assegura el procés normal
        
        // perform other initialization
        setEdat(10);
        
        // Data writed in Serialization
        System.out.println ("Restored from date: " + (java.util.Date)ois.readObject());
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
    

    @Override
    public int hashCode() {
        return Objects.hashCode(this.nom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Persona p = (Persona) o;

        return this.nom.equals(p.nom);
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }

}
