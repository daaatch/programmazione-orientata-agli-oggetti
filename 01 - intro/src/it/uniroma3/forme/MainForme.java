package it.uniroma3.forme;

public class MainForme {

	public static void main(String[] args) {
		
		Punto origine = new Punto();
		
		System.out.print("origine: ");
		origine.stampa();
		
		Punto duezero = new Punto(2,0);
		
		System.out.print("duezero: ");
		duezero.stampa();
		
		duezero.trasla(1, 2);
		
		System.out.print("duezero(traslato): ");
		duezero.stampa();
		
		Rettangolo rect = new Rettangolo();
		rect.stampa();
		
		rect = new Rettangolo(2,3,origine);
		rect.stampa();
		
		rect = new Rettangolo(2,3,1,1);
		rect.stampa();
		
		rect.trasla(4,5);
		System.out.print("vertice(traslato): ");
		rect.getVertice().stampa();
		
		System.out.print("origine: ");
		origine.stampa();
		
		rect.setVertice(6,1);
		System.out.print("vertice(nuovo): ");
		rect.getVertice().stampa();
		
		rect.trasla(4,5);
		System.out.print("vertice(nuovo,traslato): ");
		rect.getVertice().stampa();
	}
	
}