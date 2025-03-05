/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT8_8;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Taller {
    private ArrayList<Vehicle> vehicles;

    public Taller(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    
    
    public boolean afegeixVehicle(Vehicle v) {
        if (!(this.vehicles.contains(v)))
            return this.vehicles.add(v);
        return false;
    }
    
    public boolean eliminaVehicle(String matricula) {
        return this.vehicles.remove(v);
    }
    
    public double calculaTotalReparacions() {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            if (v instanceof VehicleMotor) {
                total += v.calculaReparacions();
            }
        }
        return total;
    }
    
    public double calculaTotalManteniment() {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            if (v instanceof VehicleMotor) {
                total += v.calculaMantenimiento();
            }
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "";
    }
}
