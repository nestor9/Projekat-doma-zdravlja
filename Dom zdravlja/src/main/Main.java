package main;

import domZdravlja.Zdrastvo;
import enumeracija.StatusPregleda;
import enumeracija.TipOsobe;
import guii.Login;
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
		Zdrastvo dom = new Zdrastvo();
		dom.ucitajLekare(Lekari_fajl);
		dom.ucitajSestre(MedSestre_fajl);
		dom.ucitajPacijenta(Pacijenti_fajl);
		dom.ucitajPreglede(Pregled_fajl);
		dom.ucitajKnjizice(Zdrastvena_fajl);
		
		Login lProzor=new Login(dom);
		lProzor.setVisible(true);
		
		/*System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(dom);
		System.out.println("----------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Lekar testLekar = new Lekar("Nikola", "Nikolic","1402998400036", TipOsobe.MUSKI, "Bulevar evrope 100", "0698873064", "Nikola22", "nikola123", "lekar", 45000, "opsti lekar", "stomatoloska sluzba");
		dom.dodajLekara(testLekar);
		
		Med_sestra testSestra = new Med_sestra("Nevena","Nesic","2103889766621", TipOsobe.ZENSKI, "Bulevar oslobodjenja 11","0644465123" ,"Nevena55", "nevena123", "medicinska sestra", 31000, "sluzba za pravne i ekonomske poslove");
		dom.dodajSestru(testSestra);
		
		Zdrastvena_knjizica testKnjizica = new Zdrastvena_knjizica("7744782","12.12.2020.",3);
		dom.dodajKnjizicu(testKnjizica);
		
		Pacijent testPacijent = new Pacijent("Jovan","Jovic","1711887600032", TipOsobe.MUSKI, "Bulevar oslobodjenja 124","0648877456" ,"Jovan88", "jovan123", "pacijent", testLekar, testKnjizica);
		dom.dodajPacijenta(testPacijent);
		
		PregledPacijenta testPregled = new PregledPacijenta(testPacijent,testLekar,"1","15.10.2019.","12C","Vadjenje krvi", StatusPregleda.ZAKAZAN);
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
		for(Lekar lekar : dom.getLekari()) {
			System.out.println(lekar + "\n");
		}
		System.out.println("Medicinske sestre:");
		System.out.println("--------------------");
		for(Med_sestra sestra : dom.getMedicinskeSestre()) {
			System.out.println(sestra + "\n");
		}
		System.out.println("Pacijenti:");
		System.out.println("--------------------" );
		for(Pacijent pacijent : dom.getPacijenti()) {
			System.out.println(pacijent + "\n");
		}
		System.out.println("Pregledi:" );
		System.out.println("--------------------");
		for(PregledPacijenta pregled : dom.getPregledi()) {
			System.out.println(pregled + "\n");
		}
		System.out.println("Knjizice:" );
		System.out.println("--------------------");
		for(Zdrastvena_knjizica knjizica : dom.getKnjizice()) {
			System.out.println(knjizica + "\n");
		}*/
		
	}
}