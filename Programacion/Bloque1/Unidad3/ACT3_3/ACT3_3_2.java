public class ACT3_3_2 {

	public static void main(String[] args) {
		
		int array[] = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			int num = 100 + (int) (Math.random() * ((200 - 100) + 1));
			System.out.print(num + " ");
		}
	
	}
}

