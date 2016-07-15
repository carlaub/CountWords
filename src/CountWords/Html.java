package CountWords;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Html {
	private String codi = "";
	
	public Html() {
		this.codi = "<html><head><title>Resultats</title></head><body>"
				+ "<center><h1><font color=\"navy\">RESUTATS</font>"
				+ "</h1></center><center><table border=\"1px\"><tr><strong>"
				+ "<td>TEMPS</td><td>MEMORIA</td></strong></tr>"
				+ "<tr><td>" + Resultat.getTemps() + "</td><td>" + Resultat.getMemoria() + "</td></tr></table>"
				+ "</br></br><table border=\"1px\"><tr><strong><td>NUM. PARAULA</td><td>PARAULA</td><td>APARICIONS</td></strong></tr>";
	}
	
	public void afegeixCodi(String s) {
		codi += s;
	}
	public void obrePagina(File file){
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File generaFitxer() {
		FileWriter filewriter = null;
		PrintWriter printw = null;
		//Thread.sleep(2000);
		File file = new File("Resultats.html");
		try {
			filewriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printw = new PrintWriter(filewriter);//declarar un impresor
        
		printw.println(this.codi);
		printw.close();
		return file;
		 
	}

}
