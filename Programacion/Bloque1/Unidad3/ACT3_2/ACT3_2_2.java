import java.util.Scanner;

public class ACT3_2_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		boolean esPrimo = true;
		
		System.out.print("Introduzca un numero: ");
		num = scanner.nextInt();
		
		for (int i=2; i<num-1; i++) {
			if(num%i==0) {
				esPrimo = false;
				break;
			}
		}
		
		if (esPrimo) {
			System.out.println("El numero es primo");
		} else {
			System.out.println("El numero no es primo");
		}
		scanner.close();
	}
}

