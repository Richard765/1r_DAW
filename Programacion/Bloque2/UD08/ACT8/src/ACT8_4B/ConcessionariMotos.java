package ACT8_4B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class ConcessionariMotos implements Concessionari {
    private ArrayList<Motocicleta> motos = new ArrayList<>();

    @Override
    public double calculaIngressos() {
        double ingresos = 0;
        for (Motocicleta moto : motos) {
            ingresos += moto.getPreu() + moto.calculaImpost();
        }
        return ingresos;
    }
    
    public void setMotocicleta(Motocicleta moto) {
        motos.add(moto);
    }
    
    @Override
    public String toString() {
        String text="";
        
        for (Motocicleta m : motos )
            text += "\n\t" + m.toString() + " Imposts: " + m.calculaImpost();;

        return "ConcessionariMotos {" + text + "\n" + "}";
    }
    
}