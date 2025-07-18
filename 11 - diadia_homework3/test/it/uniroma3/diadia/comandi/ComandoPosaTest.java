package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Labirinto;
import it.uniroma3.diaida.attrezzi.Attrezzo;
import it.uniroma3.diaida.comandi.ComandoPosa;

public class ComandoPosaTest {

	private ComandoPosa posa;
	private Partita partita;
	private IO console;
	
	@Before
	public void setUp() {
		this.posa = new ComandoPosa();
		this.partita = new Partita(new Labirinto().crea("monolocale"));
		this.console = new IOConsole();
		this.posa.setConsole(console);
		this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("Quaderno",2));
		this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("Penna",1));
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
		this.posa.setParametro("Bottone");
		this.posa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Bottone"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Bottone"));
	}
	
	@Test
	public void testPosaAttrezzoInBorsa() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("Matita",1));
		this.posa.setParametro("Matita");
		this.posa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Matita"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("Matita"));
	}
	
	@Test
	public void testPosaAttrezzoInStanzaPiena() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("Matita",1));
		this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("Pennarello",2));
		this.posa.setParametro("Matita");
		this.posa.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("Matita"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Matita"));
	}

}