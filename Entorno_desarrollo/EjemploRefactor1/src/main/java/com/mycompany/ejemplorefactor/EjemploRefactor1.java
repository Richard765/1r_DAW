/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplorefactor;

import java.util.List;  // Importa List
import java.util.ArrayList;  // Si usas ArrayList, es necesario importar esto
/**
 *
 * @author winadmin
 */


public class EjemploRefactor1 {
  
    // Método para obtener una lista de productos (se puede modificar para obtenerla de otra fuente)
    public List<Producto> lista() { 
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto A con descripción larga", 25.50));
        productos.add(new Producto(2, "Producto B", 10.99));
        productos.add(new Producto(3, "Producto C", 3.45));
        return productos;
    }
    
    public void productosResumidos(){ 
        int maxAppend = 15;
        List<Producto> producto = lista(); 
        for (Producto prod : producto) { 
            String string = prod.getDescripcion().trim(); 
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < string.length(); i++) { 
                if(i > maxAppend) { 
                    stringBuilder.append("...");
                    break;
                } 
                stringBuilder.append(string.charAt(i));
            } 
            
            String conversorString = prod.getValor().toString().replace(".", ","); 
            String stringFinal = prod.getId() + " - " + stringBuilder.toString() + " - $ " + conversorString;  
            System.out.println(stringFinal); 
        } 
    } 
    
     // Método principal
    public static void main(String[] args) {
        EjemploRefactor1 ejemplo = new EjemploRefactor1();
        ejemplo.productosResumidos();  // Llamada para imprimir los productos resumidos
    }
}

class Producto {
    private int id;
    private String descripcion;
    private Double valor;

    // Constructor
    public Producto(int id, String descripcion, Double valor) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    // Métodos getter
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getValor() {
        return valor;
    }
}