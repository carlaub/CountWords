import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio = 0;
		Fitxer f = new Fitxer();
		
		while(opcio != 4) {
			opcio = Menu.mostraMenu();
			
			try {
				switch (opcio) {
				case 1:
					f.demanaNomFitxer();
					break;
				case 2:
					Menu.seleccionaMode();
					f.llegeixFitxer(Menu.getMode());
					break;
				case 3:
					break;
				case 4:
					System.out.println("\nAdeu!");
					break;
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
