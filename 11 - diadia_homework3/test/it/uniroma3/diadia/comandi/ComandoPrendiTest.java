package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Labirinto;
import it.uniroma3.diaida.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private ComandoPrendi prendi;
	private Partita partita;
	private IO console;
	
	@Before
	public void setUp() {
		this.prendi = new ComandoPrendi();
		this.partita = new Partita(new Labirinto().crea("monolocale"));
		this.console = new IOConsole();
		this.prendi.setConsole(console);
	}
	
	@Test
	public void testPrendiAttrezzoNull() {
		this.prendi.setParametro(null);
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(null));
	}
	
	@Test
	public void testPrendiAttrezzoNonInStanza() {
		this.prendi.setParametro("Telefono");
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Telefono"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Telefono"));
	}
	
	@Test
	public void testPrendiAttrezzoInStanza() {
		this.prendi.setParametro("Libro");
		this.prendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("Libro"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Libro"));
	}
	
	@Test
	public void testPrendiAttrezzoTroppoPesante() {
		this.prendi.setParametro("Libreria");
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Libreria"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("Libreria"));
	}

}