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
public class Camio extends VehicleMotor{
    private boolean esFrigorific;

    public Camio(boolean esFrigorific, double potencia, String matricula, String marca, String model, int any, ArrayList<Reparacio> reparacions) {
        super(potencia, matricula, marca, model, any, reparacions);
        this.esFrigorific = esFrigorific;
    }
  
    
    @Override
    public double calculaImpost() {
        return super.calculaImpost() + (this.esFrigorific ? 5 : 0);
    }

    @Override
    public double calculaManteniment() {
        return 0.0;
    }
    
}
