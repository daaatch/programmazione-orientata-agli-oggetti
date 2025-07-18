package it.uniroma3.diaida.attrezzi;

import java.util.Comparator;

public class ComparatorePesoAttrezzi implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo one, Attrezzo two) {
		int comp = one.getPeso()-two.getPeso();
		if(comp==0)
			return one.getNome().compareTo(two.getNome());
		return comp;
	}

}