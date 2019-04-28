package osobe;

public class Zdrastvena_knjizica 
{
	String broj_zdras_knjiz;
	String datum_isteka;
	int kategorija;
	String podaci;
	
	public Zdrastvena_knjizica(String broj_zdras_knjiz, String datum_isteka, int kategorija, String podaci) 
	{
		this.broj_zdras_knjiz = broj_zdras_knjiz;
		this.datum_isteka = datum_isteka;
		this.kategorija = kategorija;
		this.podaci = podaci;
	}
	
	public Zdrastvena_knjizica()
	{
		this.broj_zdras_knjiz = "";
		this.datum_isteka = "";
		this.kategorija = 0;
		this.podaci = "";
		
	}
	
	//podaci = broj_zdras_knjiz + datum_isteka + kategorija;
	
	
	
}
