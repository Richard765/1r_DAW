package ACT8_5B.Tarjetes;

/**
 *
 * @author winadmin
 */
public abstract class Tarjeta {
    private String codiTarjeta;
    private double comisUs;
    private double importMaximCaixer;
    private double importMaximCompra;

    public Tarjeta(String codiTarjeta, double comisUs, double importMaximCaixer, double importMaximCompra) {
        setCodiTarjeta(codiTarjeta);
        setComisUs(comisUs);
        setImportMaximCaixer(importMaximCaixer);
        setImportMaximCompra(importMaximCompra);
    }
    
    public double getComisUs() {
        return comisUs;
    }

    public void setCodiTarjeta(String codiTarjeta) {
        this.codiTarjeta = codiTarjeta;
    }

    public void setComisUs(double comisUs) {
        this.comisUs = comisUs;
    }

    public void setImportMaximCaixer(double importMaximCaixer) {
        this.importMaximCaixer = importMaximCaixer;
    }

    public void setImportMaximCompra(double importMaximCompra) {
        this.importMaximCompra = importMaximCompra;
    }
    
}
