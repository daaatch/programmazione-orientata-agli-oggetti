package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtectedTest {

	StanzaMagicaProtected stanza_magica;
	Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.stanza_magica = new StanzaMagicaProtected("Stanza Magica",2);
		this.attrezzo = new Attrezzo("Attrezzo",1);
		stanza_magica.addAttrezzo(new Attrezzo("Piccione",3));
	}
	
	@Test
	public void testAddAttrezzoBeforeSoglia() {
		stanza_magica.addAttrezzo(attrezzo);
		assertEquals(new Attrezzo("Attrezzo",1),this.attrezzo);
	}
	
	@Test
	public void testAddAttrezzoAfterSoglia() {
		stanza_magica.addAttrezzo(new Attrezzo("Colomba",4));
		stanza_magica.addAttrezzo(attrezzo);
		assertEquals(new Attrezzo("ozzerttA",2),this.attrezzo);
	}

	@Test
	public void testAddAttrezzoDoppiettaAfterSoglia() {
		stanza_magica.addAttrezzo(new Attrezzo("Colomba",4));
		stanza_magica.addAttrezzo(attrezzo);
		stanza_magica.removeAttrezzo("attrezzo");
		stanza_magica.addAttrezzo(attrezzo);
		assertEquals(new Attrezzo("Attrezzo",4),this.attrezzo);
	}
	
	@Test
	public void testSogliaDopoAttrezziNull() {
		stanza_magica.addAttrezzo(null);
		stanza_magica.addAttrezzo(null);
		stanza_magica.addAttrezzo(attrezzo);
		assertEquals(new Attrezzo("Attrezzo",1),this.attrezzo);
	}
	
}