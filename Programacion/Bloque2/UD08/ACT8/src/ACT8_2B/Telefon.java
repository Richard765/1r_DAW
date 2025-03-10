package ACT8_2B;

/**
 *
 * @author winadmin
 */
public abstract class Telefon extends ValidadorDispositius implements DispositiuElectronic {
    private String marca;  // Marca del Telèfon
    private Persona persona;  // Dades de la persona propietària
    private boolean onOff;  // Encès o apagat
        
    public Telefon(String[] patrons, String marca, Persona persona, boolean onOff) {
        super(patrons);
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }

    public Telefon(String marca, Persona persona, boolean onOff) {
        super(new String[] {null, null, null, null});
        this.marca = marca;
        this.persona = persona;
        this.onOff = onOff;
    }
    
    /*
    @Override
    public boolean validaPatrons(Object o) {
        Persona persona = (Persona) o;
        
        if (this.getOnOff()) {
            for (String patroPersona : persona.getPatrons())
                for (String patroDispositiu : super.getPatrons())
                    if (patroPersona != null)
                        return patroPersona.equals(patroDispositiu);

            return false;
        } else {
            System.out.println("Telèfon no encès");
            return false;
        }
    }*/
    
    @Override
    public void on() {
        System.out.println("Telèfon encès");
        if (!this.getOnOff())
            this.setOnOff(true);
    }
    
    @Override
    public void off() {
        System.out.println("Telèfon apagat");
        if (this.getOnOff())
            this.setOnOff(false);
    }
    
    public boolean getOnOff() {
        return this.onOff;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
    
    @Override
    public String toString() {
        return this.marca;
    }

}
