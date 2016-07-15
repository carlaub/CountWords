package CountWords;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.TreeMap;

import mode1.LlistaOrd;
import mode1.Node;
import mode2.TaulaHashCua;


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
	

	public Object llegeixFitxer (int opcio) throws FileNotFoundException {

		File file = new File("Fitxers/" + nomFitxer);
		Scanner scanner=new Scanner(file);
		long tempsInici;
		Runtime runtime;
		long freeMemoryInici;
		long freeMemoryFi;
		
		switch (opcio) {
			case 1:
				//Creem la llista
				LlistaOrd llistaOrd = new LlistaOrd();
				
				//Comencem a comptar le temps
				tempsInici =System.currentTimeMillis();
				
				//Guardem la memoria lliure
				runtime = Runtime.getRuntime();
				freeMemoryInici = runtime.freeMemory();
				
				while(scanner.hasNext()){
					String m = scanner.nextLine();
					//String [] input = m.split("[ \n\t\r,.;:!?(){}}]");
					String [] input = m.split("\\W+");
					
					
					for(int f = 0; f < input.length; f++) {         
						String key = input[f].toUpperCase();
						if(key.length()>0 && key.equals('"') == false) {
							
							key = key.replaceAll("_", "");
							//key = key.replaceAll("'", "");
							
							llistaOrd.LLISTAORD_add(key);
						}
					}
				}   
				
				//Guardem el temps d'execucio
				Resultat.setTemps(System.currentTimeMillis() - tempsInici);
				//Guardem memoria emprada
				
				freeMemoryFi = runtime.freeMemory();
				System.out.println("MEMORIA:" + (freeMemoryInici - freeMemoryFi));
				Resultat.setMemoria(freeMemoryInici - freeMemoryFi);
				
				System.out.println("MEM INICI: " + freeMemoryInici);
				System.out.println("MEM FI: " + freeMemoryFi);
				System.out.println("MEM UTILITZADA: " + Resultat.getMemoria());
				System.out.println("TEMPS: "+ Resultat.getTemps());
				System.out.println("\n\nLEEMOS DE LA LISTA");
				/*while(!llistaOrd.LLISTAORD_buida()) {
					Node node = llistaOrd.LLISTAORD_get();
					System.out.println("LISTA NOM: " + node.getNom() );
					System.out.println("LISTA APA: " + node.getAparicions() );
				}*/
				return llistaOrd;
				
			case 2:
				
				//Creem la taula
				TaulaHashCua taulaHashCua = new TaulaHashCua();
				
				//Comencem a comptar le temps
				tempsInici =System.currentTimeMillis();
				
				//Guardem la memoria lliure
				runtime = Runtime.getRuntime();
				freeMemoryInici = runtime.freeMemory();
				
				while(scanner.hasNext()){
					String m = scanner.nextLine();
					
					String [] input = m.split("\\W+");
					
					
					for(int f = 0; f < input.length; f++) {    
						
						String key = input[f].toUpperCase();
						if(key.length()>0 && key.equals('"') == false) {
							key = key.replaceAll("_", "");
							
							
							//Inserim
							taulaHashCua.TAULAHASHCUA_inserir(key, taulaHashCua.funcioHash(key));
							
							
						}
					}
				}   
				
				//Guardem el temps d'execucio
				Resultat.setTemps(System.currentTimeMillis() - tempsInici);
				//Guardem memoria emprada
				
				freeMemoryFi = runtime.freeMemory();
				System.out.println("MEMORIA:" + (freeMemoryInici - freeMemoryFi));
				Resultat.setMemoria(freeMemoryInici - freeMemoryFi);
				
				System.out.println("MEM INICI: " + freeMemoryInici);
				System.out.println("MEM FI: " + freeMemoryFi);
				System.out.println("MEM UTILITZADA: " + Resultat.getMemoria());
				System.out.println("TEMPS: "+ Resultat.getTemps());
				
				return taulaHashCua;

				
			case 3:
				return null;
			case 4:
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
				return null;
			
		}
		return null;
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
