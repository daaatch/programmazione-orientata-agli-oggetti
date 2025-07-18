package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {

	private Partita partita = new Partita(new Labirinto().crea("test giocatore"));
	private Giocatore giocatore = this.partita.getGiocatore();
	private Borsa borsa = new Borsa(5);
	private Attrezzo bussola = new Attrezzo("Bussola",1);
	private Attrezzo torcia = new Attrezzo("Torcia",1);
	private Attrezzo mappa = new Attrezzo("Mappa",1);
	private Attrezzo fazzoletti = new Attrezzo("Fazzoletti",1);
	private Attrezzo apriscatole = new Attrezzo("Apriscatole",2);

	@Before
	public void setUp() {
		this.giocatore.setBorsa(borsa);
		this.borsa.addAttrezzo(bussola);
		this.borsa.addAttrezzo(torcia);
		this.borsa.addAttrezzo(mappa);
		this.borsa.addAttrezzo(fazzoletti);
	}
	
	@Test
	public void testPrendiAttrezzoInStanza() {
		assertTrue(this.giocatore.prendi(new Attrezzo("Quaderno",1)));
	}
	
	@Test
	public void testOverflowBorsa() {
		assertFalse(this.giocatore.prendi(new Attrezzo("Giacca",3)));
	}
	
	@Test
	public void testPrendiNull() {
		assertFalse(this.giocatore.prendi(null));
	}
	
	@Test
	public void testPrendiAttrezzoNonInStanza() {
		assertFalse(this.giocatore.prendi(apriscatole));
	}
	
	@Test
	public void testPosaAttrezzoInBorsa() {
		assertEquals(torcia,this.giocatore.posa("Torcia"));
	}
	
	@Test
	public void testPosaAttrezzoNonInBorsa() {
		assertEquals(null,this.giocatore.posa("Apriscatole"));
	}
	
	@Test
	public void testPosaAttrezzoNullo() {
		assertEquals(null,this.giocatore.posa(null));
	}

}