package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.ConfigurazioniIniziali;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePesoAttrezzi;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = ConfigurazioniIniziali.getPesoMax();
	private HashMap<String,Attrezzo> attrezzi;;
	private int pesoAttuale;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoAttuale = 0;
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}
	
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	public int getPesoAttuale() {
		return this.pesoAttuale;
	}
		
	public boolean isEmpty() {
		return (this.attrezzi.isEmpty()&&(this.pesoAttuale==0));
	}
	
	public boolean entra(Attrezzo attrezzo) {
		if(this.pesoAttuale+attrezzo.getPeso()>this.getPesoMax())
			return false;
		else return true;
	}
		
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo!=null)
			return this.attrezzi.get(nomeAttrezzo);
		return null;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if(!entra(attrezzo))
			return false;
		this.attrezzi.put(attrezzo.getNome(),attrezzo);
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo))
			this.pesoAttuale -= this.getAttrezzo(nomeAttrezzo).getPeso();
		return this.attrezzi.remove(nomeAttrezzo);
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziPerPeso = new ArrayList<Attrezzo>(this.attrezzi.values());
		Collections.sort(attrezziPerPeso, new ComparatorePesoAttrezzi());
		return attrezziPerPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}
	
	public SortedSet<Attrezzo> getGruppettoPerPeso(int peso) {
		SortedSet<Attrezzo> gruppetto = new TreeSet<Attrezzo>(new ComparatorePesoAttrezzi());
		for(Attrezzo value : attrezzi.values())
			if(value.getPeso()==peso)
				gruppetto.add(value);
		return gruppetto;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> contenutoRaggruppato = new HashMap<Integer,Set<Attrezzo>>();
		for(Attrezzo value : attrezzi.values())
			if(!contenutoRaggruppato.containsKey(value.getPeso()))
				contenutoRaggruppato.put(value.getPeso(),this.getGruppettoPerPeso(value.getPeso()));
		return contenutoRaggruppato;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> ordinatiPerPeso =  new TreeSet<Attrezzo>(new ComparatorePesoAttrezzi());
		ordinatiPerPeso.addAll(this.attrezzi.values());
		return ordinatiPerPeso;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("(§) Attrezzi nella borsa:");
		if(!this.isEmpty()) {
			for(Map.Entry<String,Attrezzo> entry : attrezzi.entrySet())
				s.append("["+entry.getValue().toString()+"]");
		} else	s.append(" nessuno");
		s.append("\n(§) Stato della borsa:["+this.attrezzi.size()+" item, "+this.getPesoAttuale()+"/"+this.getPesoMax()+" kg]\n");
		return s.toString();
	}
	
}