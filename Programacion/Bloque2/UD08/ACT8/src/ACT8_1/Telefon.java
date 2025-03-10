package ACT8_1;

/**
 *
 * @author winadmin
 */
public abstract class Telefon implements DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
    
    /*
    public Telefon(String marca, Persona persona, boolean onOff) {
        // super(); // No cal ja que la interfície no té cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }*/
    
    public Telefon(String marca, Persona persona) {
        // super(); // No cal ja que la interfície no té cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = false;
    }
    
    @Override
    public void on() {
        System.out.println("\tTelèfon " + this.getMarca() + " encès");
        if (!this.getOnOff())
            this.setOnOff(true);
    }
    
    @Override
    public void off() {
        System.out.println("\tTelèfon " + this.getMarca() + " apagat");
        if (this.getOnOff())
            this.setOnOff(false);
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