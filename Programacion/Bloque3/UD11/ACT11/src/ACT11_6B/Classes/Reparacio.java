package ACT11_6B.Classes;

import java.time.LocalDate;
import java.util.List;

public class Reparacio implements Comparable<Reparacio> {
    private int id;
    private LocalDate dataEntrada;
    private Vehicle vehicle;
    private double cost;
    private List<Tasca> tasques;

    public Reparacio(int id, LocalDate dataEntrada, Vehicle vehicle, double cost, List<Tasca> tasques) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.vehicle = vehicle;
        this.cost = cost;
        this.tasques = tasques;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Tasca> getTasques() {
        return tasques;
    }

    public void setTasques(List<Tasca> tasques) {
        this.tasques = tasques;
    }

    @Override
    public int compareTo(Reparacio r) {
        if (this.id > r.id) return 1;
        else if (this.id < r.id) return -1;
        else return 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Reparacio other = (Reparacio) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        String text = "Reparacio{" + "id=" + id + ", dataEntrada=" + dataEntrada + ", vehicle=" + vehicle + ", cost=" + cost + ", tasques=";
        for (Tasca t : this.tasques) {
            text += "\n\t\t" + t.toString();
        }
        
        return text;
    }

}