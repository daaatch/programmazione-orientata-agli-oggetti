package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoVaiTest {

	private ComandoVai vai;
	private Partita partita;
	private IO console;	
	
	@Before
	public void setUp() {
		this.vai = new ComandoVai();
		this.partita = new Partita(new Labirinto().crea("bilocale"));
		this.console = new IOConsole();
		this.vai.setConsole(console);
	}
	
	@Test
	public void testVaiDirezioneNull() {
		this.vai.setParametro(null);
		this.vai.esegui(partita);
		assertEquals("Salone",this.partita.getStanzaCorrente().getNome());
	}
	
//	@Test
//	public void testVaiDirezioneInesistente() {
//		this.vai.setParametro("centro");
//		this.vai.esegui(partita);
//		assertEquals("Salone",this.partita.getStanzaCorrente().getNome());
//	}
	
	@Test
	public void testVaiDirezioneInesistenteStanzaEsistente() {
		this.vai.setParametro("nord");
		this.vai.esegui(partita);
		assertEquals("Salone",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		this.vai.setParametro("sud");
		this.vai.esegui(partita);
		assertEquals("Cucina",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiDirezioneEsistenteStanzaInesistente() {
		this.vai.setParametro("ovest");
		this.vai.esegui(partita);
		assertEquals("Salone",this.partita.getStanzaCorrente().getNome());
	}

}
