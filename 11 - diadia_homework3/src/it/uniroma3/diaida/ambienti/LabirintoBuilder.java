package it.uniroma3.diaida.ambienti;

import java.util.HashMap;
import java.util.Map;

public class LabirintoBuilder {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Stanza ultimaAggiunta;
	private Map<String,Stanza> stanze;
	
	public LabirintoBuilder() {
		this.stanze = new HashMap<>();
	}
	
	private void setStanzaIniziale(Stanza iniziale) {
		this.stanzaIniziale = iniziale;
	}
	
	private void setStanzaVincente(Stanza vincente) {
		this.stanzaVincente = vincente;
	}
	
	private void setUltimaAggiunta(Stanza ultima) {
		this.ultimaAggiunta = ultima;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public Stanza getUltimaAggiunta() {
		return this.ultimaAggiunta;
	}
	
	public void addStanzaIniziale(String nome) {
		if(nome==null) return;
		if(this.stanze.containsKey(nome)) {
			this.setStanzaIniziale(stanze.get(nome));
			return;
		}
		Stanza iniziale = new Stanza(nome);
		this.stanze.put(nome,iniziale);
		this.setStanzaIniziale(iniziale);
		this.setUltimaAggiunta(iniziale);
	}
	
	public void addStanzaVincente(String nome) {
		if(nome==null) return;
		if(this.stanze.containsKey(nome)) {
			this.setStanzaVincente(stanze.get(nome));
			return;
		}
		Stanza vincente = new Stanza(nome);
		this.stanze.put(nome,vincente);
		this.setStanzaVincente(vincente);
		this.setUltimaAggiunta(vincente);
	}
	
	public void addStanza(String nome) {
		if(nome==null||stanze.containsKey(nome)) return;
		Stanza nuova = new Stanza(nome);
		this.stanze.put(nome,nuova);
		this.setUltimaAggiunta(nuova);
	}
	
	public void addStanzaBloccata(String nome,String attrezzo,String direzione) {
		if(nome==null||attrezzo==null||direzione==null||stanze.containsKey(nome)) return;
		StanzaBloccata nuova = new StanzaBloccata(nome,attrezzo,direzione);
		this.stanze.put(nome,nuova);
		this.setUltimaAggiunta(nuova);
	}
	
	public void addStanzaBuia(String nome,String attrezzo) {
		if(nome==null||attrezzo==null||stanze.containsKey(nome)) return;
		StanzaBuia nuova = new StanzaBuia(nome,attrezzo);
		this.stanze.put(nome,nuova);
		this.setUltimaAggiunta(nuova);
	}
	
	public void addStanzaMagica(String nome,int soglia) {
		if(nome==null||soglia<=0||stanze.containsKey(nome)) return;
		StanzaMagica nuova = new StanzaMagica(nome,soglia);
		this.stanze.put(nome,nuova);
		this.setUltimaAggiunta(nuova);
	}
	
	public void addStanzaMagica(String nome) {
		if(nome==null||stanze.containsKey(nome)) return;
		StanzaMagica nuova = new StanzaMagica(nome);
		this.stanze.put(nome,nuova);
		this.setUltimaAggiunta(nuova);
	}
	
	public void addPorta(String questa,String quella,String direzione) {
		if(questa==null||quella==null) return;
		if(!this.stanze.containsKey(quella))
			this.addStanza(quella);
		if(!this.stanze.containsKey(questa))
			this.addStanza(questa);	
		this.stanze.get(questa).collegaStanze(direzione,this.stanze.get(quella));
	}
	
	public void addCorridoio(String questa,String questaPorta,String quella,String quellaPorta) {
		if(questa==null||quella==null) return;
		if(!this.stanze.containsKey(quella))
			this.addStanza(quella);
		if(!this.stanze.containsKey(questa))
			this.addStanza(questa);	
		this.stanze.get(questa).impostaStanzaAdiacente(questaPorta,this.stanze.get(quella));
		this.stanze.get(quella).impostaStanzaAdiacente(quellaPorta,this.stanze.get(questa));
	}
	
	public void addAttrezzo(String nome,int peso) {
		if((nome!="")&&(peso>0))
			this.getUltimaAggiunta().addAttrezzo(nome,peso);
	}
	
	public Labirinto getLabirinto() {
		return new Labirinto(this.getStanzaIniziale(),this.getStanzaVincente());
	}
	
}
