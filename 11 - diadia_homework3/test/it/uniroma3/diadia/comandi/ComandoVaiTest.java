package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Labirinto;
import it.uniroma3.diaida.comandi.ComandoVai;

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
	
	@Test
	public void testVaiDirezioneInesistente() {
		this.vai.setParametro("centro");
		this.vai.esegui(partita);
		assertEquals("Salone",this.partita.getStanzaCorrente().getNome());
	}
	
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
