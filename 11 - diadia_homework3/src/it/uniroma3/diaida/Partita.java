package it.uniroma3.diaida;

import it.uniroma3.diaida.ambienti.Labirinto;
import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.giocatore.Giocatore;

public class Partita {

	static final private int CFU_INIZIALI = 9;

	private Labirinto labirinto;
	public Giocatore giocatore;
	private boolean finita;
	
	public Partita() {
		
	}
	
	public Partita(Labirinto labirinto) {
		this.labirinto = labirinto;
		this.giocatore = new Giocatore(CFU_INIZIALI);
		this.finita = false;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}
	
	public boolean vinta() {
		return (this.getStanzaCorrente()==this.getStanzaVincente());
	}

	public boolean isFinita() {
		return (finita || vinta() || (this.giocatore.getCfu()==0));
	}

	public void setFinita() {
		this.finita = true;
	}

}