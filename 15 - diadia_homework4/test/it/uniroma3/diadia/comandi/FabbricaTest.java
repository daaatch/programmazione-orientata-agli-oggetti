package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaTest {

	private FabbricaDiComandi fabbrica;
	private IO console;
	private String istruzione;
	
	@Before
	public void setUp() {
		this.fabbrica = new FabbricaDiComandiRiflessiva();
		this.console = new IOConsole();
	}
	
	@Test
	public void testCostruisciComandoNonValido() {
		this.istruzione = "";
		assertEquals("Sconosciuto",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiSenzaDirezione() {
		this.istruzione = "vai";
		assertEquals("Vai",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiConDirezione() {
		this.istruzione = "vai nord";
		assertEquals("Vai",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertEquals("nord",this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPrendiSenzaAttrezzo() {
		this.istruzione = "prendi";
		assertEquals("Prendi",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}

	@Test
	public void testCostruisciComandoPrendiConAttrezzo() {
		this.istruzione = "prendi attrezzo";
		assertEquals("Prendi",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertEquals("attrezzo",this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPosaSenzaAttrezzo() {
		this.istruzione = "posa";
		assertEquals("Posa",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPosaConAttrezzo() {
		this.istruzione = "posa attrezzo";
		assertEquals("Posa",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertEquals("attrezzo",this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		this.istruzione = "guarda";
		assertEquals("Guarda",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		this.istruzione = "aiuto";
		assertEquals("Aiuto",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoFine() {
		this.istruzione = "fine";
		assertEquals("Fine",this.fabbrica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fabbrica.costruisciComando(istruzione,console).getParametro());
	}
	
}
