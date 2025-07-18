package it.uniroma3.forme;

public class Cerchio extends AbstractForma {
	
	private int raggio;
	private Punto centro;
	
	public Cerchio(Punto centro, int raggio) {
		this.raggio = raggio;
		this.centro = new Punto(centro.getX(), centro.getY());
	}
	
	public void trasla(int deltaX, int deltaY) {
		this.centro.trasla(deltaX,deltaY);
	}
	
	public Punto getCentro() { 
		return this.centro; 
	}
	
	public int getRaggio() { 
		return this.raggio; 
	}

	@Override
	public String toString() {
		return "Centro: "+this.getCentro().toString()+"\nRaggio: "+this.getRaggio();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj))
			return true;
		if(!this.getClass().equals(obj.getClass()))
			return false;
		Cerchio that = (Cerchio)obj;
		return (this.getRaggio()==that.getRaggio())&&(this.getCentro()==that.getCentro());
	}

	@Override
	public boolean isDegenere() {
		return (this.raggio==0);
	}

	@Override
	public Punto getPuntoDegenere() {
		if(this.isDegenere()) return this.centro;
		return null;
	}
	
}