package mode2;

public class AVLArbre {
	private AVLNode arrel;
	
	public void insert (String paraula, int aparicions) {
		arrel = inserir(paraula, aparicions, arrel);		
	}
	
	public int altura(AVLNode arbre) {
		if (arbre == null) {
			return -1;
		}else {
			return arbre.getAltura();
		}
	}
	
	private AVLNode inserir (String paraula, int aparicions, AVLNode arrel) {
		if (arrel == null){
			arrel = new AVLNode(paraula ,aparicions, null,null);
		}else{
			if(paraula.compareTo(arrel.getParaula()) < 0){
				arrel.setEsq(inserir(paraula, aparicions, arrel.getEsq()));
				if(altura(arrel.getEsq()) - altura(arrel.getDret()) == 2) {
					if (paraula.compareTo(arrel.getEsq().getParaula()) < 0 ) {
						//Primer cas
						arrel = rotacioFillEsq(arrel); 
					} else {
						//segon cas
						arbre = rotacioDobleFillEsq (arrel);
					}
				}
			} else {
				if(paraula.compareTo(arrel.getParaula()) > 0) {
					arrel.setDret(inserir(paraula, aparicions, arrel));
					
					if(altura(arrel.getDret()) - altura(arrel.getEsq()) == 2) {
						if (paraula.compareTo(arrel.getDret().getParaula()) > 0) {
							//Quart cas
							arrel = rotacioFillDret(arrel);
						} else {
							//Tercer cas
							arrel = rotacioDobleFillDret(arrel);
						}
					}
				} else {
					//Cas paraula igual
					if (paraula.compareTo(arrel.getParaula()) == 0) {
						arrel.setAparicions(arrel.getAparicions() + 1);
					}
				}
			}
		}
	}
	
	private static int max (int alturaEsq, int alturaDret) {
		if (alturaEsq > alturaDret) {
			return alturaEsq;
		} else {
			return alturaDret;
		}
	}
	
	private static AVLNode rotacioFillEsq(AVLNode arrel) {
		
	}
	

}
