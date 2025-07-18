package it.uniroma3.diadia.ambienti.giocatore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.attrezzi.Attrezzo;
import it.uniroma3.diaida.giocatore.Borsa;
import it.uniroma3.diaida.giocatore.Giocatore;

public class GiocatoreTest {

	private Partita partita = new Partita();
	private Stanza corridoio = new Stanza("corridoio");
	private Giocatore giocatore = this.partita.getGiocatore();
	private Borsa borsa = new Borsa(5);
	private Attrezzo bussola = new Attrezzo("bussola",1);
	private Attrezzo torcia = new Attrezzo("torcia",1);
	private Attrezzo mappa = new Attrezzo("mappa",1);
	private Attrezzo giacca = new Attrezzo("giacca",3);
	private Attrezzo quaderno = new Attrezzo("quaderno",1);
	private Attrezzo fazzoletti = new Attrezzo("fazzoletti",1);
	private Attrezzo bottiglia = new Attrezzo("bottiglia",2);
	private Attrezzo apriscatole = new Attrezzo("apriscatole",2);

	@Before
	public void setUp() {
		this.partita.setStanzaCorrente(corridoio);
		this.giocatore.setBorsa(borsa);
		this.corridoio.addAttrezzo(giacca);
		this.corridoio.addAttrezzo(bottiglia);
		this.corridoio.addAttrezzo(quaderno);
		this.borsa.addAttrezzo(bussola);
		this.borsa.addAttrezzo(torcia);
		this.borsa.addAttrezzo(mappa);
		this.borsa.addAttrezzo(fazzoletti);
	}
	
	@Test
	public void testPrendiAttrezzoInStanza() {
		assertTrue(this.giocatore.prendi(quaderno));
	}
	
	@Test
	public void testOverflowBorsa() {
		assertFalse(this.giocatore.prendi(giacca));
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
		assertEquals(torcia,this.giocatore.posa("torcia"));
	}
	
	@Test
	public void testPosaAttrezzoNonInBorsa() {
		assertEquals(null,this.giocatore.posa("apriscatole"));
	}
	
	@Test
	public void testPosaAttrezzoNullo() {
		assertEquals(null,this.giocatore.posa(null));
	}
	
}