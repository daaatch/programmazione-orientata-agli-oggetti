package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Labirinto() { 
	
	}
	
	public Labirinto(String nomeFile) {
		try {
			CaricatoreLabirinto caricatore = new CaricatoreLabirinto(nomeFile);
			caricatore.carica();
			this.setStanzaCorrente(caricatore.getStanzaIniziale());
			this.setStanzaVincente(caricatore.getStanzaVincente());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
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
		classico.addPersonaggio(new Cane());
		classico.addAttrezzo("lanterna",3);
		classico.addPorta("Atrio","Biblioteca","nord");
		classico.addPorta("Atrio","Aula N10","sud");
		classico.addPorta("Atrio","Laboratorio Campus","ovest");
		classico.addPorta("Atrio","Aula N11","est");
		classico.addPorta("Aula N11","Laboratorio Campus","est");
		classico.addCorridoio("Aula N10","est","Aula N11","sud");
		classico.addCorridoio("Aula N10","ovest","Laboratorio Campus","sud");
		classico.addPersonaggio(new Strega(),"Laboratorio Campus");
		classico.addPersonaggio(new Mago(new Attrezzo("libro",3)),"Aula N11");
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

	static class LabirintoBuilder {
	
		private Stanza stanzaIniziale;
		private Stanza stanzaVincente;
		private Stanza ultimaAggiunta;
		private Map<String,Stanza> stanze;
		
		public LabirintoBuilder() {
			this.stanze = new HashMap<>();
		}
		
		private void setStanzaIniziale(Stanza iniziale) {
			this.stanzaIniziale = iniziale;
		}
		
		private void setStanzaVincente(Stanza vincente) {
			this.stanzaVincente = vincente;
		}
		
		private void setUltimaAggiunta(Stanza ultima) {
			this.ultimaAggiunta = ultima;
		}
		
		public Stanza getStanzaIniziale() {
			return this.stanzaIniziale;
		}
		
		public Stanza getStanzaVincente() {
			return this.stanzaVincente;
		}
		
		public Stanza getUltimaAggiunta() {
			return this.ultimaAggiunta;
		}
		
		public void addStanzaIniziale(String nome) {
			if(nome==null) return;
			if(this.stanze.containsKey(nome)) {
				this.setStanzaIniziale(stanze.get(nome));
				return;
			}
			Stanza iniziale = new Stanza(nome);
			this.stanze.put(nome,iniziale);
			this.setStanzaIniziale(iniziale);
			this.setUltimaAggiunta(iniziale);
		}
		
		public void addStanzaVincente(String nome) {
			if(nome==null) return;
			if(this.stanze.containsKey(nome)) {
				this.setStanzaVincente(stanze.get(nome));
				return;
			}
			Stanza vincente = new Stanza(nome);
			this.stanze.put(nome,vincente);
			this.setStanzaVincente(vincente);
			this.setUltimaAggiunta(vincente);
		}
		
		public void addStanza(String nome) {
			if(nome==null||stanze.containsKey(nome)) return;
			Stanza nuova = new Stanza(nome);
			this.stanze.put(nome,nuova);
			this.setUltimaAggiunta(nuova);
		}
		
		public void addStanzaBloccata(String nome,String attrezzo,String direzione) {
			if(nome==null||attrezzo==null||direzione==null||stanze.containsKey(nome)) return;
			StanzaBloccata nuova = new StanzaBloccata(nome,attrezzo,direzione);
			this.stanze.put(nome,nuova);
			this.setUltimaAggiunta(nuova);
		}
		
		public void addStanzaBuia(String nome,String attrezzo) {
			if(nome==null||attrezzo==null||stanze.containsKey(nome)) return;
			StanzaBuia nuova = new StanzaBuia(nome,attrezzo);
			this.stanze.put(nome,nuova);
			this.setUltimaAggiunta(nuova);
		}
		
		public void addStanzaMagica(String nome,int soglia) {
			if(nome==null||soglia<=0||stanze.containsKey(nome)) return;
			StanzaMagica nuova = new StanzaMagica(nome,soglia);
			this.stanze.put(nome,nuova);
			this.setUltimaAggiunta(nuova);
		}
		
		public void addStanzaMagica(String nome) {
			if(nome==null||stanze.containsKey(nome)) return;
			StanzaMagica nuova = new StanzaMagica(nome);
			this.stanze.put(nome,nuova);
			this.setUltimaAggiunta(nuova);
		}
		
		public void addPorta(String questa,String quella,String direzione) {
			if(questa==null||quella==null) return;
			if(!this.stanze.containsKey(quella))
				this.addStanza(quella);
			if(!this.stanze.containsKey(questa))
				this.addStanza(questa);	
			this.stanze.get(questa).collegaStanze(direzione,this.stanze.get(quella));
		}
		
		public void addCorridoio(String questa,String questaPorta,String quella,String quellaPorta) {
			if(questa==null||quella==null) return;
			if(!this.stanze.containsKey(quella))
				this.addStanza(quella);
			if(!this.stanze.containsKey(questa))
				this.addStanza(questa);	
			this.stanze.get(questa).impostaStanzaAdiacente(questaPorta,this.stanze.get(quella));
			this.stanze.get(quella).impostaStanzaAdiacente(quellaPorta,this.stanze.get(questa));
		}
		
		public void addAttrezzo(String nome,int peso) {
			if((nome!="")&&(peso>0))
				this.getUltimaAggiunta().addAttrezzo(nome,peso);
		}
		
		public void addAttrezzo(String stanza, String nome, int peso) {
			if((nome!="")&&(peso>0))
				this.stanze.get(stanza).addAttrezzo(nome,peso);
		}
		
		public void addPersonaggio(AbstractPersonaggio personaggio) {
			this.getUltimaAggiunta().setPersonaggio(personaggio);
		}
		
		public void addPersonaggio(AbstractPersonaggio personaggio, String stanza) {
			if(this.stanze.containsKey(stanza))
				this.stanze.get(stanza).setPersonaggio(personaggio);
		}
		
		public Labirinto getLabirinto() {
			return new Labirinto(this.getStanzaIniziale(),this.getStanzaVincente());
		}
		
	}

}
