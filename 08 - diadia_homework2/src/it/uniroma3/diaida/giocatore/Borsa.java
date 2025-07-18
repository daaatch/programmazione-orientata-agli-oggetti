package it.uniroma3.diaida.giocatore;

import it.uniroma3.diaida.attrezzi.Attrezzo;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[5];
		this.numeroAttrezzi = 0;
	}
	
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	public int getPeso() {
		int peso = 0;
		for(int i=0; i<this.attrezzi.length; i++) {
			if(attrezzi[i]!=null)
				peso = peso + this.attrezzi[i].getPeso();
		}
		return peso;
	}
		
	public boolean isEmpty() {
		return ((this.numeroAttrezzi==0)&&(this.getPeso()==0));
	}
	
	public boolean entra(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso()>this.getPesoMax())
			return false;
		else return true;
	}
		
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i=0; i<this.attrezzi.length; i++) {
			if((this.attrezzi[i]!=null)&&(this.attrezzi[i].getNome().equals(nomeAttrezzo)))
				a = attrezzi[i];
		}
		return a;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if(!entra(attrezzo))
			return false;
		if(this.numeroAttrezzi==5)
			return false;
		for(int i=0; i<this.attrezzi.length; i++) {
			if(this.attrezzi[i]==null) {
				this.attrezzi[i] = attrezzo;
				this.numeroAttrezzi++;	
				return true;
			}
		}
		return false;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo!=null)
			return (this.getAttrezzo(nomeAttrezzo)!=null);
		else return false;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo tieni = null;
		if((nomeAttrezzo!=null)&&(this.hasAttrezzo(nomeAttrezzo))) {
			for(int i=0; i<this.attrezzi.length; i++) {
				if((attrezzi[i]!=null)&&(this.attrezzi[i].getNome().equals(nomeAttrezzo))) {
					tieni = this.attrezzi[i];
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
				}
			}
		}
		return tieni;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("(§) Attrezzi nella borsa:");
		if(!this.isEmpty()) {
			for(Attrezzo attrezzo : this.attrezzi)
				if(attrezzo!=null)
					s.append("["+attrezzo.toString()+"]");
		} else	s.append("nessuno");
		s.append("\n(§) Stato della borsa:["+this.numeroAttrezzi+"/"+this.attrezzi.length+" item]["+this.getPeso()+"/"+this.getPesoMax()+" kg]\n");
		return s.toString();
	}
	
}