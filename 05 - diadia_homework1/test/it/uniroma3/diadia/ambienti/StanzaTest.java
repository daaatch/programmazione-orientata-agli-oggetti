package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.attrezzi.Attrezzo;

public class StanzaTest {

		private Stanza stanzaTest = new Stanza("stanzaTest");
		private Stanza stanzaNord = new Stanza("stanzaNord");
		private Stanza stanzaOvest = new Stanza("stanzaOvest");
		private Stanza stanzaSud = new Stanza("stanzaSud");
		private Stanza stanzaEst = new Stanza("stanzaEst");
		private Stanza stanzaNordOvest = new Stanza("stanzaNordOvest");
		
		private Attrezzo spada = new Attrezzo("spada",3);
		private Attrezzo scudo = new Attrezzo("scudo",5);
		private Attrezzo lancia = new Attrezzo("lancia",4);
		private Attrezzo mappa = new Attrezzo("mappa",1);
		private Attrezzo lanterna = new Attrezzo("lanterna",2);
		private Attrezzo osso = new Attrezzo("osso",1);
	
	@Before
	public void setUp() {
		
		stanzaTest.collegaStanze("nord",stanzaNord);
		stanzaTest.collegaStanze("ovest",stanzaOvest);
		stanzaTest.collegaStanze("sud", stanzaSud);
		stanzaTest.addAttrezzo(spada);
		stanzaTest.addAttrezzo(scudo);
		stanzaTest.addAttrezzo(osso);
		stanzaTest.addAttrezzo(mappa);
	}
	
	@Test
	public void testCollegaStanzaNulla() {
		stanzaTest.collegaStanze("est",null);
		assertEquals(null,stanzaTest.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testCollegaDirezioneNulla() {
		stanzaTest.collegaStanze(null,stanzaNordOvest);
		assertEquals(null,stanzaTest.getStanzaAdiacente("nord/ovest"));
	}
	
	@Test
	public void testCollegaTuttoNullo() {
		stanzaTest.collegaStanze(null,null);
		assertEquals(null,stanzaTest.getStanzaAdiacente(null));
	}
	
	@Test
	public void testCollegaStanzaMancante() {
		stanzaTest.collegaStanze("est",stanzaEst);
		assertEquals(stanzaEst,stanzaTest.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testOverflowDirezioni() {
		stanzaTest.collegaStanze("est",stanzaEst);
		stanzaTest.collegaStanze("nord/ovest",stanzaNordOvest);
		assertNull(stanzaTest.getStanzaAdiacente("nord/ovest"));
	}
	
	@Test
	public void testSovrascriviDirezione() {
		stanzaTest.collegaStanze("est",stanzaEst);
		stanzaTest.collegaStanze("nord", stanzaNordOvest);
		assertEquals(stanzaNordOvest, stanzaTest.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testAddAttrezzoMancante() {
		assertTrue(stanzaTest.addAttrezzo(lanterna));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertFalse(stanzaTest.addAttrezzo(null));
	}
	
	@Test
	public void testOverflowAttrezzi() {
		stanzaTest.addAttrezzo(lanterna);
		assertFalse(stanzaTest.addAttrezzo(lancia));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		assertEquals(spada,stanzaTest.removeAttrezzo(spada));
	}
	
	@Test
	public void testRemoveAttrezzoAssente() {
		assertEquals(null,stanzaTest.removeAttrezzo(lancia));
	}
	
	@Test
	public void testRemoveAttrezzoNullo() {
		assertEquals(null,stanzaTest.removeAttrezzo("null"));
	}
	
}