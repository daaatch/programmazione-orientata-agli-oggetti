package it.uniroma3.diadia.ambienti;

public enum Direzione {

	NORD, SUD, EST, OVEST;
	
	public Direzione getDirezioneOpposta(Direzione d) {
		if(d==NORD)
			return SUD;
		if(d==SUD)
			return NORD;
		if(d==OVEST)
			return EST;
		if(d==EST)
			return OVEST;
		return null;	
	}
	
}
