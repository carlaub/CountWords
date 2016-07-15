package mode2;

import mode1.LlistaOrd;
import mode1.Node;

/**
 * Segon mode. Taula de hash 27 posicions (una per cada lletra de l'abecedari)
 *  angles mes una extra per altres caracters) on cada casella constara d'una cua ordenada segons ordre alfabetic que contindra
 *  les paraules ordenades que comencen per la lletra que marca la casella.
 *  
 *  funcio de hash -> posicio = primera lletra de la paraula - 'a'
 *  
 * @author karlaurrea
 *
 */
public class TaulaHashCua {
	LlistaOrd[] taulaHashCua = new LlistaOrd[27];
	public TaulaHashCua() {
		for (int i = 0; i < taulaHashCua.length; i ++) {
			taulaHashCua[i] = new LlistaOrd();
		}
	}
	
	public int funcioHash (String paraula) {
		char lletra;
		lletra = paraula.charAt(0);
		
		if (lletra >= 'A' && lletra <= 'Z') {
			System.out.println(lletra - 'A' + 1);
			return (lletra - 'A' + 1);
		}
		System.out.println("0");
		return 0;
		
	}
	
	public void TAULAHASHCUA_inserir(String paraula, int clau) {
		taulaHashCua[clau].LLISTAORD_add(paraula);
	}
	
	public Node TAULAHASHCUA_get() {
		int posicio = 0; 
		while (taulaHashCua[posicio].LLISTAORD_buida()) {
			posicio++;
		}
		return taulaHashCua[posicio].LLISTAORD_get();
	}
	
	public boolean TAULAHASHCUA_buida() {
		int posicio = 0;
		while (posicio < taulaHashCua.length) {
			if (taulaHashCua[posicio].LLISTAORD_buida() == false) {
				return false;
			}
			posicio ++;
		}
		return true;
	}

}
