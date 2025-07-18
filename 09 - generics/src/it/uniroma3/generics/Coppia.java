package it.uniroma3.generics;

public class Coppia<T> {

//	<T> sta a indicare che in questa classe il Type è un parametro formale
	private T primo;
	private T secondo;
	
	public Coppia() { }
	
	public Coppia(T primo, T secondo) {
		this.primo = primo;
		this.secondo = secondo;
	}
	
	public T getPrimo() {
		return this.primo;
	}
	
	public T getSecondo() {
		return this.secondo;
	}
	
	public void setPrimo(T primo) {
		this.primo = primo;
	}
	
	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}
	
//	funzione che mi copia il contenuto di una coppia in un altra coppia
//	utile per il fatto che a tempo statico non so che tipo aspettarmi 
//	in quanto devo istanziare T sulla base del tipo della coppia parametro		
	public void copyAll(Coppia<? extends T> coppia) {
		this.setPrimo(coppia.getPrimo());
		this.setSecondo(coppia.getSecondo());
	}
	
}
