package ACT10_0H;

public class Main {
    public static void main(String[] args) {
        double num1 = 10;
        double num2 = 5;

        // Executa cada operació matemàtica
        for (OperacioMatematica o : OperacioMatematica.values()) {
            System.out.println(o.toString() + ": " + o.executa(num1, num2));
        }
    }
}
