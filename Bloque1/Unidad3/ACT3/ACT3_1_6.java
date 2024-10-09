import java.util.Scanner;

public class ACT3_1_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num, resultado;
		
		System.out.print("Introduzca un número: ");
		num =scanner.nextInt();
		
		for (int i=0; i<=10; i++) {
			resultado = num * i;
			System.out.println(num + " x " + i + " = " + resultado);
		}
		scanner.close();
	}
}
