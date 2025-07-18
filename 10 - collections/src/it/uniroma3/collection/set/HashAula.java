package it.uniroma3.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashAula {

	private Set<HashStudente> studenti;
	
	public HashAula() {
		this.studenti = new HashSet<HashStudente>();
	}
	
	public boolean addStudente(HashStudente studente) {
		return this.studenti.add(studente);
	}
	
}