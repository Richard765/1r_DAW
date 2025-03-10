package ACT8_5A;

/**
 *
 * @author winadmin
 */
public class Debit extends Tarjeta {
    private double importCompraMinim;

    public Debit(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra, double importCompraMinim) {
        super(codiTarjeta, comisUs, importMaximCaixer, importMaximCompra);
        this.importCompraMinim = importCompraMinim;
    }
    
}
