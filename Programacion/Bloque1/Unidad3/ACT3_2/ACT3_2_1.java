import java.util.Scanner;

public class ACT3_2_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		
		System.out.print("Introduzca un numero: ");
		num = scanner.nextInt();
		
		for(int i=1; i<=num; i++) {
			if (num%i==0) {
				System.out.print(i + " ");
			}
		}
		scanner.close();
	}
}