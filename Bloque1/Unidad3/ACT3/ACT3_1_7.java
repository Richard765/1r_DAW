import java.util.Scanner;

public class ACT3_1_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int operacion;
		float num1, num2, resultado;
		resultado = 0.0f;
		
		System.out.println("Operación");
		System.out.println("1. Suma (+)");
		System.out.println("2. Resta (-)");
		System.out.println("3. Multiplicación (*)");
		System.out.println("4. División (/)");
		operacion = scanner.nextInt();
		
		System.out.print("Introduzca el primer número: ");
		num1 = scanner.nextInt();
		System.out.print("Introduzca el segundo número: ");
		num2 = scanner.nextInt();
		
		if (operacion==1) {
			resultado = num1 + num2;
		} else if (operacion==2) {
			resultado = num1 - num2;
		} else if (operacion==3) {
			resultado = num1 * num2;
		} else if (operacion==4) {
			if (num2==0) {
				System.out.println("Error: No se puede dividir por cero");
				System.exit(0);
			} else {
				resultado = num1 / num2;
			}
		} else {
			System.out.println("Eleccion no válida");
		}
		
		System.out.println("El resultado es: " + resultado);
		
		scanner.close();
	}
}
