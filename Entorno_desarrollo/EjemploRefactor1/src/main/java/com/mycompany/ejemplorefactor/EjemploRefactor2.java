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

public class EjemploRefactor2 {

    private List<Libro> libros;

    // Constructor
    public EjemploRefactor2() {
        libros = new ArrayList<>();
    }

    // Añadir un libro a la biblioteca
    public void añadirLibro(Libro libro) {
        libros.add(libro);
    }

    // Buscar libros por autor
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    // Mostrar todos los libros en la biblioteca
    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        EjemploRefactor2 biblioteca = new EjemploRefactor2();
        biblioteca.añadirLibro(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "Realismo mágico"));
        biblioteca.añadirLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Aventura"));
        biblioteca.añadirLibro(new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", 2001, "Suspenso"));

        // Mostrar todos los libros
        System.out.println("Todos los libros:");
        biblioteca.mostrarLibros();

        // Buscar libros por autor
        System.out.println("\nLibros de Gabriel García Márquez:");
        List<Libro> librosPorAutor = biblioteca.buscarPorAutor("Gabriel García Márquez");
        for (Libro libro : librosPorAutor) {
            System.out.println(libro);
        }
    }
}

class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String genero;

    // Constructor
    public Libro(String titulo, String autor, int añoPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.genero = genero;
    }

    // Métodos getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    // Sobreescribir el método toString para una mejor visualización
    @Override
    public String toString() {
        return titulo + " de " + autor + " (" + añoPublicacion + ") - Género: " + genero;
    }
}