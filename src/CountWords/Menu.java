package CountWords;
import java.util.Scanner;

public class Menu {
	private static int opcio;
	private static int mode;
	private static boolean seleccionat;
	
	public Menu() {
			seleccionat = false;
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
		if (opcio == 1) seleccionat = true;
		return opcio;
	}
	
	public static void seleccionaMode() {
		System.out.println("-> Selecciona mode: ");
		System.out.println("Mode 1: Cua ordenada");
		System.out.println("Mode 2: Taula Hash amb Cua");
		System.out.println("Mode 3");
		System.out.println("Mode 4");
		
		Scanner sc = new Scanner(System.in);
		Menu.mode = sc.nextInt();
	}
	
	public static int getMode() {
		return mode;
	}
	
	public static boolean getSeleccionat() {
		return seleccionat;
	}
}
