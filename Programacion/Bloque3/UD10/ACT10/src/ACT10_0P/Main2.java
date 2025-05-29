package ACT10_0P;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author winadmin
 */
public class Main2 {

    public static void main (String[] args) {
        LocalTime horaActual = LocalTime.now();

        int hora = horaActual.getHour();
        int minut = horaActual.getMinute();
        int segon = horaActual.getSecond();
        System.out.println("Hora: " + hora + ":" + minut + ":" + segon);
    }

}
