package visualitzacio;

import java.util.Scanner;

public class MenuVisualitza {
	private static int opcio;
	
	public MenuVisualitza() {
	}
	
	public static int getOpcio() { return opcio;}
	
	public static int mostraMenuVisualitza(){
		opcio = 0;
		Scanner sc = new Scanner(System.in);
		
		while (opcio < 1 || opcio > 2) {
			System.out.println("--- Mode de visualitzacio ---\n");
			System.out.println("1.- Ordenació per número d'aparicions");
			System.out.println("2.- Ordenació alfabètica");
			
			System.out.println("Opció?");
			opcio = sc.nextInt();
		}
		return opcio;
	}

}
