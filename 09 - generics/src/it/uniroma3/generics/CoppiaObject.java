package it.uniroma3.generics;

public class CoppiaObject {

	private Object primo;
	private Object secondo;
	
	public CoppiaObject() { }
	
	public CoppiaObject(Object primo, Object secondo) {
		this.primo = primo;
		this.secondo = secondo;
	}
	
	public Object getPrimo() {
		return this.primo;
	}
	
	public Object getSecondo() {
		return this.secondo;
	}
	
	public void setPrimo(Object primo) {
		this.primo = primo;
	}
	
	public void setSecondo(Object secondo) {
		this.secondo = secondo;
	}
	
}

class Persona {
	
	private String nome;
	
	public Persona() { }
	
	public Persona(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}

class Studente extends Persona {
	
	private String matricola;
	
	public Studente(String nome, String matricola) {
		super(nome);
		this.matricola = matricola;
	}
	
	public String getMatricola() {
		return this.matricola;
	}
	
}