public class ACT3_3_4 {
	public static void main(String[] args) {
		final int num = 3, MIN = 10, MAX = 99;
		int [][] matriz = new int [num][num];
		int mayor = MIN, menor = MAX, contar = 0, suma = 0;
		double media = 0;
		
		//Dar valor a cada array
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
				System.out.print(matriz[i][j] + " ");
			}
		System.out.println();
		}
		
		//Buscar el numero mayor
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] > mayor) {
					mayor = matriz[i][j];
				}
			}
		}
		System.out.println("\nEl numero mas alto es: " + mayor);
		
		//Buscar el numero menor
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (menor > matriz[i][j]) {
					menor = matriz[i][j];
				}
			}
		}
		System.out.println("\nEl numero mas bajo es: " + menor);
		
		//Buscar la media
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				contar++;
				suma = matriz[i][j] + suma;
			}
		}
		System.out.println("\nLa media es: " + (media = (double) suma / contar));
	}
}