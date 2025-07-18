package esercitazione.testing;

public class Persone {
	
	private String[] nomi;
	
	public Persone(int n) {
		this.nomi = new String[n];
	}
	
	public int contaOmonimi(String nome) {
		int count = 0;
		for(int i=0; i<nomi.length; i++) {
			if (nomi[i].equals(nome))
				count++;
		}
		return count;
	}
	
	public void inserisciNome(int i, String nome) {
		this.nomi[i] = nome;
	}
	
}
