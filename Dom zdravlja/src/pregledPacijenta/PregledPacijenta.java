package pregledPacijenta;

import enumeracija.StatusPregleda;
import osobe.Lekar;
import osobe.Pacijent;

public class PregledPacijenta
{
	private Pacijent pacijent;
	private Lekar lekar;
	private String br_pregleda;
	private String termin;
	private String br_sobe;
	private String opis;
	private StatusPregleda status_pregleda;
	
	public PregledPacijenta() {
		this.pacijent = new Pacijent();
		this.lekar = new Lekar();
		this.br_pregleda = "";
		this.termin = "";
		this.br_sobe = "";
		this.opis = "";
		this.status_pregleda = StatusPregleda.ZATRAZEN;
	}

	public PregledPacijenta(Pacijent pacijent, Lekar lekar,String br_pregleda, String termin, String br_sobe, String opis, StatusPregleda status_pregleda) {
		super();
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.br_pregleda = br_pregleda;
		this.termin = termin;
		this.br_sobe = br_sobe;
		this.opis = opis;
		this.status_pregleda = status_pregleda;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	
	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
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

	public StatusPregleda getStatus_pregleda() {
		return status_pregleda;
	}

	public void setStatus_pregleda(StatusPregleda status_pregleda) {
		this.status_pregleda = status_pregleda;
	}
	
	public String getBr_pregleda()
	{
		return br_pregleda;
	}
	public void setBr_pregleda(String br_pregleda)
	{
		this.br_pregleda = br_pregleda;
	}

	@Override
	public String toString() {
		return "\nPacijent: " + pacijent
				 + "\nLekar: " + lekar
				 + "\nID: " + br_pregleda
				 + "\nTermin: " + termin
				 + "\nBroj sobe: " + br_sobe
				 + "\nOpis: " + opis
				 + "\nStatus: " + status_pregleda;
	}
	
	
}
