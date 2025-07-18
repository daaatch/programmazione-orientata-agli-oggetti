package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.ambienti.StanzaBuia;
import it.uniroma3.diaida.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo torcia;
	
	@Before
	public void setUp() {
		this.stanza = new StanzaBuia("Stanza","Torcia");
		this.torcia = new Attrezzo("Torcia",2);;
	}
	
	@Test
	public void testStanzaBuiaPerSempre() {
		this.stanza.setAttrezzoLuminoso(null);
		assertEquals("(§) Questo posto resterà buio per sempre.\n",this.stanza.getDescrizione());
	}
	
	@Test
	public void testStanzaBuiaSenzaTorcia() {
		assertEquals("(§) Ci sta un buio pesto qua dentro...\n"+
	                 "(§) Procurati Torcia per vedere qualcosa\n",this.stanza.getDescrizione());
	}
	
	@Test
	public void StanzaBuiaConTorcia() {
		this.stanza.addAttrezzo(torcia);
		assertEquals("(§) Posizione attuale:Stanza\n"+
                	 "(§) Uscite:\n"+
				     "(§) Attrezzi nella stanza:[Torcia (2kg)]\n",this.stanza.getDescrizione());
	}

}
