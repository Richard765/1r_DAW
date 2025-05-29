package ACT12_0C;

public class Main {

    public static void main(String[] args) {
        // Classe anònima a partir d'Interfície
        new Persona() {
            private final String nom = "Bernat";
            private final int edat = 23;
            
            @Override
            public void saluda(){ 
                System.out.println("Hola, sóc " + this.nom + ", una persona anònima");
            }
            
        }.saluda();
    }
    
}
