package ACT8_4A;

/**
 *
 * @author winadmin
 */
// Clase abstracta para Vehículos
public abstract class Vehicle {
    private String marca;
    private String model;
    private double preu;
    private String tipus;

    public Vehicle(String marca, String model, double preu, String tipus) {
        this.marca = marca;
        this.model = model;
        this.preu = preu;
        this.tipus = tipus;
    }
    
    public abstract double calculaImpost();

    // Getters y setters
    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " {" + "marca: " + this.marca + ", model: " + this.model + ", tipus: " + this.tipus + ", preu: " + this.preu + '}';
    }

    

}
