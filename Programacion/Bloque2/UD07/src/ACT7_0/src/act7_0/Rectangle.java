/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_0;

/**
 *
 * @author Richard
 */
public class Rectangle extends FiguraGeometrica {
    private double ancho;
    private double altura;
    private int lados;
    
    @Override
    public double calculaPerimetro() {
        return 2 * (ancho + altura);
    }
    
    @Override
    public double calculaArea() {
        return ancho * altura;
    }
    
    @Override
    public int calculaLados() {
        return this.lados = 4;
    }
    
    
}