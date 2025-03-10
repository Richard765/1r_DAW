package ACT8_4A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariAutos implements Concessionari {
    private ArrayList<Automobil> autos = new ArrayList<>();

    @Override
    public double calculaIngressos() {
        double ingressos = 0;

        for (Automobil a : this.autos) {
            ingressos += a.getPreu() + a.calculaImpost();
        }
        return ingressos;
    }
    
    public void setAutomobil(Automobil auto) {
        autos.add(auto);
    }
    
    @Override
    public String toString() {
        String text="";
        
        for (Automobil a : autos )
            text += "\n\t" + a.toString() + " Imposts: " + a.calculaImpost();
        
        return "ConcessionariAutos {" + text + "\n" + "}";
    }

}