package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class LabirintoBuilderTest {
	
	private LabirintoBuilder builder;
	
	@Before
	public void setUp() {
		this.builder = new LabirintoBuilder();
	}

	@Test
	public void testAddNuovaStanzaIniziale() {
		this.builder.addStanzaIniziale("Iniziale");
		assertTrue(builder.getStanzaIniziale().getNome().equals("Iniziale"));
		assertTrue(builder.getUltimaAggiunta().getNome().equals("Iniziale"));
	}
	
	@Test
	public void testAddStanzaInizialeEsistente() {
		this.builder.addStanza("Iniziale");
		this.builder.addStanza("Finale");
		this.builder.addStanzaIniziale("Iniziale");
		assertTrue(builder.getStanzaIniziale().getNome().equals("Iniziale"));
		assertFalse(builder.getUltimaAggiunta().getNome().equals("Iniziale"));
	}
	
	@Test
	public void testAddStanzaInizialeNull() {
		this.builder.addStanzaIniziale(null);
		assertNull(builder.getStanzaIniziale());
	}
	
	@Test
	public void testAddNuovaStanzaVincente() {
		this.builder.addStanzaVincente("Vincente");
		assertTrue(builder.getStanzaVincente().getNome().equals("Vincente"));
		assertNotNull(builder.getStanzaVincente());
	}
	
	@Test
	public void testAddStanzaVincenteEsistente() {
		this.builder.addStanza("Vincente");
		this.builder.addStanzaVincente("Vincente");
		assertNotNull(builder.getStanzaVincente());
		assertTrue(builder.getUltimaAggiunta().getNome().equals("Vincente"));
	}
	
	@Test
	public void testAddStanzaVincenteNull() {
		this.builder.addStanzaVincente(null);
		assertNull(builder.getStanzaVincente());
	}
	
	@Test
	public void testAddStanzaNuova() {
		this.builder.addStanza("Nuova");
		assertTrue(builder.getUltimaAggiunta().getNome().equals("Nuova"));
	}
	
	@Test
	public void testAddStanzaEsistente() {
		this.builder.addStanza("Nuova");
		this.builder.addStanza("Nuovissima");
		this.builder.addStanza("Nuova");
		assertFalse(builder.getUltimaAggiunta().getNome().equals("Nuova"));
	}
	
	@Test
	public void testAddStanzaNull() {
		this.builder.addStanza(null);
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaBloccataNuova() {
		this.builder.addStanzaBloccata("Bloccata","chiave","nord/ovest");
		assertEquals(builder.getUltimaAggiunta().getNome(),"Bloccata");
	}
	
	@Test
	public void testAddStanzaBloccataEsistente() {
		this.builder.addStanza("Bloccata");
		this.builder.addStanza("Bloccatissima");
		this.builder.addStanzaBloccata("Bloccata","chiave","nord/ovest");
		assertNotEquals(builder.getUltimaAggiunta().getNome(),"Bloccata");
	}
	
	@Test
	public void testAddStanzaBloccataNomeNull() {
		this.builder.addStanzaBloccata(null,"chiave","nord/ovest");
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaBloccataAttrezzoNull() {
		this.builder.addStanzaBloccata("Bloccata",null,"nord/ovest");
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaBloccataDirezioneNull() {
		this.builder.addStanzaBloccata("Bloccata","chiave",null);
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaBuiaNuova() {
		this.builder.addStanzaBuia("Buia","Lanterna");
		assertEquals(builder.getUltimaAggiunta().getNome(),"Buia");
	}
	
	@Test
	public void testAddStanzaBuiaEsistente() {
		this.builder.addStanza("Buia");
		this.builder.addStanzaBuia("Buia","Lanterna");
		assertEquals(builder.getUltimaAggiunta().getNome(),"Buia");
	}
	
	@Test
	public void testAddStanzaBuiaNomeNull() {
		this.builder.addStanzaBuia(null,"Lanterna");
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaBuiaAttrezzoNull() {
		this.builder.addStanzaBuia("Buia",null);
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaMagicaNuovaConSoglia() {
		this.builder.addStanzaMagica("Magica",7);
		assertEquals(builder.getUltimaAggiunta().getNome(),"Magica");
	}
	
	@Test
	public void testAddStanzaMagicaNuovaSenzaSoglia() {
		this.builder.addStanzaMagica("Magica");
		assertEquals(builder.getUltimaAggiunta().getNome(),"Magica");
	}
	
	@Test
	public void testAddStanzaMagicaEsistenteConSoglia() {
		this.builder.addStanza("Magica");
		this.builder.addStanzaMagica("Magica",7);
		assertEquals(builder.getUltimaAggiunta().getNome(),"Magica");
	}
	
	@Test
	public void testAddStanzaMagicaEsistenteSenzaSoglia() {
		this.builder.addStanza("Magica");
		this.builder.addStanzaMagica("Magica");
		assertEquals(builder.getUltimaAggiunta().getNome(),"Magica");
	}
	
	@Test
	public void testAddStanzaMagicaConSogliaNomeNull() {
		this.builder.addStanzaMagica(null,7);
		assertNull(builder.getUltimaAggiunta());
	}
	
	@Test
	public void testAddStanzaMagicaSenzaSogliaNomeNull() {
		this.builder.addStanzaMagica(null);
		assertNull(builder.getUltimaAggiunta());
	}
	
}
