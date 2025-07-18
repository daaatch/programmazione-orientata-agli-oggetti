package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.ambienti.StanzaBloccata;
import it.uniroma3.diaida.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private Stanza stanza;
	private StanzaBloccata bloccata;
	private Attrezzo chiave;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza("Stanza");
		this.bloccata = new StanzaBloccata("Stanza Chiusa","Chiave","nord");
		this.chiave = new Attrezzo("Chiave",10);
		this.bloccata.collegaStanze("nord",stanza);
	}
	
	@Test
	public void testStanzaBloccataPerFinta() {
		this.bloccata.setPassepartout(null);
		this.bloccata.setPortaChiusa(null);
		assertEquals(this.stanza,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaBloccataChiaveNull() {
		this.bloccata.setPassepartout(null);
		assertEquals(this.bloccata,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaBloccataDirezioneNull() {
		this.bloccata.setPortaChiusa(null);
		assertEquals(this.stanza,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaBloccataSenzaChiavi() {
		assertEquals(this.bloccata,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaBloccataConLeChiavi() {
		this.bloccata.addAttrezzo(chiave);
		assertEquals(this.stanza,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testPassoDaUnAltraParteSenzaChiavi() {
		this.bloccata.impostaStanzaAdiacente("est",stanza);
		assertEquals(this.stanza,this.bloccata.getStanzaAdiacente("est"));
		assertEquals(this.bloccata,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testPassoDaUnAltraParteConLeChiavi() {
		this.bloccata.impostaStanzaAdiacente("est",stanza);
		this.bloccata.addAttrezzo(chiave);
		assertEquals(this.stanza,this.bloccata.getStanzaAdiacente("est"));
		assertEquals(this.stanza,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testDescrizioneSenzaPorteChiuse() {
		this.bloccata.setPortaChiusa(null);
		assertEquals("(§) Posizione attuale: Stanza Chiusa\n"+
					 "(§) Uscite:[nord]\n"+
					 "(§) Attrezzi nella stanza: nessuno\n",this.bloccata.getDescrizione());
	}
	
	@Test
	public void testDescrizioneConPortaAperta() {
		this.bloccata.addAttrezzo(chiave);
		assertEquals("(§) Posizione attuale: Stanza Chiusa\n"+
					 "(§) Uscite:[nord]\n"+
					 "(§) Attrezzi nella stanza:[Chiave (10kg)]\n",this.bloccata.getDescrizione());
	}
	
	@Test
	public void testDescrizioneConPortaChiusa() {
		assertEquals("(§) Posizione attuale: Stanza Chiusa\n"+
				     "(§) Uscite disponibili: nessuna\n"+
				     "(§) Uscite bloccate:[nord]\n"+
				     "(§) Attrezzi nella stanza: nessuno\n",this.bloccata.getDescrizione());
	}

}
