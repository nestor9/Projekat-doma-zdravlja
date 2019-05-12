package osobe;

public class Lekar extends Korisnik
{
	private double plata;
	private String specijalizacija;
	private String sluzba;
	
	public Lekar(String ime, String prezime, String jmbg, String pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, String uloga, double plata, String specijalizacija, String sluzba) {
		super(ime, prezime, jmbg, pol, adresa, br_tel, kor_Ime, lozinka, uloga);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
		this.sluzba = sluzba;
	}

	public Lekar()
	{
		this.plata = 0;
		this.specijalizacija = "";
		this.sluzba = "";
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	public String getSluzba() {
		return sluzba;
	}

	public void setSluzba(String sluzba) {
		this.sluzba = sluzba;
	}

	@Override
	public String toString() {
		return "LEKAR \nPlata: " + plata +
					  "\nSpecijalizacija: " + specijalizacija +
					  "\nSluzba: " + sluzba;
	}
	
	
	
	
	
}

