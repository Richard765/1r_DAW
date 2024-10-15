import java.util.Scanner;

public class ACT3_2_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		int	contar = 0, total = 0;
		float mediana;
		
		
		do {
			System.out.print("Introduzca un numero: ");
			num = scanner.nextInt();
			if (num >= -1) {
				contar++;
				total = total + num;
			}
		} while (num != -1);
		
		mediana = ((float) total/contar);
		System.out.print("La mediana es " + mediana);
		
		
		scanner.close();
	}
}

