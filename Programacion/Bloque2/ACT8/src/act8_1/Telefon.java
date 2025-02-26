/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act8_1;

/**
 *
 * @author Richard
 */
public abstract class Telefon extends ValidadorDispositius implements DispositiuElectronic{
    private String marca;
    private Persona persona;
    private boolean onOff;

    public Telefon(String marca, Persona persona, boolean onOff) {
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }

    @Override
    public void on() {
        System.out.println("Telèfon encès");
        if (!this.onOff)
            this.onOff = true;
    }
    
    @Override
    public void off() {
        System.out.println("Telèfon apagat");
        if (this.onOff)
            this.onOff = false;
    }
    
    public boolean getOnOff() {
        return this.onOff;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff; 
    }
    
    public String getMarca() {
        return marca;
    }
    
    @Override
    public String toString() {
        return this.marca;
    }
}
