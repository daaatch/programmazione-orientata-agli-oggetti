package it.uniroma3.verifica;

public class Sommatore {
	
	private int a;
	private int b;

	public Sommatore(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int somma() {
		return a + b;
	}
	
	public int sommaStrana() {
		int a = 0;
		int b = 0;
		return a + b;
	}
	
	public int somma(int a, int b) {
		return a + b;
	}	
	
	public int sommaStrana(int a, int b) {
		return this.a + b;
	}
	
	public int sommaStranissima(int a, int b) {
		return this.a + this.b;
	}

	public static void main(String[] argc) {
		Sommatore s = new Sommatore(40, 30);
		System.out.println(s.somma());
		System.out.println(s.sommaStrana());
		System.out.println(s.somma(3,2));
		System.out.println(s.sommaStrana(3,2));
		System.out.println(s.sommaStranissima(3,2));		
	}	
	
}