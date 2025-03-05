/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT8_8;

import java.util.Objects;

/**
 *
 * @author Richard
 */
public class Reparacio {
    String descripcio;
    double preu;

    public Reparacio(String descripcio, double preu) {
        this.descripcio = descripcio;
        this.preu = preu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reparacio other = (Reparacio) obj;
        if (Double.doubleToLongBits(this.preu) != Double.doubleToLongBits(other.preu)) {
            return false;
        }
        return Objects.equals(this.descripcio, other.descripcio);
    }
}
