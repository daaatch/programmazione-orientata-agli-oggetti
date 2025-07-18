package it.uniroma3.diaida;

public class IOSimulator implements IO {

	private String[] righeDaLeggere;
	private String[] messaggiRicevuti;
	private int indiceRiga;
	private int indiceMessaggio;
	private int indiceLettura;
	
	public IOSimulator() {
		this.righeDaLeggere = new String[10];;
		this.messaggiRicevuti = new String[10];
		this.indiceRiga = 0;
		this.indiceMessaggio = 0;
		this.indiceLettura = 0;
	}
	
	public void setInput(String... input) {
		this.righeDaLeggere = input;
	}
	
	public String getOutput() {
		return this.toString();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiRicevuti[this.indiceMessaggio] = messaggio;
		this.indiceMessaggio++;
	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere[this.indiceRiga];
		this.indiceRiga++;
		return rigaLetta;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiRicevuti[this.indiceLettura];
		this.indiceLettura++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceLettura<this.indiceMessaggio;
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		for(int i=0;i<this.messaggiRicevuti.length;i++)
			if(this.messaggiRicevuti[i]!=null)
					risultato.append(this.messaggiRicevuti[i]);
		return risultato.toString();
	}

}