package it.uniroma3.diaida;

public class Attrezzo {

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public String getNome() {
		return this.nome;
	}

	public int getPeso() {
		return this.peso;
	}

	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
}