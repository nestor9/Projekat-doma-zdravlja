package osobe;

import java.util.ArrayList;

import osobe.Zdrastvena_knjizica;

public class Pacijent extends Korisnik
{
	private String izabrani_lekar;
	private ArrayList<Zdrastvena_knjizica> podaci_knjizice;
	
	
	public Pacijent(String ime, String prezime, String jmbg, String pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, String uloga, String izabrani_lekar, ArrayList<Zdrastvena_knjizica> podaci_knjizice) {
		super(ime, prezime, jmbg, pol, adresa, br_tel, kor_Ime, lozinka, uloga);
		this.izabrani_lekar = izabrani_lekar;
		this.podaci_knjizice = podaci_knjizice;
		
	}
	
	public Pacijent()
	{
		this.izabrani_lekar = "";
		this.podaci_knjizice = new ArrayList<Zdrastvena_knjizica>();
	}

	public String getIzabrani_lekar() {
		return izabrani_lekar;
	}

	public void setIzabrani_lekar(String izabrani_lekar) {
		this.izabrani_lekar = izabrani_lekar;
	}
	
	public ArrayList<Zdrastvena_knjizica> getPodaci_knjizice() {
		return podaci_knjizice;
	}

	public void setKompozicije(ArrayList<Zdrastvena_knjizica> podaci_knjizice) {
		this.podaci_knjizice = podaci_knjizice;
	}

	@Override
	public String toString() {
		String s = "PACIJENT " + super.toString() +  "\nIzabrani lekar: " + izabrani_lekar;
		for (Zdrastvena_knjizica zdrastvena_knjizica : podaci_knjizice) {
			s += "\n" + zdrastvena_knjizica;
		}
		return s;
	}
	
}
