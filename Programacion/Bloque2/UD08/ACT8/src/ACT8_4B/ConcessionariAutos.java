package ACT8_4B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariAutos implements Concessionari {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    @Override
    public double calculaIngressos() {
        double ingressos = 0;

        for (Vehicle v : this.vehicles) {
            ingressos += v.getPreu() + v.calculaImpost();
        }
        return ingressos;
    }
    
    public void setVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        String text="";
        
        for (Vehicle v : vehicles )
            text += "\n\t" + v.toString() + " Imposts: " + v.calculaImpost();
        
        return "ConcessionariAutos {" + text + "\n" + "}";
    }

}