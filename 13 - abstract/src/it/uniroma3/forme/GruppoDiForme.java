package it.uniroma3.forme;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GruppoDiForme extends AbstractForma {		//adesso un gruppo di forme può essere considerato una forma anch'esso
	
	public List<AbstractForma> componenti;
	
	public GruppoDiForme() {
		this.componenti = new LinkedList<AbstractForma>();
	}
	
	public List<AbstractForma> getComponenti() {
		return this.componenti;
	}
	
	public void aggiungiForma(AbstractForma forma) {
		this.componenti.add(forma);
	}
	
	public int getNumeroComponenti() {
		return componenti.size();
	}
	
	@Override
	public void trasla(int deltaX, int deltaY) {
		for(AbstractForma f : componenti)
			f.trasla(deltaX, deltaY);
	}
	
	@Override
	public boolean isDegenere() {		//se e solo se tutte le forme del gruppo sono degenerate nello stesso punto
		Set<Punto> puntiDegeneri = new HashSet<Punto>();
		for(AbstractForma forma : componenti) {
			puntiDegeneri.add(forma.getPuntoDegenere());
			if(!forma.isDegenere())
				return false;
		}
		return (puntiDegeneri.size()==1);
	}

	@Override
	public Punto getPuntoDegenere() {
		if(this.isDegenere()) return componenti.get(0).getPuntoDegenere();
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		GruppoDiForme that = (GruppoDiForme)obj;
		return this.componenti.equals(that.getComponenti());
	}

}