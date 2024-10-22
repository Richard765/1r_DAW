public class PATATA {
	public static void main(String[] args) {
		int[] array;
		array = new int [10];
		int acumulador = 0;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = 1 + (int) (Math.random() * ((10-1)+1));
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			acumulador = acumulador + array[i];
		}
		
		System.out.println("La suma de los nombres de los array son " + acumulador);
	}
}