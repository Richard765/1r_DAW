/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed_ud5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Richard
 */
class Cliente {
    private String nombre;
    private String direccion;
    private List<CuentaBancaria> cuentas;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public List<CuentaBancaria> obtenerCuentas() {
        return cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}