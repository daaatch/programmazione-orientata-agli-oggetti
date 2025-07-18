package it.uniroma3.diaida.ambienti;

import it.uniroma3.diaida.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		this.creaStanze();
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		if(stanzaCorrente!=null)
			this.stanzaCorrente = stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		if(stanzaVincente!=null);
			this.stanzaVincente = stanzaVincente;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	private void creaStanze() {
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Stanza atrio = new Stanza("Atrio");
		Stanza n11 = new Stanza("Aula N11");
		Stanza n10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		atrio.collegaStanze("nord", biblioteca);
		atrio.collegaStanze("est", n11);
		atrio.collegaStanze("sud", n10);
		atrio.collegaStanze("ovest", laboratorio);
		n11.collegaStanze("est", laboratorio);
		n11.impostaStanzaAdiacente("sud", n10);
		n10.impostaStanzaAdiacente("est", n11);
		n10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("sud", n10);
		n10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
    }

}