package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.attrezzi.Attrezzo;
import it.uniroma3.diaida.giocatore.Borsa;

public class BorsaTest {

	private Borsa borsa = new Borsa(6);
	private Attrezzo bussola = new Attrezzo("bussola",1);
	private Attrezzo torcia = new Attrezzo("torcia",1);
	private Attrezzo mappa = new Attrezzo("mappa",1);
	private Attrezzo giacca = new Attrezzo("giacca",3);
	private Attrezzo quaderno = new Attrezzo("quaderno",1);
	private Attrezzo fazzoletti = new Attrezzo("fazzoletti",1);
	private Attrezzo bottiglia = new Attrezzo("bottiglia",2);
	
	@Before
	public void setUp() {
		this.borsa.addAttrezzo(bussola);
		this.borsa.addAttrezzo(mappa);
		this.borsa.addAttrezzo(torcia);
		this.borsa.addAttrezzo(quaderno);
	}
	
	@Test
	public void testAddAttrezzoMancante() {
		assertTrue(this.borsa.addAttrezzo(fazzoletti));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(this.borsa.addAttrezzo(null));
	}
	
	@Test
	public void testOverflowPeso() {
		assertFalse(this.borsa.addAttrezzo(giacca));
	}
	
	@Test
	public void testOverflowElementi() {
		assertTrue(this.borsa.addAttrezzo(bottiglia));
		assertFalse(this.borsa.addAttrezzo(fazzoletti));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		assertEquals(torcia, this.borsa.removeAttrezzo("torcia"));
	}
	
	@Test
	public void testRemoveAttrezzoAssente() {
		assertEquals(null, this.borsa.removeAttrezzo("bottiglia"));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		assertNull(this.borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzoPresente() {
		assertTrue(this.borsa.hasAttrezzo("quaderno"));
	}
	
	@Test
	public void testHasAttrezzoAssente() {
		assertFalse(this.borsa.hasAttrezzo("giacca"));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		assertFalse(this.borsa.hasAttrezzo(null));
	}

}