package osobe;

import java.util.ArrayList;

import enumeracija.TipOsobe;
import osobe.Zdrastvena_knjizica;

public class Pacijent extends Korisnik
{
	private Lekar lekari;
	private Zdrastvena_knjizica podaci_knjizice;
	
	
	public Pacijent(String ime, String prezime, String jmbg, TipOsobe pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, String uloga, Lekar lekari, Zdrastvena_knjizica podaci_knjizice) {
		super(ime, prezime, jmbg, pol, adresa, br_tel, kor_Ime, lozinka, uloga);
		this.lekari = lekari;
		this.podaci_knjizice = podaci_knjizice;
		
	}
	
	public Pacijent()
	{
		this.lekari = new Lekar();
		this.podaci_knjizice = new Zdrastvena_knjizica();
	}
	
	/*public Pacijent(Pacijent original) 
	{
		super(original);
		this.izabrani_lekar = original.izabrani_lekar;
		this.podaci_knjizice = original.podaci_knjizice;
	}*/

	public Lekar getIzabrani_lekar() {
		return lekari;
	}

	public void setIzabrani_lekar(Lekar lekari) {
		this.lekari = lekari;
	}
	
	public Zdrastvena_knjizica getPodaci_knjizice() {
		return podaci_knjizice;
	}

	public void setPodaci_knjizice(Zdrastvena_knjizica podaci_knjizice) {
		this.podaci_knjizice = podaci_knjizice;
	}

	@Override
	public String toString() {
		return "PACIJENT " + super.toString() + "\nIzabrani_lekar:" + lekari +"\nPodaci_knjizice: " + podaci_knjizice;
		
	}
	
}
