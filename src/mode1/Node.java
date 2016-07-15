package mode1;

public class Node {
	private String nom;
	private int aparicions;
	private Node seg;
	
	public Node(){
		nom = "";
		aparicions = 0;
		seg = null;
	}
	
	public Node (String nom){
		this.nom = nom;
		this.aparicions = 1;
	}
	
	public void setNom (String nom){
		this.nom = nom;
	}
	
	public void setAparicions (int aparicions) {
		this.aparicions = aparicions;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getAparicions() {
		return aparicions;
	}
	
	public Node getSeg() {
		return seg;
	}
	
	public void setSeg (Node seg) {
		this.seg = seg;
	}

}
