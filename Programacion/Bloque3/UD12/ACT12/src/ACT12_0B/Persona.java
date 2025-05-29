package ACT12_0B;

abstract class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
   
    public abstract void saluda();  // Métode abstracte en classe abstracte

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }
    
}

