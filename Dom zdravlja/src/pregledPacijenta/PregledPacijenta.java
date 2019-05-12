package pregledPacijenta;

import java.util.*;

import osobe.Lekar;
import osobe.Pacijent;

public class PregledPacijenta extends Lekar
{
	private ArrayList<Pacijent> pacijent;
	private ArrayList<Lekar> doktor;
	private Date termin;
	private String br_sobe;
	private String opis;
	private String status_pregleda;  //treba enumeracija na StatusPregleda
	
	public PregledPacijenta() {
		this.pacijent = new ArrayList<Pacijent>();
		this.doktor = new ArrayList<Lekar>();
		this.termin = new Date();
	}

	public PregledPacijenta(String ime, String prezime, String jmbg, String pol, String adresa, String br_tel,
			String kor_Ime, String lozinka, String uloga, double plata, String specijalizacija, String sluzba,
			ArrayList<Pacijent> pacijent, ArrayList<Lekar> doktor, Date termin, String br_sobe, String opis,
			String status_pregleda) {
		super(ime, prezime, jmbg, pol, adresa, br_tel, kor_Ime, lozinka, uloga, plata, specijalizacija, sluzba);
		this.pacijent = pacijent;
		this.doktor = doktor;
		this.termin = termin;
		this.br_sobe = br_sobe;
		this.opis = opis;
		this.status_pregleda = status_pregleda;
	}

	public ArrayList<Pacijent> getPacijent() {
		return pacijent;
	}

	public void setPacijent(ArrayList<Pacijent> pacijent) {
		this.pacijent = pacijent;
	}

	public ArrayList<Lekar> getLekar() {
		return doktor;
	}

	public void setLekar(ArrayList<Lekar> doktor) {
		this.doktor = doktor;
	}

	public Date getTermin() {
		return termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public String getBr_sobe() {
		return br_sobe;
	}

	public void setBr_sobe(String br_sobe) {
		this.br_sobe = br_sobe;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getStatus_pregleda() {
		return status_pregleda;
	}

	public void setStatus_pregleda(String status_pregleda) {
		this.status_pregleda = status_pregleda;
	}

	@Override
	public String toString() {
		String str = "PREGLED PACIJENTA " + super.toString() + 
						"\nTermin: " + termin + 
						"\nBroj sobe: " + br_sobe + 
						"\nOpis: " + opis + 
						"\nStatus Pregleda: " + status_pregleda;
		for(Lekar lekar : doktor)
		{
			str +="\n" + lekar;
		}
		return str;
	}
	
	
}
