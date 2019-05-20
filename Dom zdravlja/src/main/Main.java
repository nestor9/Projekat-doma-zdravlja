package main;

import domZdravlja.DomZdravlja;
import osobe.Lekar;
import osobe.Med_sestra;
import osobe.Pacijent;
import osobe.Zdrastvena_knjizica;
import pregledPacijenta.PregledPacijenta;

public class Main {

		private static String Lekari_fajl = "lekari.txt";
		private static String MedSestre_fajl = "medicinskeSestre.txt";
		private static String Pacijenti_fajl = "pacijenti.txt";
		private static String Pregled_fajl = "pregled.txt";
		private static String Zdrastvena_fajl = "zdrastvenaKnjizica.txt";
	
	public static void main(String[] args) {
		DomZdravlja dom = new DomZdravlja();
		dom.ucitajLekare(Lekari_fajl);
		dom.ucitajSestre(MedSestre_fajl);
		dom.ucitajPacijente(Pacijenti_fajl);
		dom.ucitajPreglede(Pregled_fajl);
		dom.ucitajKnjizice(Zdrastvena_fajl);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(dom);
		System.out.println("----------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Lekar testLekar = new Lekar("Nikola", "Nikolic","1402998400036", "muskarac", "Bulevar evrope 100", "0698873064", "Nikola22", "nikola123", "lekar", 45000, "opsti lekar", "stomatoloska sluzba");
		dom.dodajLekara(testLekar);
		
		Med_sestra testSestra = new Med_sestra("Nevena","Nesic","2103889766621", "zensko", "Bulevar oslobodjenja 11","0644465123" ,"Nevena55", "nevena123", "medicinska sestra", 31000, "sluzba za pravne i ekonomske poslove");
		dom.dodajSestru(testSestra);
		
		Pacijent testPacijent = new Pacijent("Jovan","Jovic","1711887600032", "muskarac", "Bulevar oslobodjenja 124","0648877456" ,"Jovan88", "jovan123", "pacijent", "Nikola22", "7744782");
		dom.dodajPacijenta(testPacijent);
		
		Zdrastvena_knjizica testKnjizica = new Zdrastvena_knjizica("7744782","12.12.2020.",3);
		dom.dodajKnjizicu(testKnjizica);
		
		PregledPacijenta testPregled = new PregledPacijenta("147754","Jovan88","Nikola22","15.10.2019.","12C","Vadjenje krvi");
		dom.dodajPregled(testPregled);
		
		System.out.println("Snimanje dodanih podataka...");
		dom.snimiLekare(Lekari_fajl);
		dom.snimiSestre(MedSestre_fajl);
		dom.snimiPacijente(Pacijenti_fajl);
		dom.snimiPreglede(Pregled_fajl);
		dom.snimiKnjizicu(Zdrastvena_fajl);
	
	}
	public static void ispisiSvePodatke(DomZdravlja dom) {
		System.out.println("Lekari:");
		System.out.println("--------------------");
		for(Lekar lekar : DomZdravlja.getLekari()) {
			System.out.println(lekar + "\n");
		}
		System.out.println("Pacijenti:");
		System.out.println("--------------------" );
		for(Med_sestra sestra : DomZdravlja.getMedicinskeSestre()) {
			System.out.println(sestra + "\n");
		}
		System.out.println("Medicinske sestre:");
		System.out.println("--------------------");
		for(Pacijent pacijent : DomZdravlja.getPacijenti()) {
			System.out.println(pacijent + "\n");
		}
		System.out.println("Pregledi:" );
		System.out.println("--------------------");
		for(PregledPacijenta pregled : DomZdravlja.getPregledi()) {
			System.out.println(pregled + "\n");
		}
		for(Zdrastvena_knjizica knjizica : DomZdravlja.getKnjizice()) {
			System.out.println(knjizica + "\n");
		}
		
	}
}