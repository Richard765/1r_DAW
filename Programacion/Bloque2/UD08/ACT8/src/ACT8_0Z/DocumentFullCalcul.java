package ACT8_0Z;

/**
 *
 * @author winadmin
 */
// Clase para representar un documento de hoja de cálculo
public class DocumentFullCalcul implements Document {
    private StringBuilder contingut=new StringBuilder();

    public DocumentFullCalcul(String contingut) {
        this.contingut.append(contingut);
    }

    public void afegeixDocument(String texte) {
        this.contingut.append(texte);
    }
    
    @Override
    public String toString() {
        return contingut.toString();
    }
}