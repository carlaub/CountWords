package mode2;


//AVL ORDENAT PER PARAULA

public class AVLNode {
	
	private String paraula;
	private int aparicions;
	private AVLNode esq;
	private AVLNode dret;
	private int altura;
	
	
	public AVLNode(String paraula, int aparicions) {
		this.paraula = paraula;
		this.aparicions = aparicions;
		this.esq = null;
		this.dret = null;
	}
	
	public String getParaula() {
		return paraula;
	}

	public void setParaula(String paraula) {
		this.paraula = paraula;
	}

	public int getAparicions() {
		return aparicions;
	}

	public void setAparicions(int aparicions) {
		this.aparicions = aparicions;
	}

	public AVLNode getEsq() {
		return esq;
	}

	public void setEsq(AVLNode esq) {
		this.esq = esq;
	}

	public AVLNode getDret() {
		return dret;
	}

	public void setDret(AVLNode dret) {
		this.dret = dret;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int antura) {
		this.altura = altura;
	}

	public AVLNode(String paraula, int aparicions, AVLNode esq, AVLNode dret) {
		this.paraula = paraula;
		this.aparicions = aparicions;
		this.dret = dret;
		this.esq = esq;
		altura = 0;
	}
	
	
}
