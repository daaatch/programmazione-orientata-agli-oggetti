package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.IOConsole;
import it.uniroma3.diaida.comandi.Fisarmonica;

public class FisarmonicaTest {

	private Fisarmonica fisarmonica;
	private IO console;
	private String istruzione;
	
	@Before
	public void setUp() {
		this.fisarmonica = new Fisarmonica();
		this.console = new IOConsole();
	}
	
	@Test
	public void testCostruisciComandoNonValido() {
		this.istruzione = "";
		assertEquals("Invalido", this.fisarmonica.costruisciComando(istruzione, console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiSenzaDirezione() {
		this.istruzione = "vai";
		assertEquals("Vai",this.fisarmonica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoVaiConDirezione() {
		this.istruzione = "vai nord";
		assertEquals("Vai",this.fisarmonica.costruisciComando(istruzione,console).getNome());
		assertEquals("nord",this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPrendiSenzaAttrezzo() {
		this.istruzione = "prendi";
		assertEquals("Prendi",this.fisarmonica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}

	@Test
	public void testCostruisciComandoPrendiConAttrezzo() {
		this.istruzione = "prendi attrezzo";
		assertEquals("Prendi",this.fisarmonica.costruisciComando(istruzione,console).getNome());
		assertEquals("attrezzo",this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPosaSenzaAttrezzo() {
		this.istruzione = "posa";
		assertEquals("Posa",this.fisarmonica.costruisciComando(istruzione,console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPosaConAttrezzo() {
		this.istruzione = "posa attrezzo";
		assertEquals("Posa",this.fisarmonica.costruisciComando(istruzione,console).getNome());
		assertEquals("attrezzo",this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		this.istruzione = "guarda";
		assertEquals("Guarda", this.fisarmonica.costruisciComando(istruzione, console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoAiuto() {
		this.istruzione = "aiuto";
		assertEquals("Aiuto", this.fisarmonica.costruisciComando(istruzione, console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoFine() {
		this.istruzione = "fine";
		assertEquals("Fine", this.fisarmonica.costruisciComando(istruzione, console).getNome());
		assertNull(this.fisarmonica.costruisciComando(istruzione, console).getParametro());
	}
	
}