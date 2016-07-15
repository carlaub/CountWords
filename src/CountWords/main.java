package CountWords;
import java.io.FileNotFoundException;

import visualitzacio.MenuVisualitza;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio = 0;
		Fitxer f = new Fitxer();
		Object ultExecucio = null;
		
		while(opcio != 4) {
			opcio = Menu.mostraMenu();
			
			try {
				switch (opcio) {
				case 1:
					f.demanaNomFitxer();
					break;
				case 2:
					if (Menu.getSeleccionat()) {
						Menu.seleccionaMode();
						ultExecucio = f.llegeixFitxer(Menu.getMode());
					} else {
						System.out.println("Has de seleccionar un fitxer d'entrada!");
					}
					break;
				case 3:
					if (Menu.getSeleccionat()) {
						int opcioVisualitza = MenuVisualitza.mostraMenuVisualitza();
						Resultat.mostraResultats(opcioVisualitza, ultExecucio);
					} else {
						System.out.println("Has de seleccionar un fitxer d'entrada!");
					}
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
