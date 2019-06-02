package osobe;

import enumeracija.TipOsobe;

public abstract class Korisnik 
{
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected TipOsobe pol;
	protected String adresa;
	protected String br_tel;
	protected String kor_Ime;
	protected String lozinka;
	protected String uloga;
	
	public Korisnik(String ime, String prezime, String jmbg, TipOsobe pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, String uloga) {
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
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = TipOsobe.MUSKI;
		this.adresa = "";
		this.br_tel = "";
		this.kor_Ime = "";
		this.lozinka = "";
		this.uloga = "";
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public TipOsobe getPol() {
		return pol;
	}

	public void setPol(TipOsobe pol) {
		this.pol = pol;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBr_tel() {
		return br_tel;
	}

	public void setBr_tel(String br_tel) {
		this.br_tel = br_tel;
	}

	public String getKor_Ime() {
		return kor_Ime;
	}

	public void setKor_Ime(String kor_Ime) {
		this.kor_Ime = kor_Ime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	@Override
	public String toString() {
		return "Korisnik \nIme: " + ime + 
						"\nPrezime: " + prezime + 
						"\nJMBG: " + jmbg + 
						"\nPol: " + pol + 
						"\nAdresa: " + adresa + 
						"\nBroj telefona: " + br_tel + 
						"\nKorisnicko ime: " + kor_Ime + 
						"\nLozinka: " + lozinka + 
						"\nUloga: " + uloga;
	}
	
	
}
