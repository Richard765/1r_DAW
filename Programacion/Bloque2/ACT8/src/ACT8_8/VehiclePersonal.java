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
abstract class VehiclePersonal extends Vehicle{
    private boolean esElectric;

    public VehiclePersonal(boolean esElectric, String matricula, String marca, String model, int any, ArrayList<Reparacio> reparacions) {
        super(matricula, marca, model, any, reparacions);
        this.esElectric = esElectric;
    }
 
    @Override
    public double calculaImposts() {
        return (this.esElectric ? 50 : 0);
    }
    
    @Override
    public double calculaManteniment() {
        return 75;
    }
}
