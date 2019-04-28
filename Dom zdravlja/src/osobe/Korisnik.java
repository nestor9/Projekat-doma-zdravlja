package osobe;

public abstract class Korisnik 
{
	String ime;
	String prezime;
	String jmbg;
	String pol;
	String adresa;
	String br_tel;
	String kor_Ime;
	String lozinka;
	int uloga;
	
	public Korisnik(String ime, String prezime, String jmbg, String pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, int uloga) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.br_tel = br_tel;
		this.kor_Ime = kor_Ime;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}
	
	public Korisnik()
	{
		
	}
}
