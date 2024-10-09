import java.util.Scanner;

public class ACT3_1_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int calificacion;
		
		System.out.print("Introduzca su calificación: ");
		calificacion = scanner.nextInt();
		
		if (calificacion>=5){
			System.out.println("Estas aprobado");
		} else {
			System.out.println("Estas suspendido");
		}
		scanner.close();
	}
}
