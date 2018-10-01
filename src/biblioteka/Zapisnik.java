package biblioteka;

import java.io.Serializable;
import java.util.Date;

public class Zapisnik implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int brojRacuna;
	int brojKnjige;
	Date datum;
	
	public Zapisnik() {
		
	}

	public Zapisnik(int brojRacuna, int brojKnjige, Date date) {
		this.brojRacuna = brojRacuna;
		this.brojKnjige = brojKnjige;
		this.datum = date;
	}
	
	
	
}
