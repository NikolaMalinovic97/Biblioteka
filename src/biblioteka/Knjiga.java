package biblioteka;

import java.io.Serializable;

public class Knjiga implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
