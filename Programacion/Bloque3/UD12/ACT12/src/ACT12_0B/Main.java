package ACT12_0B;

public class Main {

    public static void main(String[] args) {
        // Classe anònima a partir de Classe abstracta
        new Persona("Bernat", 23) {
            
            @Override
            public void saluda(){ 
                System.out.println("Hola, sóc " + super.getNom() + ", una persona anònima");
            }
            
        }.saluda();
    }
    
}
