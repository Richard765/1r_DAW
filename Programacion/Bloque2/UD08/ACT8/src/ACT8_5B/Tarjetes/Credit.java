package ACT8_5B.Tarjetes;

/**
 *
 * @author winadmin
 */
public class Credit extends Tarjeta {
    private double importEnNegatiu;

    public Credit(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra, double importEnNegatiu) {
        super(codiTarjeta, comisUs, importMaximCaixer, importMaximCompra);
        setImportEnNegatiu(importEnNegatiu);
    }

    public void setImportEnNegatiu(double importEnNegatiu) {
        this.importEnNegatiu = importEnNegatiu;
    }
    
}
