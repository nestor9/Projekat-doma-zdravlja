package osobe;

import osobe.Zdrastvena_knjizica;

public class Pacijent extends Korisnik
{
	private Lekar izabrani_lekar;
	private Zdrastvena_knjizica podaci_knjizice;
	
	
	public Pacijent(String ime, String prezime, String jmbg, String pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, String uloga, Lekar izabrani_lekar, Zdrastvena_knjizica podaci_knjizice) {
		super(ime, prezime, jmbg, pol, adresa, br_tel, kor_Ime, lozinka, uloga);
		this.izabrani_lekar = izabrani_lekar;
		this.podaci_knjizice = podaci_knjizice;
		
	}
	
	public Pacijent()
	{
		this.izabrani_lekar = new Lekar();
		this.podaci_knjizice = new Zdrastvena_knjizica();
	}
	
	/*public Pacijent(Pacijent original) 
	{
		super(original);
		this.izabrani_lekar = original.izabrani_lekar;
		this.podaci_knjizice = original.podaci_knjizice;
	}*/

	public Lekar getIzabrani_lekar() {
		return izabrani_lekar;
	}

	public void setIzabrani_lekar(Lekar izabrani_lekar) {
		this.izabrani_lekar = izabrani_lekar;
	}
	
	public Zdrastvena_knjizica getPodaci_knjizice() {
		return podaci_knjizice;
	}

	public void setPodaci_knjizice(Zdrastvena_knjizica podaci_knjizice) {
		this.podaci_knjizice = podaci_knjizice;
	}

	@Override
	public String toString() {
		return "PACIJENT " + super.toString() +  "\nIzabrani lekar: " + izabrani_lekar +
												"\nPodaci_knjizice: " + podaci_knjizice;
		
	}
	
}
