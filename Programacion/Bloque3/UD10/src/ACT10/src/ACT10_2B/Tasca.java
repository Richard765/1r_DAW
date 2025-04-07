package ACT10_2B;

import java.time.LocalTime;

/**
 * @author T.Vives
 */
class Tasca {
    private LocalTime hora;
    private String titol;

    public Tasca(LocalTime hora, String titol) {
        this.hora = hora;
        this.titol = titol;
    }

    public String getTitol() {
        return titol;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return hora + " - " + titol;
    }
}