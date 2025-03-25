public class Coche {
    private String marca;
    private String modelo;
    private int año;
    private int velocidadActual;

    public Coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.velocidadActual = 0;
    }

    public void acelerar(int incremento) {
        if (incremento > 0) {
            velocidadActual += incremento;
        }
    }

    public void frenar(int decremento) {
        if (decremento > 0) {
            velocidadActual -= decremento;
            if (velocidadActual < 0) {
                velocidadActual = 0;
            }
        }
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Velocidad Actual: " + velocidadActual + " km/h");
    }
}