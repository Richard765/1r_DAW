public class ACT3_3_1 {

	public static void main(String[] args) {
		int num[] = new int[100];
		
		for (int i=0; i<num.length;i++) {
			num[i] = i + 1;
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}

