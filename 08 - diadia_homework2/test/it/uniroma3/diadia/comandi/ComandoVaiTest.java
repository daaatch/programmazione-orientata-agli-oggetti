package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.comandi.ComandoVai;

public class ComandoVaiTest {

	private ComandoVai vai;
	private Partita partita;
	private IO console;	
	private Stanza corrente;
	private Stanza destinazione;
	
	@Before
	public void setUp() {
		this.vai = new ComandoVai();
		this.partita = new Partita();
		this.console = new IOConsole();
		this.corrente = new Stanza("Stanza Corrente");
		this.destinazione = new Stanza("Stanza Destinazione");
		this.partita.setStanzaCorrente(corrente);
		this.vai.setConsole(console);
	}
	
	@Test
	public void testVaiDirezioneNull() {
		this.vai.setParametro(null);
		this.vai.esegui(partita);
		assertEquals(corrente,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		this.vai.setParametro("centro");
		this.vai.esegui(partita);
		assertEquals(corrente,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistenteStanzaEsistente() {
		this.destinazione.impostaStanzaAdiacente("sud", corrente);
		this.vai.setParametro("nord");
		this.vai.esegui(partita);
		assertEquals(corrente,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		this.corrente.collegaStanze("nord-ovest", destinazione);
		this.vai.setParametro("nord-ovest");
		this.vai.esegui(partita);
		assertEquals(destinazione,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistenteStanzaInesistente() {
		this.corrente.collegaStanze("nord-ovest", null);
		this.vai.setParametro("nord-ovest");
		this.vai.esegui(partita);
		assertEquals(corrente,this.partita.getStanzaCorrente());
	}

}
