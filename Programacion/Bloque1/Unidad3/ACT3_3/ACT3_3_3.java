import java.util.Scanner;

public class ACT3_3_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int array1[] = new int[10];
		int array2[] = new int[10];
		boolean sonIguales = true;
		
		for (int i = 0; i < 10; i++) {
			array1[i] = i + 1;
			array2[i] = i + 1;
		}
	
		if (array1.length == array2.length) {
			sonIguales = true;
		} else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    sonIguales = false; 
                    break;
                }
            }
        }
		System.out.print(sonIguales);
	}
}

