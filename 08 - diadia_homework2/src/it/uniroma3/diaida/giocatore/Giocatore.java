package it.uniroma3.diaida.giocatore;

import it.uniroma3.diaida.attrezzi.Attrezzo;

public class Giocatore {

	private int cfu;
	private Borsa borsa;
	
	public Giocatore(int cfu) {
		this.cfu = cfu;
		this.borsa = new Borsa(5);
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void scalaCfu() {
		this.cfu--;
	}
	
	public boolean isVivo() {
		return (this.getCfu()>0);
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public boolean prendi(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	public Attrezzo posa(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo); 
	}

}