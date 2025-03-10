package ACT8_6A;

/**
 *
 * @author winadmin
 */
public class Client {
    private String nom;
    private String cognom;
    // productes
    private Telefon telefon;
    private Portatil portatil;
    private Televisor televisor;

    public Client(String nom, String cognom, Telefon telefon, Portatil portatil, Televisor televisor) {
        this.nom = nom;
        this.cognom = cognom;
        // Cistella de la compra
        this.telefon = telefon;
        this.portatil = portatil;
        this.televisor = televisor;
    }

    // Mètode per calcular el descompte total
    public double calculaPreuTotal() {
        double preuTotal = 0.0;

        if (telefon != null) {
            preuTotal += telefon.getPreu() - telefon.calculaDescompte();
        }

        if (portatil != null) {
            preuTotal += portatil.getPreu() - portatil.calculaDescompte();
        }

        if (televisor != null) {
            preuTotal += televisor.getPreu() - televisor.calculaDescompte();
        }

        return preuTotal;
    }

    @Override
    public String toString() {
        return "Client {" + "Nom: " + this.nom + ", Cognom: " + this.cognom + " {" +
                "\n\t," + this.telefon.toString() + 
                "\n\t," + this.portatil.toString() +
                "\n\t," + this.televisor.toString() + "\n} Preu Total: " + this.calculaPreuTotal();
    }
    
    
}