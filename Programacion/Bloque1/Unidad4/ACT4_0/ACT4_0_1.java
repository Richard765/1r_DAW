import java.util.Scanner;

public class ACT4_0_01 {
/**
 *
 * @author Tomeu Vives
 */
    public static void main(String[] args) {
        int numElementos, min, max, total, suma;
		int[][] matriz;
		float media;
		
		// Lee la longitud de la matriz
		numElementos = LeerElementos("Introduexi el núm elements de la matriu: ");

        matriz = new int [numElementso] [numElementos];

        // Lee los datos con el teclado
		matriz = LeerMatriz(matriz);

        // Mostra la matriz
		MostrarMatriz(matriz);
			
		// Calcula el min
		min = CalcularMin(matriz);
			
		// Calcula el max
        max = CalcularMax(matriz);
		
		// Calcula la media
		media = CalcularMedia(matriz);
		
		// Mostrar resultados
		MostrarResultados(min, max, media);
    }
		
	// Mètodes del programa:		
	public static int LeerElementos(String text) {
		Scanner scanner = new Scanner(System.in);
		int medida;
		System.out.print(text);
		mida = scanner.nextInt();
		
		//scanner.close();
		return medida;
	};
	
	public static int[][] LlegeixMatriu(int[][] matriu) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < matriu.length; i++)
			for (int j = 0; j < matriu[0].length; j++) {
				System.out.print("matriu[" + i + "][" + j + "]: ");
				matriu[i][j] = scanner.nextInt();
			}
		
		//scanner.close();
		return matriu;
		
	}
	
	public static void MostraMatriu(int[][] matriu) {
		System.out.println("La matriu és:");
		for (int[] array : matriu) {
			for (int valor : array) 
				System.out.print( valor + " " );
			System.out.println();
		}
	}
	
	public static int CalculaMin(int[][] matriu) {
		int min = matriu[0][0];
		
		for (int[] array : matriu)
			for (int valor : array)
				if (valor < min )
					min = valor;
				
		return min;
	}
	
	public static int CalculaMax(int[][] matriu) {
		int max = matriu[0][0];
		
		for (int[] array : matriu)
			for (int valor : array)
				if (valor > max)
					max = valor;
				
		return max;
	}
	
	public static float CalculaMitjana(int[][] matriu) {
		int total = 0; int suma = 0;
		
		for (int[] array : matriu)
			for (int valor : array) {
				suma += valor;
				total++;
			}
		return (float) suma / total;
	}
	
	public static void MostraResultats(int min, int max, float mitjana) {
		System.out.println("Els resultats són:");
		System.out.println("\tMàxim: " + max);
		System.out.println("\tMínim: " + min);
		System.out.println("\tMitjana: " + mitjana);
	}

}