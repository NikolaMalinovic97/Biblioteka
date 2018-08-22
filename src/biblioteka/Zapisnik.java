package biblioteka;

import java.io.Serializable;
import java.util.Date;

public class Zapisnik implements Serializable{

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
