import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;


public class Fitxer {
	private String nomFitxer;
	
	public Fitxer() {
		nomFitxer = new String();
	}
	
	/**
	 * Procediment encarregat de la lectura del fitxer i organitzar la informacio segons
	 * el mode triat
	 * @param opcio (mode emmagatzematge)
	 * @throws FileNotFoundException
	 */
	

	public void llegeixFitxer (int opcio) throws FileNotFoundException {

		File file = new File("Fitxers/" + nomFitxer);
		Scanner scanner=new Scanner(file);

		TreeMap <String, Integer> myMap  = new TreeMap <String, Integer> ();

		while(scanner.hasNext())
		{
			String m = scanner.nextLine();
			String [] input = m.split("[ \n\t\r,.;:!?(){}}]");

			for(int f = 0; f < input.length; f++) {         
				String key = input[f].toUpperCase();
				if(input[f].length() > 1) {
					if(myMap.get(key) == null) {
						myMap.put(key, 1);
					}   
					else {

						myMap.put(key, (myMap.get(key))+1);
					}
				}       
			}       
		}

		for(String entry : myMap.keySet()) {
			System.out.println(entry + " : "+ myMap.get(entry));
		}

	}
	
	/**
	 * Funcio encarregada de demanar al usuari el nom del fitxer a tractar
	 */
	
	public void demanaNomFitxer() {
		System.out.println("Introdueix el nom del fitxer d'entrada: ");
		Scanner sc = new Scanner(System.in);
		nomFitxer = sc.nextLine();
		System.out.println("Fitxer "+ nomFitxer + " seleccionat correctament!");	
	}

		
}
