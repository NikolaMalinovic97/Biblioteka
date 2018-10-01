package biblioteka;

import java.io.Serializable;

public class Racun implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int brojRacuna;
	String imeMusterije;
	int brojPosudjenihKnjiga;
	
	public Racun() {
		
	}
	
	public Racun(int brojRacuna, String imeMusterije, int brojPosudjenihKnjiga) {
		this.brojRacuna = brojRacuna;
		this.imeMusterije = imeMusterije;
		this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
	}
	
}
