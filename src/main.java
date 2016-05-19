import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio;
		
		opcio = Menu.mostraMenu();
		Fitxer f = new Fitxer();
		try {
			f.llegeixFitxer(Menu.getOpcio());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
