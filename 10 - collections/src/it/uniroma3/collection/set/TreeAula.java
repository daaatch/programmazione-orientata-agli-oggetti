package it.uniroma3.collection.set;

import java.util.TreeSet;
import java.util.Set;

public class TreeAula {

	private Set<TreeStudente> studenti;
	
	public TreeAula() {
		this.studenti = new TreeSet<>(new ComparatoreStudenti());
	}
	
	public boolean addStudente(TreeStudente studente) {
		return this.studenti.add(studente);
	}
	
}