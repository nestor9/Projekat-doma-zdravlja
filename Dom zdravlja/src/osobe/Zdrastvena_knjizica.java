package osobe;

public class Zdrastvena_knjizica 
{
	private String broj_zdras_knjiz;
	private String datum_isteka;
	private int kategorija;
	
	public Zdrastvena_knjizica(String broj_zdras_knjiz, String datum_isteka, int kategorija) 
	{
		this.broj_zdras_knjiz = broj_zdras_knjiz;
		this.datum_isteka = datum_isteka;
		this.kategorija = kategorija;
	}
	
	public Zdrastvena_knjizica()
	{
		this.broj_zdras_knjiz = "";
		this.datum_isteka = "";
		this.kategorija = 0;
	}

	public String getBroj_zdras_knjiz() {
		return broj_zdras_knjiz;
	}

	public void setBroj_zdras_knjiz(String broj_zdras_knjiz) {
		this.broj_zdras_knjiz = broj_zdras_knjiz;
	}

	public String getDatum_isteka() {
		return datum_isteka;
	}

	public void setDatum_isteka(String datum_isteka) {
		this.datum_isteka = datum_isteka;
	}

	public int getKategorija() {
		return kategorija;
	}

	public void setKategorija(int kategorija) {
		this.kategorija = kategorija;
	}

	@Override
	public String toString() {
		return "Zdrastvena_knjizica \nBroj zdrastvene knjizice: " + broj_zdras_knjiz +
									"\nDatum isteka: " + datum_isteka +
									"\nKategorija: " + kategorija;
	}
	
	
	
	
	
	
}
