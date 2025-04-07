package ACT10_2A;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Queue;

/**
 * @author T.Vives
 */
public class Dia implements Comparable<Dia>{
    protected LocalDate data;
    protected Queue<String> tasques;

    // Constructor
    public Dia(LocalDate data, Queue<String> tasques) {
        this.data = data;
        this.tasques = tasques;
    }

    @Override
    public int compareTo(Dia o) {
        if (data.isAfter(o.data)) return 1;
        else if (data.isBefore(o.data)) return -1;
        else return 0;
    }
    
    // Getters i Setters
    @Override
    public int hashCode() {
        return 31 * (Objects.hashCode(this.data));
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
        final Dia other = (Dia) obj;
        return Objects.equals(this.data, other.data);
    }
    
    @Override
    public String toString() {
        return this.data + ": {" + this.tasques.toString() + "}";
    }
}
