public class ACT3_3_1 {

	public static void main(String[] args) {
		int num[] = new int[10];
		
		for (int i=0; i<num.length;i++) {
			num[i] = i + 1;
		}
		
		for (int a : num) {
			System.out.print(a + " ");
		}
	}
}

