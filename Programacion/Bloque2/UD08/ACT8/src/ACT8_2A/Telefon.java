package ACT8_2A;

/**
 *
 * @author winadmin
 */
public abstract class Telefon implements ValidadorDispositius, DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
    

    
    public Telefon(String marca, Persona persona) {
        // super(); // No cal ja que la interfície no té cap atribut
        this.marca = marca;
        this.persona = persona;
        this.onOff = false;
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
    
    /**
     * En una 'classe abstracta* no cal implementar ni declarar els mètodes
     * que ens obliga la 'Interfície' que implementa
    */
    // @Override
    // public void setPatrons(String patroCodiPin, String patroTeclat, String patroEmprempta, String patroRostre);

    // @Override
    // public boolean validaPatrons(Object o);
    
    @Override
    public String toString() {
        return this.marca;
    }
}