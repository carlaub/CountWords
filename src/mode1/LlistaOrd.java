package mode1;



public class LlistaOrd {
	private Node pri;
	private int tamany;
	
	public LlistaOrd() {
		pri = new Node();
		tamany = 0;
	}
	
	public int getTamany() {
		return tamany;
	}
	
	public boolean LLISTAORD_buida() {
		return pri.getSeg() == null;
	}
	
	public void LLISTAORD_add(String nom) {
		boolean trobat = false;
		Node aux = null;
		Node nou;
		//Busquem si ja es troba a l'estructura
		//si ja ha aparegut abans
		aux = pri;
		while (aux.getSeg() != null && !trobat) {
			if (aux.getSeg().getNom().equals(nom)) {
				trobat = true;
				aux.getSeg().setAparicions(aux.getSeg().getAparicions()+1);
			}
			aux = aux.getSeg();
		}
		
		if (!trobat) {
			aux = pri;
			while (aux.getSeg() != null && nom.compareTo(aux.getSeg().getNom()) > 0) {
				aux = aux.getSeg();
			}

			nou = new Node(nom);
			nou.setSeg(aux.getSeg());
			aux.setSeg(nou);
			tamany ++;
		}

	}
	
	public Node LLISTAORD_get() {
		Node aux = null;
		if (tamany == 0) {
			System.out.println("Cua buida!");	
		} else {
			//Agafem el primer node
			aux = pri.getSeg();
			//Posem al nose succesor com a cap
			pri.setSeg(aux.getSeg());
			tamany --;
		}
		return aux;
	}
	
	public Node LLISTAORD_getMaxApa(){
		Node max = null;
		Node aux = null;
		Node punter = null;
		int maxApa = 0;
		
		//Cada vegada que volem extreure l'element amb el maxim d'aparicions
		//el cost s'incrementa drasticament (O(n)) en comparacio a l'extraccio per
		//ordre alfabètic (O(1))
		//Hem de recorre l'estructura cercant l'element amb el maxim d'aparicions
		
		if (tamany == 0) {
			System.out.println("Cua buida!");
		} else {
			aux = pri;
			while (aux.getSeg() != null) {
				if(aux.getSeg().getAparicions() > maxApa){
					punter = aux;
					maxApa = aux.getSeg().getAparicions();
				}
				aux = aux.getSeg();
			}
			
			max = punter.getSeg();
			punter.setSeg(max.getSeg());
			tamany --;
		}
		
		
		return max;
	}
	
}
