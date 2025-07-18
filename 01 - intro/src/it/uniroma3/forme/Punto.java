package it.uniroma3.forme;

public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Punto() {
		this(0,0);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setXY(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void trasla(int deltaX, int deltaY) {
		this.setX(x + deltaX);
		this.setY(y + deltaY);
	}
	
	public void stampa() {
		System.out.print("(");
		System.out.print(getX());
		System.out.print(",");
		System.out.print(getY());
		System.out.println(")");
	}
	
 }