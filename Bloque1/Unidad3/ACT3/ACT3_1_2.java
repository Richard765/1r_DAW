import java.util.Scanner;

public class ACT3_1_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		
		System.out.print("Introduzca un numero: ");
		num = scanner.nextInt();
		
		if (num==0){
			System.out.print("El numero es 0");
		} else if (num % 2 == 0)  {
			System.out.print("El numero es par");
		} else {
			System.out.print("El numero es impar");
		}
	}
}