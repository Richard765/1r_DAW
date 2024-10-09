import java.util.Scanner;

public class ACT3_1_5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int temperatura, eleccion, resultado;
		
		System.out.println("Elija la conversión que desea realizar:");
		System.out.println("1. Celsius a Fahrenheit");
		System.out.println("2. Fahrenheit a Celsius");
		eleccion = scanner.nextInt();
		
		System.out.print("Introduzca la temperatura: ");
		temperatura = scanner.nextInt();
		
		if (eleccion==1) {
			resultado = temperatura * 9/5 + 32;
			System.out.println("El resultado son " + resultado + " grados Fahrenheit.");
		} else {
			resultado = (temperatura - 32) * 5/9;
			System.out.println("El resultado son " + resultado + " grados Celsius.");
		}
	
	scanner.close();
	
	}
}