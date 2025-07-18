package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {

	private String nome;
	private String presentazione;
	private boolean salutato;
	
	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.salutato = false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getPresentazione() {
		return this.presentazione;
	}
	
	public boolean isSalutato() {
		return this.salutato;
	}
	
	public String saluta() {
		StringBuilder risposta = new StringBuilder();
		risposta.append("(¶) Ciao, io sono "+this.getNome()+"\n");
		if(!this.isSalutato()) 
			risposta.append(this.getPresentazione());
		else risposta.append("(¶) Aspetta... già ci conosciamo!\n");
		this.salutato = true;
		return risposta.toString();
	}
	
	public abstract String agisci(Partita partita);
	
	public abstract String riceviRegalo(Partita partita, Attrezzo attrezzo);
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
