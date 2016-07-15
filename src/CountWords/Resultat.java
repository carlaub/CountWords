package CountWords;

import mode1.Node;
import mode2.TaulaHashCua;
import mode1.LlistaOrd;

public class Resultat {
	private static long temps;
	private static long memoria;
	
	public static float getTemps() {
		return temps;
	}
	
	public static long getMemoria() {
		return memoria;
	}
	
	public static void setTemps(long tempsUlt) {
		temps = tempsUlt;
	}
	
	public static void setMemoria(long memoriaUlt) {
		memoria = memoriaUlt;
	}
	
	
	public static void mostraResultats (int opcioVisualitza, Object ultExecucio) {
		Html fitxer = new Html();
		int posicio = 1;
		
		switch (Menu.getMode()) {
			case 1:
				//Cua Ordenada Alfabeticament

				Node element;
				
				
				LlistaOrd llistaOrd = ((LlistaOrd) ultExecucio);
				
				switch(opcioVisualitza) {
					//Cas ordenacio per numero d'aparicions
					case 1:
						while (!llistaOrd.LLISTAORD_buida()){
							element = llistaOrd.LLISTAORD_getMaxApa();
							fitxer.afegeixCodi("<tr><td>" + posicio +"</td><td>" + element.getNom() + "</td><td>" + element.getAparicions() + "</td></tr>" );
							posicio ++;
						}
						
						break;
						
					//Cas ordenacio alfabetica
					case 2:
						while (!llistaOrd.LLISTAORD_buida()) {
							element = llistaOrd.LLISTAORD_get();
						
							fitxer.afegeixCodi("<tr><td>" + posicio +"</td><td>" + element.getNom() + "</td><td>" + element.getAparicions() + "</td></tr>" );
							posicio ++;
						}
						
						
						break;
				}
				
				break;
				
			case 2:
				//Taula Hash amb cua
				TaulaHashCua taulaHashCua = (TaulaHashCua)ultExecucio; 
				
				switch(opcioVisualitza) {
					case 1:
						while(!taulaHashCua.TAULAHASHCUA_buida()) {
							Node node = taulaHashCua.TAULAHASHCUA_get();
							System.out.println(node.getNom());
							System.out.println(node.getAparicions());
						}
						break;
					case 2:
						while (!taulaHashCua.TAULAHASHCUA_buida()) {
							Node node = taulaHashCua.TAULAHASHCUA_get();

							fitxer.afegeixCodi("<tr><td>" + posicio +"</td><td>" + node.getNom() + "</td><td>" + node.getAparicions() + "</td></tr>" );
							posicio ++;
						}
						System.out.println("SALE");
						break;
				}
				break;
			case 3:
				break;
			case 4:
				break;
		}
		
		fitxer.afegeixCodi("</table></html>");
		//Obrim la pagina web al navegador
		fitxer.obrePagina(fitxer.generaFitxer());
		
		System.out.println("**** Per mostrar novament els resultats,");
		System.out.println("torna calcula les aparicions (Opció 2) ****");
	}
}
