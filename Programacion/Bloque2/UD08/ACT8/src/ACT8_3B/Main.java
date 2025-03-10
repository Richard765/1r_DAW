package ACT8_3B;

// Clase principal Main
public class Main {
    public static void main(String[] args) {
        Llibre llibre = new Llibre("Java Programming", 2020, "John Smith", 35.0);
        Revista revista = new Revista("Tech Magazine", 2021, 25, 10.0);

        // Array de Publicacions
        Publicacio[] publicacions = {llibre, revista};

        // Polimorfismo
        for (Publicacio p : publicacions) {
            System.out.println(p.toString());
            System.out.println("Precio: $" + p.calculaPrecio());
            System.out.println("--------------");
        }
    }
}



