package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.attrezzi.Attrezzo;
import it.uniroma3.diaida.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private ComandoPrendi prendi;
	private Partita partita;
	private IO console;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.prendi = new ComandoPrendi();
		this.partita = new Partita();
		this.console = new IOConsole();
		this.prendi.setConsole(console);
		this.stanza = new Stanza("Stanza Corrente");
		this.partita.setStanzaCorrente(stanza);
		this.attrezzo = new Attrezzo("Tester", 5);
	}
	
	@Test
	public void testPrendiAttrezzoNull() {
		this.prendi.setParametro(null);
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(null));
	}
	
	@Test
	public void testPrendiAttrezzoNonInStanza() {
		this.prendi.setParametro("Tester");
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Tester"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Tester"));
	}
	
	@Test
	public void testPrendiAttrezzoInStanza() {
		this.stanza.addAttrezzo(attrezzo);
		this.prendi.setParametro("Tester");
		this.prendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("Tester"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Tester"));
	}
	
	@Test
	public void testPrendiAttrezzoTroppoPesante() {
		this.stanza.addAttrezzo(attrezzo);
		this.attrezzo.setPeso(11);
		this.prendi.setParametro("Tester");
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Tester"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("Tester"));
	}

}