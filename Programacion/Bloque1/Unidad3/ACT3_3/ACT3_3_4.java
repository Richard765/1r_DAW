public class ACT3_3_4 {
	public static void main(String[] args) {
		final int num = 10, MIN = 10, MAX = 99;
		int [][] matriu = new int [num][num];
		
		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[i].length; j++) {
				matriu[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
				System.out.print(matriu[i][j] + " ");
			}
		System.out.println();
		}
	}
}