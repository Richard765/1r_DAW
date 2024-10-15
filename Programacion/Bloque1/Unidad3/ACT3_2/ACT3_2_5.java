import java.util.Scanner;

public class ACT3_2_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		char car;
		int opcion;
		
		System.out.print("Que opcion quieres (if [1], switch [2], Array [3]: ");
		opcion = scanner.nextInt(); 
		
		if (opcion==1) {
			do {
				System.out.print("Introduzca un carácter (X): ");
				car = scanner.next().charAt(0); 
				
				if (car=='A' || car=='E' || car=='I' || car=='O' || car=='U') {
					System.out.println(car + " es vocal");
				} else {
					System.out.println(car + " es consonante");
				}
				
			} while (car != 'X');
			
		} else if (opcion==2) {
			do {
				System.out.print("Introduzca un carácter (X): ");
				car = scanner.next().charAt(0); 
				
				switch (car) {
					case 'A': 
					case 'E': 
					case 'I': 
					case 'O': 
					case 'U': 
						System.out.println(car + " es vocal");
						break;
					default: 
						System.out.println(car + " es consonante");
					
			} while (car != 'X');
			
		} else if (opcion==3) {
			do {
				char[] vocales = {A, E, I, O, U};
				
				System.out.print("Introduzca un carácter (X): ");
				car = scanner.next().charAt(0); 
				
				boolean esVocal = false;
                for (char vocal : vocales) {
                    if (car == vocal) {
                        esVocal = true;
                        break;
                    }
                }

                if (esVocal) {
                    System.out.println(car + " es vocal");
                } else {
                    System.out.println(car + " es consonante");
                }
				
			} while (car != 'X');
		}

        scanner.close();
    }
}


