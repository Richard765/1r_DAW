package ACT10_0P;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Administrador
 */
public class Main4 {
    public static void main (String[] args) {
        LocalDate dataNaixement = LocalDate.of(2000,5,22);
        LocalDate dataActual = LocalDate.now();

        Period periode = Period.between(dataNaixement, dataActual);
        int dia = dataActual.getDayOfMonth();
        int any = dataActual.getYear();
        System.out.println("Han passat: " + periode.getYears() + " anys, " + 
                                            periode.getMonths() + " mesos, " + 
                                            periode.getDays() + " dies entre " + dataActual + " i " + dataNaixement);
    }
}

