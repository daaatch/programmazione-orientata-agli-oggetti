package it.uniroma3.diadia.ambienti;

import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String passepartout;
	private String portaChiusa;
	
	public StanzaBloccata(String nome, String attrezzo, String direzione) {
		super(nome);
		this.setPassepartout(attrezzo);
		this.setPortaChiusa(direzione);
	}
	
	public void setPassepartout(String attrezzo) {
		this.passepartout = attrezzo;
	}
	
	public void setPortaChiusa(String direzione) {
		this.portaChiusa = direzione;
	}
	
	public String getPassepartout() {
		return this.passepartout;
	}
	
	public String getPortaChiusa() {
		return this.portaChiusa;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.getPortaChiusa()==null) return super.getStanzaAdiacente(direzione);
		if(this.getPortaChiusa().equals(direzione))
			if(this.hasAttrezzo(passepartout)) return super.getStanzaAdiacente(direzione);
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
    	if((this.getPortaChiusa()==null)||this.hasAttrezzo(passepartout))
    		return super.toString();
    	risultato.append("(§) Posizione attuale: "+this.getNome());
    	risultato.append("\n(§) Uscite disponibili:");
    	if(this.direzioniToString().equals("")||this.direzioniToString().equals("["+portaChiusa+"]"))
    		risultato.append(" nessuna");
    	else for(Map.Entry<Direzione,Stanza> entry : this.getDirezioni().entrySet())
    			if(!entry.getKey().toString().equals(portaChiusa))
    				risultato.append("["+entry.getKey()+"]");
    	risultato.append("\n(§) Uscite bloccate:["+portaChiusa+"]");
    	risultato.append("\n(§) Attrezzi nella stanza:");
    	if(this.getNumeroAttrezzi()==0)
    		risultato.append(" nessuno");
    	else for(Map.Entry<String,Attrezzo> entry : this.getAttrezzi().entrySet())
        		risultato.append("["+entry.getValue().toString()+"]");
    	risultato.append("\n(§) Personaggi nella stanza:");
    	if(this.hasPersonaggio())
    		risultato.append("["+this.getPersonaggio().toString()+"]");
    	else risultato.append(" nessuno");
    	risultato.append("\n");
    	return risultato.toString();
    }
	
}
