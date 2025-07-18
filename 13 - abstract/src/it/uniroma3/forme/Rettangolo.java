package it.uniroma3.forme;

public class Rettangolo extends AbstractForma {
	
	private int altezza, base;
	private Punto vertice;
	
	public Rettangolo(Punto vertice, int altezza, int base) {
		this.altezza = altezza;
		this.base = base;
		this.vertice = new Punto(vertice.getX(), vertice.getY());
	}
	
	public void trasla(int deltaX, int deltaY) {
		this.vertice.setX(this.vertice.getX() + deltaX);
		this.vertice.setY(this.vertice.getY() + deltaY);
	}
	
	public Punto getVertice() { 
		return this.vertice; 
	}
	
	public int getBase() { 
		return this.base; 
	}
	
	public int getAltezza() { 
		return this.altezza; 
	}

	@Override
	public String toString() {
		return "Vertice: "+this.getVertice().toString()+"\nBase: "+this.getBase()+"\nAltezza: "+this.getAltezza();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj))
			return true;
		if(!this.getClass().equals(obj.getClass()))
			return false;
		Rettangolo that = (Rettangolo)obj;
		return (this.getVertice().equals(that.getVertice()))&&(this.getBase()==that.getBase())&&(this.getAltezza()==that.getAltezza());
	}

	@Override
	public boolean isDegenere() {
		return ((this.base==0)&&(this.altezza==0));
	}

	@Override
	public Punto getPuntoDegenere() {
		if(this.isDegenere()) return this.vertice;
		return null;
	}
	
}