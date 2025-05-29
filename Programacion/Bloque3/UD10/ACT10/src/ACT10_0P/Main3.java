package ACT10_0P;

import java.time.LocalDateTime;

/**
 *
 * @author winadmin
 */
public class Main3 {
    public static void main (String[] args) {
        LocalDateTime dataHoraActual = LocalDateTime.now();

        int mes = dataHoraActual.getMonthValue();
        int dia = dataHoraActual.getDayOfMonth();
        int any = dataHoraActual.getYear();
        int hora = dataHoraActual.getHour();
        int minut = dataHoraActual.getMinute();
        int segon = dataHoraActual.getSecond();
        
        System.out.println("Dia i Hora: " + dia + "/" + mes + "/" + any + " " + hora + ":" + minut + ":" + segon);
    }

}
