package it.uniroma3.collection.set;

public class HashStudente {

	private String nome;
	
	public HashStudente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		HashStudente that = (HashStudente)o;
		return this.getNome().equals(that.getNome());
	}
	
}