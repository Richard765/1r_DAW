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
abstract class VehicleMotor extends Vehicle{
    private double potencia;

    public VehicleMotor(double potencia, String matricula, String marca, String model, int any, ArrayList<Reparacio> reparacions) {
        super(matricula, marca, model, any, reparacions);
        this.potencia = potencia;
    }

    @Override
    public double calculaImpost() {
        return 0.0;
    }
    
    
}
