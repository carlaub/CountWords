import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;


public class Fitxer {

	public Fitxer() {
		
	}
	
	

	public void llegeixFitxer (int opcio) throws FileNotFoundException {
		File file = new File("/CountWords/Fitxers/parrafo.txt");
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

		
}
