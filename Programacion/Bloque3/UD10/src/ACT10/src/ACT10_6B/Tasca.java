package ACT10_6B;

import java.time.LocalDate;
import java.util.Objects;

public class Tasca {
    private LocalDate data;
    private String descripcio;

    public Tasca(LocalDate data, String titol) {
        this.data = data;
        this.descripcio = titol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tasca t = (Tasca) o;
        return data.equals(t.data);
    }
    
    @Override
    public String toString() {
        return "Tasca = {" + this.data + ", " + this.descripcio + "}";
    }
    
    
}


