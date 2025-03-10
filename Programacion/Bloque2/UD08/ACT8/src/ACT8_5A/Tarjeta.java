package ACT8_5A;

/**
 *
 * @author winadmin
 */
public abstract class Tarjeta {
    protected String codiTarjeta;
    protected double comisUs;
    protected double importMaximCaixer;
    protected double importMaximCompra;

    public Tarjeta(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra) {
        this.codiTarjeta = codiTarjeta;
        this.comisUs = comisUs;
        this.importMaximCaixer = importMaximCaixer;
        this.importMaximCompra = importMaximCompra;
    }
    
}
