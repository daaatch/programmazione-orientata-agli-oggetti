package it.uniroma3.collection.set;

import java.util.Comparator;

public class ComparatoreStudenti implements Comparator<TreeStudente> {

	@Override
	public int compare(TreeStudente s1, TreeStudente s2) {
		return s1.getNome().compareTo(s2.getNome());
	}
	
}