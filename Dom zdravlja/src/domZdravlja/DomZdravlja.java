package domZdravlja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Date;

import enumeracija.StatusPregleda;
import enumeracija.TipOsobe;
import osobe.Korisnik;
import osobe.Lekar;
import osobe.Med_sestra;
import osobe.Pacijent;
import osobe.Pol;
import osobe.Zdrastvena_knjizica;
import pregledPacijenta.PregledPacijenta;

public class DomZdravlja {
	//private ArrayList<String> lista1 = new ArrayList<String>();
		//private ArrayList<PregledPacijenta> preglediPacijenata = new ArrayList<PregledPacijenta>();
//		private ArrayList<String> lista = new ArrayList<String>();
//		private ArrayList<Pregled> preglediLekara = new ArrayList<Pregled>();
	private ArrayList<Lekar> lekari;
	private ArrayList<Med_sestra> medicinskeSestre;
	private ArrayList<Pacijent> pacijenti;
	private ArrayList<PregledPacijenta> pregledi;
	private ArrayList<Zdrastvena_knjizica> knjizice;

	public DomZdravlja() {
		this.lekari = new ArrayList<Lekar>();
		this.medicinskeSestre = new ArrayList<Med_sestra>();
		this.pacijenti = new ArrayList<Pacijent>();
		this.pregledi = new ArrayList<PregledPacijenta>();
		this.knjizice = new ArrayList<Zdrastvena_knjizica>();
	}
	
	public ArrayList<Lekar> getLekari() {
		return lekari;
	}
	
	public void dodajLekara(Lekar lekar) {
		this.lekari.add(lekar);
	}
	
	public void obrisiLekara(Lekar lekar) {
		this.lekari.remove(lekar);
	}
	
	public Lekar nadjiLekara(String korIme) {
		for (Lekar lekar : lekari) {
			if (lekar.getKor_Ime().equals(korIme)) {
				return lekar;
			}
		}
		return null;
	}
	
	public ArrayList<Med_sestra> getMedicinskeSestre() {
		return medicinskeSestre;
	}
	
	public void dodajSestru(Med_sestra med_sestra) {
		this.medicinskeSestre.add(med_sestra);
	}
	
	public void obrisiSestru(Med_sestra med_sestra) {
		this.medicinskeSestre.remove(med_sestra);
	}
	
	public Med_sestra nadjiSestru(String korIme) {
		for (Med_sestra med_sestra : medicinskeSestre) {
			if (med_sestra.getKor_Ime().equals(korIme)) {
				return med_sestra;
			}
		}
		return null;
	}
	
	public ArrayList<Pacijent> getPacijenti() {
		return pacijenti;
	}
	
	public void dodajPacijenta(Pacijent pacijent) {
		this.pacijenti.add(pacijent);
	}
	
	public void obrisiPacijenta(Pacijent pacijent) {
		this.pacijenti.remove(pacijent);
	}
	
	public Pacijent nadjiPacijenta(String korIme) {
		for (Pacijent pacijent : pacijenti) {
			if (pacijent.getKor_Ime().equals(korIme)) {
				return pacijent;
			}
		}
		return null;
	}
	public ArrayList<PregledPacijenta> getPregledi() {
		return pregledi;
	}
	
	public void dodajPregled(PregledPacijenta pregled) {
		this.pregledi.add(pregled);
	}
	
	public void obrisiPregled(PregledPacijenta pregled) {
		this.pregledi.remove(pregled);
	}
	
	public PregledPacijenta nadjiPregled(String brojPregleda) {
		for (PregledPacijenta pregled : pregledi) {
			if (pregled.getBr_pregleda().equals(brojPregleda)) {
				return pregled;
			}
		}
		return null;
	}
	
	public ArrayList<Zdrastvena_knjizica> getKnjizice() {
		return knjizice;
	}
	
	public void dodajKnjizicu(Zdrastvena_knjizica knjizica) {
		this.knjizice.add(knjizica);
	}
	
	public void obrisiKnjizicu(Zdrastvena_knjizica knjizica) {
		this.knjizice.remove(knjizica);
	}
	
	public Zdrastvena_knjizica nadjiKnjizicu(String brKnjizice) {
		for (Zdrastvena_knjizica knjizica : knjizice) {
			if (knjizica.getBroj_zdras_knjiz().equals(brKnjizice)) {
				return knjizica;
			}
		}
		return null;
	}
	
	public void obrisiKorisnika(Korisnik k) {
		if (k instanceof Lekar) {
			obrisiLekara((Lekar) k);
		} else if(k instanceof Med_sestra){
			obrisiSestru((Med_sestra) k);
		}
		else
		{
			obrisiPacijenta((Pacijent) k);
		}
	}

	public Korisnik nadjiKorisnika(String korIme) {
		for (Lekar lekar : lekari) {
			if (lekar.getKor_Ime().equals(korIme)) {
				return lekar;
			}
		}
		for (Med_sestra med_sestra : medicinskeSestre) {
			if (med_sestra.getKor_Ime().equals(korIme)) {
				return med_sestra;
			}
		}
		for (Pacijent pacijent : pacijenti) {
			if (pacijent.getKor_Ime().equals(korIme)) {
				return pacijent;
			}
		}
		return null;
	}
	
