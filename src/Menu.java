import java.util.Scanner;

public class Menu {
	private static int opcio;
	private static int mode;
	
	public Menu() {

	}
	
	public static int getOpcio() { return opcio;}
	
	public static int mostraMenu(){
		opcio = 0;
		Scanner sc = new Scanner(System.in);
		
		while (opcio < 1 || opcio > 4) {
			System.out.println("\n\tWORD COUNT\n");
			System.out.println("---------- Menu ----------\n");
			System.out.println("1.- Seleccionar fitxer d'entrada");
			System.out.println("2.- Calcular aparicions");
			System.out.println("3.- Visualitzar resultats");
			System.out.println("4.- Sortir");
			
			System.out.println("Opció?");
			opcio = sc.nextInt();
		}
		return opcio;
	}
	
	public static void seleccionaMode() {
		System.out.println("-> Selecciona mode: ");
		System.out.println("Mode 1: Cua ordenada per camps");
		System.out.println("Mode 2");
		System.out.println("Mode 3");
		System.out.println("Mode 4");
		
		Scanner sc = new Scanner(System.in);
		Menu.mode = sc.nextInt();
	}
	
	public static int getMode() {
		return mode;
	}
}
