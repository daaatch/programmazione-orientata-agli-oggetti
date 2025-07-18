package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diaida.ambienti.Labirinto;
import it.uniroma3.diaida.ambienti.Stanza;

public class LabirintoTest {

	private Labirinto labirinto = new Labirinto();
	private Stanza nuovaStanzaCorrente = new Stanza("nuovaStanzaCorrente");
	private Stanza nuovaStanzaVincente = new Stanza("nuovaStanzaVincente");
	
	@Test
	public void testInitStanzaCorrente() {
		assertNotNull(this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testInitStanzaVincente() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}

	@Test
	public void testSetNuovaStanzaCorrente() {
		this.labirinto.setStanzaCorrente(nuovaStanzaCorrente);
		assertEquals(nuovaStanzaCorrente,this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testSetNuovaStanzaVincente() {
		this.labirinto.setStanzaVincente(nuovaStanzaVincente);
		assertEquals(nuovaStanzaVincente,this.labirinto.getStanzaVincente());
	}
	
	@Test
	public void testSetNuovaStanzaCorrenteNulla() {
		this.labirinto.setStanzaCorrente(null);
		assertNotNull(this.labirinto.getStanzaCorrente());
	}

}