package ACT11_6B.Classes;

import java.util.Objects;

public class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    private Client client;

    public Vehicle(String matricula, String marca, String model, Client client) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.client = client;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.matricula);
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
        final Vehicle other = (Vehicle) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public String toString() {
        return "Vehicle{" + "matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", client=" + client + '}';
    }
    
}
