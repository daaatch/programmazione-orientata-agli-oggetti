package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Test;

public class LabirintoLoaderTest {

	private static final String DESCRIZIONE_LABIRINTO
			= "Stanze:\n" 
			+ "N11\n"
			+ "Magiche:\n"
			+ "N1\n"
			+ "Buie:\n"
			+ "Estremi:\n"
			+ "N10\n"
			+ "Biblioteca\n"
			+ "Attrezzi:\n"
			+ "Osso 5 N10\n"
			+ "Uscite:\n"
			+ "N10 nord Biblioteca\n"
			+ "Biblioteca sud N10";
	
	@Test
	public void testCarica() {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(DESCRIZIONE_LABIRINTO));
		caricatore.carica();
		Labirinto labirinto = caricatore.getLabirinto();
		assertEquals("N10", labirinto.getStanzaCorrente().getNome());
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
		assertEquals("Osso", labirinto.getStanzaCorrente().getAttrezzo("Osso").getNome());
		assertEquals(5, labirinto.getStanzaCorrente().getAttrezzo("Osso").getPeso());
	}

}
