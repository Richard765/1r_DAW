import java.util.Scanner;

public class ACT3_4_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int valormax = Integer.MIN_VALUE, valormin = Integer.MAX_VALUE, cantidad;
		double media;
		int sum = 0;
		
		//Definir la cantidad para el array
		System.out.print("¿Cuantos numeros quieres? ");
		cantidad =  scanner.nextInt();
		int numeros[] = new int[cantidad];
		
		//Dar valores a cada numero del array
		for (int i = 0; i < numeros.length;i++) {
			System.out.print("¿Que valor le quieres dar al numero? ");
			numeros[i] = scanner.nextInt();
		}
		System.out.println("");
		
		//Mostrar los valores del array
		for (int x : numeros) {
			System.out.print(x + " ");
		}
		System.out.println("");
		System.out.println("");
		
		//Mostrar el numero mas alto
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > valormax) {
				valormax = numeros[i];
			}
		}
		System.out.println("El valor mas alto es " + valormax);
		System.out.println("");
		
		//Mostrar el numero mas bajo
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < valormin) {
				valormin = numeros[i];
			}
		}		
		System.out.println("El valor mas bajo es " + valormin);
		System.out.println("");
		
		//Mostrar la media
		for (int i : numeros) {
			sum += i;
		}
		media = (double) sum / numeros.length;
		System.out.println("La media es " + media);
		
	}
}

