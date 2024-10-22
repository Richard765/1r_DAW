public class Prova {
	public static void main(String[] args) {
		final int num = 10;
		int [][] matriu = new int [num][num];
		
		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[i].length; j++) {
				matriu[i][j] = 10 + (int) (Math.random() * ((99 - 10) + 1));
				System.out.print(matriu[i][j] + " ");
			}
		System.out.println();
		}
	}
}