/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_0;

/**
 *
 * @author Richard
 */
public class Quadrat extends FiguraGeometrica {
    private double costado;
    private int lados;
    
    @Override
    public double calculaPerimetro() {
        return this.costado * 4;
    }
    
    @Override
    public double calculaArea() {
        return Math.pow(this.costado, 2);
    }
    @Override
    public int calculaLados() {
        return this.lados = 4;
    }
}
