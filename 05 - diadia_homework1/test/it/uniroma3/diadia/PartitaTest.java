package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.Partita;

public class PartitaTest {
	
	private Partita partita;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
	}

	@Test
	public void testStanzaCorrenteNonVincente() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testStanzaCorrenteVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testGameOver() {
		this.partita.giocatore.setCfu(0);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaFinitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaFinitaPersa() {
		this.partita.giocatore.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
}