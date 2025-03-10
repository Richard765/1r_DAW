package ACT8_0Z;

/**
 *
 * @author winadmin
 */
// Clase para representar un documento de texto
class DocumentTexte implements Document {
    private StringBuilder contingut=new StringBuilder();

    public DocumentTexte(String contingut) {
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