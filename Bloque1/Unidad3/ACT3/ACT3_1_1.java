import java.util.Scanner;

public class ACT3_1_1 {

	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		
		int num1;
		int num2;
		
		//Leer los dos numeros necesarios
		System.out.print("Introduzca el primer número: ");
		num1 = scanner.nextInt();	
		System.out.print("Introduzca el segundo número: ");
		num2 = scanner.nextInt();
		
		//Comparar num1 y num2
		if (num1>num2){
			System.out.println(num1 + " es mayor que " + num2);
		} else if (num1<num2){
			System.out.println(num1 + " es menor que " + num2);
		} else {
			System.out.println("Ambos números tienen el mismo valor");
		}
		scanner.close();

	}
}