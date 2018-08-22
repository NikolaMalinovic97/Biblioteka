package biblioteka;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class BibliotekaTest {

	public static void main(String[] args) {

		//Deklaracija pormjenljivih
		ArrayList<Racun> listaRacuna = new ArrayList<>();
		ArrayList<Knjiga> listaKnjiga = new ArrayList<>();
		ArrayList<Zapisnik> listaZapisnika = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		Scanner input = new Scanner(System.in);
		int opcija;
		
		
		//Dio programa koji se prikazuje u konzoli
		do {
			System.out.print("\n----------------------MENI----------------------"
					+ "\n1. Kreiranje racuna."
					+ "\n2. Kreiranje knjige."
					+ "\n3. Podizanje knjige iz biblioteke na odredjeni vremenski period."
					+ "\n4. Ispisivanje detalja postojecih racuna."
					+ "\n0. Izlaz."
					+ "\n-------------------------------------------------"
					+ "\nUnesite opciju: ");
			
			//Unos opcije
			while(true) {
				try {
					do {
						opcija = input.nextInt();
						if(opcija < 0 || opcija > 4)
							System.out.println("Pogresan unos pokusajte ponovo!");
					}while((opcija < 0 || opcija > 4));
					break;
				} catch (Exception e) {
					System.out.println("Pogresan unos pokusajte ponovo!");
					input.nextLine();
				}
			}
			
			boolean regularnost;
			int brRacuna, brKnjige;
			int indexRacuna=0, indexKnjige = 0;
			
			switch(opcija) {
			case 1: listaRacuna = opcija1(listaRacuna); break;
			case 2: listaKnjiga = opcija2(listaKnjiga); break;
			case 3: System.out.println("Unesite broj racuna :");
					do {
						regularnost = true;
						while(true) {
							try {
								brRacuna = input.nextInt();
								break;
							} catch (Exception e) {
								System.out.println("Pogresan unos pokusajte ponovo!");
							}
						}
						for (int i = 0; i < listaRacuna.size(); i++) {
							if(brRacuna == listaRacuna.get(i).brojRacuna) {
								indexRacuna = i;
								regularnost = false;
								break;
							}
						}
						if(regularnost)
							System.out.println("Nepostojeci broj racuna, pokusajte ponovo.");
					}while(regularnost);
					if (listaRacuna.get(indexRacuna).brojPosudjenihKnjiga == 3) {
						System.out.println("Korisnik vec ima 3 posudjene knjige.");
						break;
					}
					
					do {
						regularnost = true;
						System.out.println("Unesite broj knjige:");
						while(true) {
							try {
								brKnjige = input.nextInt();
								break;
							} catch (Exception e) {
								System.out.println("Pogresan unos pokusajte ponovo!");
								input.nextLine();
							}
						}
						for (int i = 0; i < listaKnjiga.size(); i++) {
							if(brKnjige == listaKnjiga.get(i).brojKnjige) {
								indexKnjige = i;
								regularnost = false;
								break;
							}
						}
						if(regularnost)
							System.out.println("Nepostojeci broj knjige, pokusajte ponovo.");
					}while(regularnost);
					if(listaKnjiga.get(indexKnjige).statusKnjige == false) {
						System.out.println("Knjiga je vec izdana.");
						break;
					}
					
					listaRacuna.get(indexRacuna).brojPosudjenihKnjiga++;
					listaKnjiga.get(indexKnjige).statusKnjige = false;
					listaZapisnika.add(new Zapisnik(listaRacuna.get(indexRacuna).brojRacuna, listaKnjiga.get(indexKnjige).brojKnjige, c.getTime()));
					
					break;
			case 4: opcija4(listaRacuna); break;
			}
		}while(opcija != 0);
		
		input.close();
	}

	//-------------------------------------METODE-------------------------------------------
	
	// opcija 1 ----------------------------------------------------------------------------
	private static ArrayList<Racun> opcija1(ArrayList<Racun> listaRacuna) {
		// kreiranje racuna
		ArrayList<Racun> novaLista = listaRacuna;
		System.out.print("\nUnesite broj novog racuna: ");
		boolean regularan;
		int brojRacuna;
		String ime;
		Scanner input = new Scanner(System.in);
		
		// unos broja racuna
		do {
			regularan = false;
			while(true) {
				try {
					brojRacuna = input.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Pogresan unos pokusajte ponovo!");
					input.nextLine();
				}
			}
			if(brojRacuna < 0) {
				System.out.println("Greska! Broj racuna mora biti pozitivan broj, pokusajte ponovo.");
				regularan = true;
			}	
			for (int i=0; i < listaRacuna.size(); i++) {
				if(listaRacuna.get(i).brojRacuna == brojRacuna) {
					System.out.println("Greska! Upisani broj racuna vec postoji, pokusajte ponovo.");
					regularan = true;
					break;
				}
			}
		}while(regularan);
		
		//unos imena musterije
		System.out.print("Unesite ime musterije: ");
		while(true) {
			try {
				ime = input.next();
				break;
			} catch (Exception e) {
				System.out.println("Pogresan unos pokusajte ponovo!");
			}
		}
		
		novaLista.add(new Racun(brojRacuna, ime, 0));
		return novaLista;
	}
	
	
	// opcija 2 --------------------------------------------------------------------------------
	private static ArrayList<Knjiga> opcija2(ArrayList<Knjiga> listaKnjiga) {

		ArrayList<Knjiga> novaLista = listaKnjiga;
		int brojKnjige;
		String imeKnjige;
		boolean regularan;
		Scanner input = new Scanner(System.in);
		
		// unos broja knjige
		System.out.print("Unesite broj knjige: ");
		do {
			regularan = false;
			while(true) {
				try {
					brojKnjige = input.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Pogresan unos pokusajte ponovo!");
					input.nextLine();
				}
			}
			if(brojKnjige < 0) {
				System.out.println("Greska! Broj knjige mora biti pozitivan broj, pokusajte ponovo.");
				regularan = true;
			}	
			for (int i=0; i < listaKnjiga.size(); i++) {
				if(listaKnjiga.get(i).brojKnjige == brojKnjige) {
					System.out.println("Greska! Upisani broj knjige vec postoji, pokusajte ponovo.");
					regularan = true;
					break;
				}
			}
		}while(regularan);
		
		// unos imena knjige
		System.out.print("Unesite ime knjige :");
		while(true) {
			try {
				imeKnjige = input.next();
				break;
			} catch (Exception e) {
				System.out.println("Pogresan unos pokusajte ponovo!");
			}
		}
		
		novaLista.add(new Knjiga(brojKnjige, imeKnjige, true));
		return novaLista;
	}
	
	
	// opcija 4 -------------------------------------------------------------------------
	private static void opcija4(ArrayList<Racun> listaRacuna) {
		
		if(listaRacuna.isEmpty())
			System.out.println("\nNe postoji nijedan kreiran racun.");
		else
			for(int i=0; i < listaRacuna.size(); i++) {
				System.out.println("\nBroj racuna: "+ listaRacuna.get(i).brojRacuna
									+"\n-----------------------------------"
									+"\nIme musterije: "+ listaRacuna.get(i).imeMusterije
									+"\nBroj posudjenih knjiga: "+ listaRacuna.get(i).brojPosudjenihKnjiga);
			}
	}

}
