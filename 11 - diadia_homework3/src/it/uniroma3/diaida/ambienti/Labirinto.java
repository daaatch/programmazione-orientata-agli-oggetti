package it.uniroma3.diaida.ambienti;

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Labirinto() { 
	
	}
	
	public Labirinto crea(String tipologia) {
		if(tipologia.equals("classico"))
			return this.creaClassico();
		if(tipologia.equals("monolocale"))
			return this.creaMonolocale();
		if(tipologia.equals("bilocale"))
			return this.creaBilocale();
		if(tipologia.equals("trilocale"))
			return this.creaTrilocale();
		if(tipologia.equals("test giocatore"))
			return this.creaTestGiocatore();
		return null;
	}
	
	public Labirinto(Stanza stanzaIniziale,Stanza stanzaVincente) {
		this.setStanzaCorrente(stanzaIniziale);
		this.setStanzaVincente(stanzaVincente);
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
	
	private Labirinto creaClassico() {
		LabirintoBuilder classico = new LabirintoBuilder();
		classico.addStanzaVincente("Biblioteca");
		classico.addStanzaIniziale("Atrio");
		classico.addAttrezzo("osso",1);
		classico.addStanza("Aula N10");
		classico.addAttrezzo("lanterna",3);
		classico.addPorta("Atrio","Biblioteca","nord");
		classico.addPorta("Atrio","Aula N10","sud");
		classico.addPorta("Atrio","Laboratorio Campus","ovest");
		classico.addPorta("Atrio","Aula N11","est");
		classico.addPorta("Aula N11","Laboratorio Campus","est");
		classico.addCorridoio("Aula N10","est","Aula N11","sud");
		classico.addCorridoio("Aula N10","ovest","Laboratorio Campus","sud");
		return classico.getLabirinto();
	}
	
	private Labirinto creaMonolocale() {
		LabirintoBuilder monolocale = new LabirintoBuilder();
		monolocale.addStanzaIniziale("Salone");
		monolocale.addPorta("Salone","Salone","nord");
		monolocale.addPorta("Salone","Salone","est");
		monolocale.addAttrezzo("Libro",1);
		monolocale.addAttrezzo("Libreria",20);
		return monolocale.getLabirinto();
	}
	
	private Labirinto creaBilocale() {
		LabirintoBuilder bilocale = new LabirintoBuilder();
		bilocale.addStanzaIniziale("Salone");
		bilocale.addStanzaVincente("Cucina");
		bilocale.addAttrezzo("Coltello",1);
		bilocale.addPorta("Salone","Cucina","sud");
		bilocale.addPorta("Salone",null,"ovest");
		return bilocale.getLabirinto();
	}
	
	private Labirinto creaTrilocale() {
		LabirintoBuilder trilocale = new LabirintoBuilder();
		trilocale.addStanzaIniziale("Salone");
		trilocale.addStanzaVincente("Cucina");
		trilocale.addStanza("Camera");
		trilocale.addAttrezzo("Computer",3);
		trilocale.addPorta("Salone","Cucina","nord");
		trilocale.addPorta("Salone","Camera","est");
		trilocale.addCorridoio("Camera","nord","Cucina","est");
		return trilocale.getLabirinto();
	}
	
	private Labirinto creaTestGiocatore() {
		LabirintoBuilder testGiocatore = new LabirintoBuilder();
		testGiocatore.addStanzaIniziale("Corridoio");
		testGiocatore.addAttrezzo("Giacca",3);
		testGiocatore.addAttrezzo("Bottiglia",2);
		testGiocatore.addAttrezzo("Quaderno",1);
		return testGiocatore.getLabirinto();
	}

}