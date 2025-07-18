package it.uniroma3.forme;

public class Rettangolo {

	private int base;
	private int altezza;
	private Punto vertice;
	
	public Rettangolo(int b, int h, int x, int y) {
		this.setBase(b);
		this.setAltezza(h);
		this.setVertice(x,y);
	}
	
	public Rettangolo(int b, int h, Punto v) {
		this(b,h,v.getX(),v.getY());
	}
	
	public Rettangolo(int b, int h) {
		this(b,h,new Punto(0,0));
	}
	
	public Rettangolo() {
		this(0,0,new Punto(0,0));
	}
	
	public void setBase(int base) {
		this.base = base;
	}
	
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	
	public void setVertice(Punto vertice) {
		this.setVertice(vertice.getX(),vertice.getY());
	}
	
	public void setVertice(int x, int y) {
		this.vertice = new Punto(x,y);
	}

	public int getBase() {
		return base;
	}
	
	public int getAltezza() {
		return altezza;
	}
	
	public Punto getVertice() {
		return vertice;
	}
	
	public int getArea() {
		return base*altezza;
	}
	
	public void trasla(int deltaX, int deltaY) {
		this.vertice.trasla(deltaX, deltaY);
	}
	
	public void scala(int fattore) {
		this.base = this.getBase()*fattore;
		this.altezza = this.getAltezza()*fattore;
	}
	
	public void scala(int fattoreBase, int fattoreAltezza) {
		this.base = this.getBase()*fattoreBase;
		this.altezza = this.getAltezza()*fattoreAltezza;
	}
	
	public void stampa() {
		System.out.print("vertice: ");
		getVertice().stampa();
		System.out.println("base: "+getBase());
		System.out.println("altezza: "+getAltezza());
		System.out.println("area: "+getArea());
	}
	
}
