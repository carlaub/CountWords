package mode3;

/**
 * MaxHeap ordenat segons el numero d'aparicions de cadascuna de les paraules.
 * A l'hora d'inserir primer s'haura de comprovar si la paraula ja existeix. En cas afirmatiu,
 * s'incrementara les aparicions i es recolocara en l'arbre si es cal.
 * 
 * @author carlaurrea
 *
 */

public class MaxHeap {
	private NodeMaxHeap[] maxHeap;
	private int mida;
	private int maxMida;
	
	public MaxHeap(int maxMida) {
		this.maxMida = maxMida;
		this.mida = 0;
		maxHeap = new NodeMaxHeap[maxMida +1];
		
		maxHeap[0] = new NodeMaxHeap();
		maxHeap[0].setAparicions(Integer.MAX_VALUE);
	}
	
	private int pare(int pos) {
		return pos/2;
	}
	
	private int fillDret(int pos) {
		return (2 * pos) + 1;
	}
	
	private int fillEsq(int pos) {
		return (2 * pos);
	}
	
	private boolean esFulla(int pos){
		if(pos >= (mida/2) && pos <= mida) {
			return true;
		} else {
			return false;
		}
	}
	
	private void swap (int posFi, int posOrg){
		NodeMaxHeap aux;
		
		aux = maxHeap[posFi];
		maxHeap[posFi] = maxHeap[posOrg];
		maxHeap[posOrg] = aux;
	}
	
	private void maxHeapify(int pos) {
		if (!esFulla(pos)) {
			if (maxHeap[fillEsq(pos)] != null && (maxHeap[pos].getAparicions() < maxHeap[fillEsq(pos)].getAparicions()) || (maxHeap[fillDret(pos)] != null && maxHeap[pos].getAparicions() < maxHeap[fillDret(pos)].getAparicions())) {
				if (maxHeap[fillEsq(pos)].getAparicions() > maxHeap[fillDret(pos)].getAparicions()) {
					swap(pos, fillEsq(pos));
					maxHeapify(fillEsq(pos));
					
				} else {
					swap(pos, fillDret(pos));
					maxHeapify(fillDret(pos));
				}
			}
		}
	}
	
	public void MAXHEAP_insertar(NodeMaxHeap node) {
		int aux;
		boolean trobat = false;
		
		for (int i = 1; i <= mida; i++) {
			if (maxHeap[i].getParaula().equals(node.getParaula())) {
				maxHeap[i].incAparicions();
				trobat = true;
				aux = i;
				while (maxHeap[aux].getAparicions() > maxHeap[pare(aux)].getAparicions()) {
					swap(aux, pare(aux));
					aux = pare(aux);
				}
			}
		}
		
		if(!trobat) {
			maxHeap[++mida] = node;
			aux = mida;
			
			while (maxHeap[aux].getAparicions() > maxHeap[pare(aux)].getAparicions()) {
				swap(aux, pare(aux));
				aux = pare(aux);
			}
			
		}
		
	}
	
	public void MAXHEAP_pintaMaxHeap() {
		for (int i = 1; i <=mida / 2; i++) {
			System.out.println("PARE: " + maxHeap[i].getAparicions() + " - " + maxHeap[i].getParaula() +
			" FILL ESQ: " + maxHeap[2*i].getAparicions() + " - " + maxHeap[2*i].getParaula() +
			" FILL DRET: " + maxHeap[2 * i + 1].getAparicions() + " - " + maxHeap[2* i + 1].getParaula());
		}
	}
	
	public void maxHeap() {
		for (int i = (mida / 2); i >= 1; i --){
			maxHeapify(i);
		}
	}
	
	public NodeMaxHeap MAXHEAP_esborra() {
		NodeMaxHeap elimina = maxHeap[1];
		maxHeap[1] = maxHeap[mida--];
		maxHeapify(1);
		return elimina;
	}
	
	public boolean MAXHEAP_buit() {
		if (mida == 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public int MAXHEAP_getMida(){
		return mida;
	}
	
	public NodeMaxHeap MAXHEAP_getOrdreAlfabetic(){
		int maxPos;
		int aux = 2;
		
		//Inicialitzem la posicion max
		maxPos = 1;
		while(maxHeap[maxPos].getFlag()) {
			maxPos++;
		}
		
		//Busquem les paraules per ordre alfabetic
		while (aux <= mida) {
			if(maxHeap[aux].getParaula().compareTo(maxHeap[maxPos].getParaula()) < 0 && !maxHeap[aux].getFlag()) {
				maxPos = aux;
			}
			aux++;
 		}
		//Activem el flag per marcar que la paraula ja ha estat mostrada
		maxHeap[maxPos].setFlagTrue();
		
		return maxHeap[maxPos];
	}
}
