package it.uniroma3.diadia.attrezzi;

public class Attrezzo implements Comparable<Attrezzo> {

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String getNome() {
		return this.nome;
	}

	public int getPeso() {
		return this.peso;
	}
	
	@Override
	public boolean equals(Object o) {
		Attrezzo that = (Attrezzo)o;
		return ((this.getNome().equals(that.getNome()))&&(this.getPeso()==that.getPeso()));
	}

	@Override
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	@Override
	public int compareTo(Attrezzo attrezzo) {
		return this.getNome().compareTo(attrezzo.getNome());
	}

}