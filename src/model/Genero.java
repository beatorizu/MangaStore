package model;

public enum Genero {
	
	KODOMO, SHOUNEN, SHOUJOU, SEINEN, JOSEI, MECHA, SCI_FI, SLICE_OF_LIFE;

	public String toString() {
		switch(this) {
			case KODOMO: return "Kodomo";
			case SHOUNEN: return "Shounen";
			case SHOUJOU: return "Shoujou";
			case SEINEN: return "Seinen";
			case JOSEI: return "Josei";
			case MECHA: return "Mecha";
			case SCI_FI: return "Sci-fi";
			case SLICE_OF_LIFE: return "Slice of Life";
			default: return "Unspecified";
		}
	}
	
}
