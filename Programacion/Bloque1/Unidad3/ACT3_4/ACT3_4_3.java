import java.util.Scanner;

public class ACT3_4_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matriz;
		double media;
		int total, columna, fila;
		
		System.out.print("Introduze el numero de elementos: ");
		total = scanner.nextInt();
		matriz = new int[total][total];
		
		for (int i = 0; i < matriz.length; i++)  {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print("Matriz[" + i + "][" + j + "]: ");
				matriz[i][j] = scanner.nextInt();
			}
		}
		
		System.out.println();
		
		for (int[] array : matriz) {
			for (int a : array) {
				System.out.print( a + " " );
			}
			System.out.println();
		}
		
		System.out.println();
		
		//Mostrar una fila
		System.out.print("Introduzca la fila para mostrar: ");
		fila = scanner.nextInt();
		fila--;
		for (int j = 0; j < matriz[fila].length; j++) {
			System.out.print( matriz[fila][j] + " ");
		}
		
		System.out.println();
			
		//Mostrar una columna
		System.out.print("Introduzca la columna para mostrar: ");
		columna = scanner.nextInt();
		columna--;
		for (int j = 0; j < matriz[columna].length; j++) {
			System.out.println(matriz[j][columna]);
		}
		
		System.out.println();
		
		//Mostrar diagonal principal
		System.out.println("Diagonal principal:");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(matriz[i][i]);
		}
		
		System.out.println();
		
		//Mostrar diagonal secundario
		System.out.println("Diagonal secundaria:");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(matriz[i][(matriz.length - 1) - i]);
		}
	}
}	