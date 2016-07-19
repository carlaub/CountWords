package mode3;

/**
 * Estructura de cada node que formara el max heap
 * @author carlaurrea
 *
 */
public class NodeMaxHeap {
	private String paraula; 
	private int aparicions;
	//utilitzat a l'hora de mostrar les paraules per ordre alfabetic
	private boolean flag = false;
	
	public NodeMaxHeap() {
		
	}
	
	public NodeMaxHeap(int aparicions, String paraula) {
		this.paraula = paraula;
		this.aparicions = aparicions;
	}
	
	public void setAparicions (int aparicions) {
		this.aparicions = aparicions;
	}
	
	public void setParaula (String paraula) {
		this.paraula = paraula;
	}
	
	public void incAparicions() {
		this.aparicions ++;
	}
	
	public int getAparicions(){
		return this.aparicions;
	}
	
	public String getParaula(){
		return this.paraula;
	}
	
	public void setFlagTrue(){
		this.flag = true;
	}
	
	
	public boolean getFlag(){
		return this.flag;
	}

}
