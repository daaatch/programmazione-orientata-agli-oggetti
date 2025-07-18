package it.uniroma3.diadia.ambienti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class CaricatoreLabirinto {
	private final String  STANZE   = "Stanze:";
	private final String  ATTREZZI = "Attrezzi:";
	private final String  USCITE   = "Uscite:";
	private final String  ESTREMI = "Estremi:";
	private final String  MAGICHE = "Magiche:";
	private final String  BUIE = "Buie:";
//	private final String  PERSONAGGI = "Personaggi:";
	private BufferedReader reader;
	private Set<String> nomiStanze;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private int numeroLinea;
	private LabirintoBuilder builder;
	
	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this(new FileReader(nomeFile));
//		this.nome2stanza = new HashMap<String,Stanza>();
//		this.numeroLinea = 0;
//		try {
//			this.reader = new BufferedReader(new FileReader(nomeFile));
//		} catch (FileNotFoundException e) {
//			System.err.println("File " + nomeFile + " non trovato");
//			e.printStackTrace();
//		}
	}
	
	public CaricatoreLabirinto(Reader reader) {
		this.nomiStanze = new HashSet<String>();
		this.numeroLinea = 0;
		this.reader = new BufferedReader(reader);
		this.builder = new LabirintoBuilder();
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	private boolean stanzaValida(String nomeStanza) {
		return this.nomiStanze.contains(nomeStanza);
	}
	
	public Labirinto getLabirinto() {
		return this.builder.getLabirinto();
	}

	public void carica() {
		try {
			this.leggiStanze();
			this.leggiStanzeMagiche();
			this.leggiStanzeBuie();
			this.leggiInizialeEvincente();
			this.leggiAttrezzi();
//			this.leggiPersonaggi();
			this.leggiUscite();
		} catch (FormatoFileNonValidoException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String leggiRiga(BufferedReader reader) throws FormatoFileNonValidoException {
		try {
			this.numeroLinea++;
			String riga = reader.readLine();
//			System.err.println("Letta riga "+ this.numeroLinea + ": "+ riga);
			return riga;
		} catch (IOException e) {
				throw new FormatoFileNonValidoException("Problemi lettura file [" + this.numeroLinea + "]");
		}
	}
	
	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
			nomeStanzaIniziale = this.leggiRiga(reader);
			this.nomiStanze.add(nomeStanzaIniziale);
			this.builder.addStanzaIniziale(nomeStanzaIniziale);
			String nomeStanzaVincente = this.leggiRiga(reader);
			this.nomiStanze.add(nomeStanzaVincente);
			this.builder.addStanzaVincente(nomeStanzaVincente);
			String token = this.leggiRiga(reader);
			if(!token.equals(ATTREZZI))
				throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]:" +ATTREZZI +" non trovato");		
	}

	private void leggiStanze() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		nomeStanza = this.leggiRiga(reader);
		if(!nomeStanza.equals(STANZE))
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]"+": "+STANZE +" non trovato");
		nomeStanza = this.leggiRiga(reader);
		while(!nomeStanza.equals(MAGICHE)) {
//			if(nomeStanza==null)
//				throw new FormatoFileNonValidoException("Termine inaspettata del file [" + this.numeroLinea + "].");
			this.builder.addStanza(nomeStanza);
			this.nomiStanze.add(nomeStanza);
			nomeStanza = this.leggiRiga(reader);
		}
	}
	
	private void leggiStanzeMagiche() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		nomeStanza = this.leggiRiga(reader);
//		if(!nomeStanza.equals(MAGICHE))
//			throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]"+": "+MAGICHE +" non trovato");
//		nomeStanza = this.leggiRiga(reader);
		while(!nomeStanza.equals(BUIE)) {
			this.builder.addStanzaMagica(nomeStanza);
			this.nomiStanze.add(nomeStanza);
			nomeStanza = this.leggiRiga(reader);
		}
	}
	
	private void leggiStanzeBuie() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		nomeStanza = this.leggiRiga(reader);
//		if(!nomeStanza.equals(BUIE))
//			throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]"+": "+BUIE +" non trovato");
//		nomeStanza = this.leggiRiga(reader);
		while(!nomeStanza.equals(ESTREMI)) {
			this.builder.addStanzaBuia(nomeStanza, "lanterna");
			this.nomiStanze.add(nomeStanza);
			nomeStanza = this.leggiRiga(reader);
		}
	}

	@SuppressWarnings("resource")
	private void leggiAttrezzi() throws FormatoFileNonValidoException {
		String nomeAttrezzo = null;
		String pesoAttrezzo = null;
		String nomeStanza = null; 
		String definizioneAttrezzo = this.leggiRiga(reader);
		while(!definizioneAttrezzo.equals(USCITE)) {
			int peso;
			Scanner scannerLinea = new Scanner(definizioneAttrezzo);
			nomeAttrezzo = scannerLinea.next();
			if(nomeAttrezzo==null)
				throw new FormatoFileNonValidoException("Termine inaspettata del file [" + this.numeroLinea + "].");
			pesoAttrezzo = scannerLinea.next();
			try {
				peso = Integer.parseInt(pesoAttrezzo);
			}
			catch (NumberFormatException e) {
				throw new FormatoFileNonValidoException("Peso attrezzo "+nomeAttrezzo+" non valido [" + this.numeroLinea + "].");
			}
			nomeStanza = scannerLinea.next();
			if(!stanzaValida(nomeStanza))
				throw new FormatoFileNonValidoException("Definizione attrezzo "+ nomeAttrezzo+" errata [" + this.numeroLinea + "]" +": stanza" +nomeStanza+" inesistente");
			this.builder.addAttrezzo(nomeStanza, nomeAttrezzo, peso);
			definizioneAttrezzo = this.leggiRiga(reader);
		}
	}

	private void impostaUscita(String nomeUscita, String nomeStanzaPartenza, String nomeStanzaDestinazione) {
		this.builder.addPorta(nomeStanzaPartenza, nomeStanzaDestinazione, nomeUscita);
	}

	@SuppressWarnings("resource")
	private void leggiUscite() throws FormatoFileNonValidoException {
		String nomeStanzaPartenza = null;
		String nomeUscita = null;
		String nomeStanzaDestinazione = null;
		String datiUscita = this.leggiRiga(reader);
		while(datiUscita!=null) {
			Scanner scannerDiLinea = new Scanner(datiUscita);			
			while(scannerDiLinea.hasNext()) {
				nomeStanzaPartenza = scannerDiLinea.next();
				nomeUscita = scannerDiLinea.next();
				nomeStanzaDestinazione = scannerDiLinea.next();
				if(!stanzaValida(nomeStanzaPartenza))
					throw new FormatoFileNonValidoException("Definizione errata uscita [" + this.numeroLinea + "]" + nomeUscita);
				if(!stanzaValida(nomeStanzaDestinazione))
					throw new FormatoFileNonValidoException("Definizione errata uscita [" + this.numeroLinea + "]" + nomeUscita);
				impostaUscita(nomeUscita, nomeStanzaPartenza, nomeStanzaDestinazione);
			}
			datiUscita = this.leggiRiga(reader);
		} 
	}
	
}
