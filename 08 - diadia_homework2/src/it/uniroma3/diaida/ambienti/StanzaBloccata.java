package it.uniroma3.diaida.ambienti;

import it.uniroma3.diaida.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String passepartout;
	private String porta_chiusa;
	
	public StanzaBloccata(String nome, String attrezzo, String direzione) {
		super(nome);
		this.setPassepartout(attrezzo);
		this.setPortaChiusa(direzione);
	}
	
	public void setPassepartout(String attrezzo) {
		this.passepartout = attrezzo;
	}
	
	public void setPortaChiusa(String direzione) {
		this.porta_chiusa = direzione;
	}
	
	public String getPassepartout() {
		return this.passepartout;
	}
	
	public String getPortaChiusa() {
		return this.porta_chiusa;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.getPortaChiusa()==null) return super.getStanzaAdiacente(direzione);
		if(this.getPortaChiusa().equals(direzione))
			if(this.hasAttrezzo(this.getPassepartout())) return super.getStanzaAdiacente(direzione);
			else return this;
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(this.getPortaChiusa()==null) return super.toString();
		else return this.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
    	risultato.append("(§) Posizione attuale:"+super.getNome());
    	risultato.append("\n(§) Uscite disponibili:");
    	for(String direzione : super.getDirezioni())
    		if((direzione!=null)&&(direzione!=this.getPortaChiusa()))
    			risultato.append("["+direzione+"]");
    	risultato.append("\n(§) Uscite bloccate:["+this.getPortaChiusa()+"]");
    	risultato.append("\n(§) Attrezzi nella stanza:");
    	if(super.getNumeroAttrezzi()==0)
    		risultato.append(" nessuno");
    	else {
    		for(Attrezzo attrezzo : super.getAttrezzi()) {
    			if(attrezzo!=null)
    				risultato.append("["+attrezzo.toString()+"]");
    		}
    	}
    	risultato.append("\n");
    	return risultato.toString();
	}
	
}
