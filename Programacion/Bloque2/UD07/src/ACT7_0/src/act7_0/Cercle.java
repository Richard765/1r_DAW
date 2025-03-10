/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_0;

/**
 *
 * @author Richard
 */
public class Cercle extends FiguraGeometrica{
    private double radio;
    private int lados;
    
    @Override
    public double calculaPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    @Override
    public double calculaArea() {
        return Math.PI * (Math.pow(radio, 2));
    }
    
    @Override
    public int calculaLados() {
        return this.lados = 0;
    }
}
