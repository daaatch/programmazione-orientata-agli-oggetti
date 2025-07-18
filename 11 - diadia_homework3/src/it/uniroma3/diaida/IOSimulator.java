package it.uniroma3.diaida;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IOSimulator implements IO {

	private List<String> righeDaLeggere;
	private List<String> messaggiRicevuti;
	private Iterator<String> indiceRiga;
	private Iterator<String> indiceMessaggio;
	
	public IOSimulator() {
		this.righeDaLeggere = new ArrayList<String>();
		this.messaggiRicevuti = new ArrayList<String>();
	}
	
	public void setInput(List<String> input) {
		this.righeDaLeggere = input;
		this.indiceRiga = this.righeDaLeggere.iterator();
	}
	
	public String getOutput() {
		this.indiceMessaggio = this.messaggiRicevuti.iterator();
		return this.toString();
	}
	
	public boolean hasNext() {
		return this.indiceRiga.hasNext();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiRicevuti.add(messaggio);
	}

	@Override
	public String leggiRiga() {
			return this.indiceRiga.next();
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		while(indiceMessaggio.hasNext())
			risultato.append(indiceMessaggio.next());
		return risultato.toString();
	}

}