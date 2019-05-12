package osobe;

public class Pol
{
	private boolean muski;

	public Pol()
	{
		this.muski = false;
	}
	
	public Pol(boolean muski) 
	{
		this.muski = muski;
	}

	public boolean isMuski() {
		return muski;
	}

	public void setMuski(boolean muski) {
		this.muski = muski;
	}

	@Override
	public String toString() {
		return "POL \nPol: " + muski;
	}
	
	
	
	
}


