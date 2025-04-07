package ACT11_3B;

/**
 *
 * @author winadmin
 */
public class MissatgeEvent {
    private String ipOrigen;
    private String portOrigen;
    private String ipDesti;
    private String portDesti;
    private String descripcio;

    public MissatgeEvent(String ipOrigen, String portOrigen, String ipDesti, String portDesti, String descripcio) {
        this.ipOrigen = ipOrigen;
        this.portOrigen = portOrigen;
        this.ipDesti = ipDesti;
        this.portDesti = portDesti;
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "MissatgeError{" + "ipOrigen=" + ipOrigen + ", portOrigen=" + portOrigen + ", ipDesti=" + ipDesti + ", portDesti=" + portDesti + ", descripcio=" + descripcio + '}';
    }


    
}
