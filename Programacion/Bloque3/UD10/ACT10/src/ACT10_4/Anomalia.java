package ACT10_4;

/**
 *
 * @author T.Vives
 */
public enum Anomalia {
    COBERTA ("Desperfecte en la coberta del llibre"),
    CONTRACOBERTA ("Desperfecte en la contracoberta del llibre"),
    ESCRIPTURA ("Escriptura en fulles interiors"),
    LLOM ("Llom del llibre esfilegat");

    private final String descripcio; 

    Anomalia(String descripcio) { 
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return descripcio;
    }
    
}
