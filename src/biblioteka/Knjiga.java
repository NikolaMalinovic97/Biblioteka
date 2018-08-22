package biblioteka;

import java.io.Serializable;

public class Knjiga implements Serializable{

	int brojKnjige;
	String imeKnjige;
	boolean statusKnjige;
	
	
	public Knjiga() {
		
	}
	
	public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {
		this.brojKnjige = brojKnjige;
		this.imeKnjige = imeKnjige;
		this.statusKnjige = statusKnjige;
	}
	
	
}
