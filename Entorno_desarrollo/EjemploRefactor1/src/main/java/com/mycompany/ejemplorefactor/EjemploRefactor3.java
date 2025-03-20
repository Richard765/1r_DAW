/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplorefactor;

/**
 *
 * @author winadmin
 */

import java.util.ArrayList;
import java.util.List;

public class EjemploRefactor3 {

    private List<Tarea> tareas;

    // Constructor
    public EjemploRefactor3() {
        tareas = new ArrayList<>();
    }

    // Añadir tarea
    public void añadirTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    // Eliminar tarea
    public void eliminarTarea(String titulo) {
        tareas.removeIf(tarea -> tarea.getTitulo().equalsIgnoreCase(titulo));
    }

    // Marcar tarea como completada
    public void marcarComoCompletada(String titulo) {
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                tarea.setCompletada(true);
                break;
            }
        }
    }

    // Mostrar todas las tareas
    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }

    public static void main(String[] args) {
        EjemploRefactor3 lista = new EjemploRefactor3();
        lista.añadirTarea(new Tarea("Comprar comida", "Ir al supermercado y comprar comida para la semana", false));
        lista.añadirTarea(new Tarea("Lavar ropa", "Lavar y planchar la ropa", false));

        // Mostrar tareas pendientes
        System.out.println("Tareas pendientes:");
        lista.mostrarTareas();

        // Marcar una tarea como completada
        lista.marcarComoCompletada("Comprar comida");

        // Mostrar tareas después de actualizar el estado
        System.out.println("\nTareas después de actualizar el estado:");
        lista.mostrarTareas();

        // Eliminar una tarea
        lista.eliminarTarea("Lavar ropa");

        // Mostrar tareas después de eliminar una tarea
        System.out.println("\nTareas después de eliminar:");
        lista.mostrarTareas();
    }
}

class Tarea {
    private String titulo;
    private String descripcion;
    private boolean completada;

    // Constructor
    public Tarea(String titulo, String descripcion, boolean completada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    // Métodos getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // Sobreescribir el método toString para una mejor visualización
    @Override
    public String toString() {
        return titulo + " - " + descripcion + " - Estado: " + (completada ? "Completada" : "Pendiente");
    }
}