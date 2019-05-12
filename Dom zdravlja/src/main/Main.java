package main;

import domZdravlja.DomZdravlja;
import osobe.Lekar;

public class Main {

		private static String Lekari_fajl = "lekari.txt";
		private static String MedSestre_fajl = "medicinskeSestre.txt";
		private static String Pacijenti_fajl = "pacijenti.txt";
		private static String Pregled_fajl = "pregled.txt";
		private static String Zdrastvena_fajl = "zdrastvena.txt";
	
	public static void main(String[] args) {
		DomZdravlja dom = new DomZdravlja();
		dom.ucitajLekare(Lekari_fajl);
		dom.ucitajSestre(MedSestre_fajl);
		//dom.ucitajPacijente(Pacijenti_fajl);
		//dom.ucitajPreglede(Pregled_fajl);
		dom.ucitajKnjizice(Zdrastvena_fajl);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(dom);
		System.out.println("----------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Lekar testLekar = new Lekar("Nikola", "Nikolic","1402998400036", "muskarac", "Bulevar evrope 100", "0698873064", "Nikola22", "nikola123", "lekar", 45000, "opsti lekar", "stomatoloska sluzba");
		dom.dodajLekara(testLekar);
		
		System.out.println("Snimanje dodanih podataka...");
		dom.snimiLekare(Lekari_fajl);
		dom.snimiSestre(MedSestre_fajl);
		dom.snimiPacijente(Pacijenti_fajl);
		dom.snimiPreglede(Pregled_fajl);
		dom.snimiKnjizicu(Zdrastvena_fajl);
	
	}
	public static void ispisiSvePodatke(DomZdravlja dom) {
		/*for(Lekar lekar : DomZdravlja.getLekari()) {
			System.out.println(lekar + "\n");
		}
		*/
	}
}