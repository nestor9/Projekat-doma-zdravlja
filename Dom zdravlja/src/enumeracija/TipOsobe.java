package enumeracija;

public enum TipOsobe {
	ZENSKI, // 1
	MUSKI;  // 2
	
	public static TipOsobe fromInt(int a) {
		switch (a) {
		case 1:
			return ZENSKI;
		default:
			return MUSKI;
		}
	}
	
	public static int toInt(TipOsobe tipOsobe) {
		switch (tipOsobe) {
		case ZENSKI:
			return 1;
		default:
			return 2;
		}
	}
}