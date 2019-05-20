package osobe;

public class Med_sestra extends Korisnik
{
	private double plata;
	private String sluzba;
	
	public Med_sestra(String ime, String prezime, String jmbg, String pol, String adresa, String br_tel, String kor_Ime,
			String lozinka, String uloga, int plata, String sluzba) {
		super(ime, prezime, jmbg, pol, adresa, br_tel, kor_Ime, lozinka, uloga);
		this.plata = plata;
		this.sluzba = sluzba;
	}
	
	public Med_sestra()
	{
		this.plata = 0;
		this.sluzba = "";
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getSluzba() {
		return sluzba;
	}

	public void setSluzba(String sluzba) {
		this.sluzba = sluzba;
	}

	@Override
	public String toString() {
		return "MEDICINSKA SESTRA" + super.toString() + "\nPlata: " + plata +
							"\nSluzba: " + sluzba;
	}
	
	
	
	
}
