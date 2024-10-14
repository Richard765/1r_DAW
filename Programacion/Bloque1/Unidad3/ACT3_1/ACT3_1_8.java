import java.util.Scanner;

public class ACT3_1_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sumaPar = 0;

		for (int i=2; i<=100; i++) {
			if (i%2==0) {
				sumaPar = sumaPar + i;
			}
		}
		System.out.print("La suma es " + sumaPar);
	}
}