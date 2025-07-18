package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.attrezzi.Attrezzo;
import it.uniroma3.diaida.comandi.ComandoPosa;

public class ComandoPosaTest {

	private ComandoPosa posa;
	private Partita partita;
	private IO console;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.posa = new ComandoPosa();
		this.partita = new Partita();
		this.console = new IOConsole();
		this.posa.setConsole(console);
		this.stanza = new Stanza("Stanza Corrente");
		this.partita.setStanzaCorrente(stanza);
		this.attrezzo = new Attrezzo("Tester", 5);
		for(int i=1; i<5; i++) {
			this.stanza.addAttrezzo(new Attrezzo("Attrezzo "+i,i));
		}
	}
	
	@Test
	public void testPosaAttrezzoNull() {
		this.posa.setParametro(null);
		this.posa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(null));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(null));
	}
	
	@Test
	public void testPosaAttrezzoNonInBorsa() {
		this.posa.setParametro("Tester");
		this.posa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Tester"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Tester"));
	}
	
	@Test
	public void testPosaAttrezzoInBorsa() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		this.posa.setParametro("Tester");
		this.posa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Tester"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("Tester"));
	}
	
	@Test
	public void testPosaAttrezzoInStanzaPiena() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		this.stanza.addAttrezzo(new Attrezzo("Attrezzo 5",5));
		this.posa.setParametro("Tester");
		this.posa.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("Tester"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Tester"));
	}

}