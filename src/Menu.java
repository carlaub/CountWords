import java.util.Scanner;

public class Menu {
	private static int opcio;
	
	public Menu() {

	}
	
	public static int getOpcio() { return opcio;}
	
	public static int mostraMenu(){
		opcio = 0;
		Scanner sc = new Scanner(System.in);
		
		while (opcio < 1 && opcio > 4) {
			System.out.println("---------- Menu ----------");
			
			System.out.println("Opció?");
			opcio = sc.nextInt();
		}
		return opcio;
	}
}
