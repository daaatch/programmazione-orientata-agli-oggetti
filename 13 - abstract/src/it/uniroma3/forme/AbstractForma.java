package it.uniroma3.forme;

public abstract class AbstractForma {

	public abstract void trasla(int deltaX, int deltaY);
	
	public abstract boolean isDegenere();
	
	public abstract Punto getPuntoDegenere();
	
	public boolean equals(Object obj) {
		AbstractForma that = (AbstractForma)obj;
		if(this.isDegenere()&&that.isDegenere()&&(this.getPuntoDegenere().equals(that.getPuntoDegenere())))
			return true;
		return false;
	}

}
