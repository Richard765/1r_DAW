package ACT12_0A;

class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
   
    public void saluda() {
        System.out.println("Hola, soc una persona!");
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }
    
}

