package mode1;

public class Node {
	String paraula;
	int aparicions;
	
	//ELEMENT_crea
	public Node() {
		paraula = new String();
		aparicions = 0;
	}
	
	public String getParaula() {
		return paraula;
	}
	
	public void setParaula(String paraula) {
		this.paraula = paraula;
	}
	
	public void setAparicions(int apar){
		this.aparicions = aparicions;
	}
	
	public int getAparicions() {
		return aparicions;
	}
	
	public void incAparicions() {
		this.aparicions = this.aparicions + 1;
	}
	
	public int compara(Node node, int modeComparacio, int camp){
		if (this.paraula == null || node.paraula == null) {
			return 0;
		}
		
		//MAJOR       1
		//MENOR       2
		//IGUAL       3
		//MAJOR_IGUAL 4
		//MENOR_IGUAL 5
		
		switch(modeComparacio) {
			case 1: //MAJOR
				switch (camp) {
					case 0: //PARAULA
						if (this.paraula.compareTo(node.paraula) < 0){
							return 1;
						}
						return 0;	
					case 1: //APARICIONS
						if(this.aparicions > node.aparicions) {
							return 1;
						}
						return 0;	
				}
				
			case 2: //MENOR
				switch (camp) {
					case 0: //PARAULA
						if(this.paraula.compareTo(node.paraula) > 0) {
							return 1;
						}
						return 0;
					case 1: //APARICIONS
						if(this.aparicions < node.aparicions) {
							return 1;
						}
						return 0;
				}
				
								
			case 3: //IGUAL
				switch (camp){
					case 0: //PARAULA
						if(this.paraula.compareTo(node.paraula) == 0) {
							return 1;
						}
						return 0;
					case 1: //APARICIONS
						if(this.aparicions == node.aparicions) {
							return 1;
						}
						return 0;	
				}
				break;
				
			case 4: //MAJOR_IGUAL
				switch (camp){
				case 0: //PARAULA
					if(this.paraula.compareTo(node.paraula) >= 0) {
						return 1;
					}
					return 0;
				case 1: //APARICIONS
					if(this.aparicions >= node.aparicions) {
						return 1;
					}
					return 0;	
			}	
				break;
				
			case 5: //MENOR_IGUAL
				switch (camp){
				case 0: //PARAULA
					if(this.paraula.compareTo(node.paraula) <= 0) {
						return 1;
					}
					return 0;
				case 1: //APARICIONS
					if(this.aparicions <= node.aparicions) {
						return 1;
					}
					return 0;	
			}
				break;
				
			default:
				return 0;
		}
	return 0;
	}	
}			
						
				
				
				
					
				
					
				

							
				
				
				
				

	

