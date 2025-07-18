package it.uniroma3.diaida;

public class Partita {

	static final private int CFU_INIZIALI = 9;

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private int cfu;
	
	public Partita() {
		creaStanze();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
	}

    private void creaStanze() {

    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		atrio.collegaStanze("nord", biblioteca);
		atrio.collegaStanze("est", aulaN11);
		atrio.collegaStanze("sud", aulaN10);
		atrio.collegaStanze("ovest", laboratorio);
		aulaN11.collegaStanze("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("sud", aulaN10);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("sud", aulaN10);
		
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public boolean vinta() {
		return (this.getStanzaCorrente()==this.getStanzaVincente());
	}

	public boolean isFinita() {
		return (finita || vinta() || (this.cfu==0));
	}

	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public void scalaCfu() {
		this.cfu--;
	}
	
}
