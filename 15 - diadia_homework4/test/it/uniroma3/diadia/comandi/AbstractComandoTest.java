package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;

public class AbstractComandoTest {

	private AbstractComando comando;
	private IOConsole console;
	private FabbricaDiComandi fabbrica;
	
	@Before
	public void setUp() {
		this.console = new IOConsole();
		this.fabbrica = new FabbricaDiComandiRiflessiva();
	}
	
	@Test
	public void testComandoNonValido() {
		this.comando = fabbrica.costruisciComando("", console);
		assertEquals("Sconosciuto", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoVai() {
		this.comando = fabbrica.costruisciComando("vai piano", console);
		assertEquals("Vai", comando.getNome());
		assertEquals("piano", comando.getParametro());
	}
	
	@Test
	public void testComandoPrendi() {
		this.comando = fabbrica.costruisciComando("prendi questo", console);
		assertEquals("Prendi", comando.getNome());
		assertEquals("questo", comando.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		this.comando = fabbrica.costruisciComando("posa quello", console);
		assertEquals("Posa", comando.getNome());
		assertEquals("quello", comando.getParametro());
	}
	
	@Test
	public void testComandoGuardaNoParametro() {
		this.comando = fabbrica.costruisciComando("guarda", console);
		assertEquals("Guarda", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoGuarda() {
		this.comando = fabbrica.costruisciComando("guarda qui", console);
		assertEquals("Guarda", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoAiutoNoParamtro() {
		this.comando = fabbrica.costruisciComando("aiuto", console);
		assertEquals("Aiuto", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoAiuto() {
		this.comando = fabbrica.costruisciComando("aiuto ti prego", console);
		assertEquals("Aiuto", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoFineNoParametro() {
		this.comando = fabbrica.costruisciComando("fine", console);
		assertEquals("Fine", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoFine() {
		this.comando = fabbrica.costruisciComando("fine basta", console);
		assertEquals("Fine", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoSconosciuto() {
		this.comando = fabbrica.costruisciComando("boh", console);
		assertEquals("Sconosciuto", comando.getNome());
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testComandoSconosciutoConParametro() {
		this.comando = fabbrica.costruisciComando("che scrivo?", console);
		assertEquals("Sconosciuto", comando.getNome());
		assertEquals(null, comando.getParametro());
	}

}