	public void snimiLekare(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Lekar lekar : lekari) {
				content += lekar.getIme() + "|" + lekar.getPrezime() + "|"
						+ lekar.getJmbg() + "|" + lekar.getPol() + "|"
						+ lekar.getAdresa() + "|" + lekar.getBr_tel() + "|"
						+ lekar.getKor_Ime() + "|" + lekar.getLozinka() + "|" + lekar.getUloga() + "|"
						+ lekar.getPlata() + "|" + lekar.getSpecijalizacija() + "|" + lekar.getSluzba() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja lekara.");
		}
	}
	public void snimiSestre(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Med_sestra sestra : medicinskeSestre) {
				content += sestra.getIme() + "|" + sestra.getPrezime() + "|"
						+ sestra.getJmbg() + "|" + sestra.getPol() + "|"
						+ sestra.getAdresa() + "|" + sestra.getBr_tel() + "|"
						+ sestra.getKor_Ime() + "|" + sestra.getLozinka() + "|" + sestra.getUloga() + "|"
						+ sestra.getPlata() + "|" + sestra.getSluzba() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja medicinske sestre.");
		}
	}
	
	public void snimiPacijente(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Pacijent pacijent : pacijenti) {
				content += pacijent.getIme() + "|" + pacijent.getPrezime() + "|"
						+ pacijent.getJmbg() + "|" + pacijent.getPol() + "|"
						+ pacijent.getAdresa() + "|" + pacijent.getBr_tel() + "|"
						+ pacijent.getKor_Ime() + "|" + pacijent.getLozinka() + "|" + pacijent.getUloga() + "|"
						+ pacijent.getIzabrani_lekar() + "|" + pacijent.getPodaci_knjizice() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pacijenta.");
		}
	}
	
	public void snimiPreglede(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (PregledPacijenta pregled : pregledi) {
				content += pregled.getPacijent() + "|" + pregled.getLekar() + "|"
						+ pregled.getTermin() + "|" + pregled.getBr_sobe() + "|"
						+ pregled.getOpis() + "|" + pregled.getStatus_pregleda() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pregleda.");
		}
	}
	
	public void snimiKnjizicu(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Zdrastvena_knjizica knjizica : knjizice) {
				content += knjizica.getBroj_zdras_knjiz() + "|" + knjizica.getDatum_isteka() + "|"
						+ knjizica.getKategorija() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zdrastvene knjizice.");
		}
	}
	
	public void ucitajLekare(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int polInt = Integer.parseInt(split[3]);
				TipOsobe pol = TipOsobe.fromInt(polInt);
				String adresa = split[4];
				String br_tel = split[5];
				String kor_ime = split[6];
				String lozinka = split[7];
				String uloga = split[8];
				String plataString = split[9];
				double plata = Double.parseDouble(plataString);
				String specijalizacija = split[10];
				String sluzba = split[11];
				Lekar lekar = new Lekar(ime, prezime, jmbg, pol, adresa, br_tel, kor_ime, lozinka, uloga, plata, specijalizacija, sluzba);
				lekari.add(lekar);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o lekarima");
			e.printStackTrace();
		}
	}
	
	public void ucitajSestre(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int polInt = Integer.parseInt(split[3]);
				TipOsobe pol = TipOsobe.fromInt(polInt);
				String adresa = split[4];
				String br_tel = split[5];
				String kor_ime = split[6];
				String lozinka = split[7];
				String uloga = split[8];
				String plataString = split[9];
				int plata = Integer.parseInt(plataString);
				String sluzba = split[10];
				Med_sestra sestra = new Med_sestra(ime, prezime, jmbg, pol, adresa, br_tel, kor_ime, lozinka, uloga, plata,  sluzba);
				medicinskeSestre.add(sestra);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o medicinskim sestrama");
			e.printStackTrace();
		}
	}
	
	public void ucitajPacijente(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int polInt = Integer.parseInt(split[3]);
				TipOsobe pol = TipOsobe.fromInt(polInt);
				String adresa = split[4];
				String br_tel = split[5];
				String kor_ime = split[6];
				String lozinka = split[7];
				String uloga = split[8];
				Lekar izabrani_lekar=new Lekar();
				Zdrastvena_knjizica podaci_knjizice=new Zdrastvena_knjizica();
				Pacijent pacijent = new Pacijent(ime, prezime, jmbg, pol, adresa, br_tel, kor_ime, lozinka, uloga, izabrani_lekar, podaci_knjizice);
				pacijenti.add(pacijent);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o pacijentu");
			e.printStackTrace();
		}
	}
	
	public void ucitajKnjizice(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String broj = split[0];
				String datum = split[1];
				String kategorijaString = split[2];
				int kategorija = Integer.parseInt(kategorijaString);
				Zdrastvena_knjizica knjizica = new Zdrastvena_knjizica(broj, datum, kategorija);
				knjizice.add(knjizica);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o zdrastvenim knjizicama");
			e.printStackTrace();
		}
	}
	
	public void ucitajPreglede(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String br_pregleda = split[0];
				String korImePacijenta = split[1];
				String korImeLekara = split[2];
				String termin = split[3];
				String br_sobe = split[4];
				String opis = split[5];
				StatusPregleda status = StatusPregleda.ZAKAZAN;
				Pacijent pregledPacijenta=new Pacijent();
				Lekar pregledLekara=new Lekar();
				for (Lekar lekar : lekari) {
					if (korImeLekara.equals(lekar.getKor_Ime()))
						pregledLekara=lekar;
						}
				for (Pacijent pacijent : pacijenti) {
					if (korImePacijenta.equals(pacijent.getKor_Ime()))
						pregledPacijenta=pacijent;
						}
				PregledPacijenta pregled = new PregledPacijenta(pregledPacijenta, pregledLekara, br_pregleda, termin, br_sobe, opis, status);
				pregledi.add(pregled);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o pregledima pacijenata");
			e.printStackTrace();
		}
	}
	
}
