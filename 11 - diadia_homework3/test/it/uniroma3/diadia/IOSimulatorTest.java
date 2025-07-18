package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.DiaDiaSimulator;
import it.uniroma3.diaida.IOSimulator;

public class IOSimulatorTest {

	private DiaDiaSimulator diadia;
	private IOSimulator console;
	private List<String> input;
	
	
	private String aiuto = "Comandi disponibili:[vai][guarda][prendi][posa][aiuto][fine]\n";
	private String fine = "\n*** Grazie per aver giocato! ***";
	private String vinto = "\n*** Hai vinto! ***";
	private String perso = "\n*** Game Over: hai esaurito i cfu! ***";
	private String invalido = "Comando Non Valido\n";
	private String sconosciuto = "Comando Sconosciuto\n";
	private String dimmiDove = "Dove vuoi andare?\n";
	private String noDirezione = "Direzione inesistente\n";
	private String cosaPrendi = "Cosa vuoi prendere?\n";
	private String nonInStanza = "L'attrezzo qualcosa non è presente in questa stanza\n";
	private String cosaPosi = "Cosa vuoi posare?\n";
	private String nonInBorsa = "L'attrezzo qualcosa non c'è nella tua borsa\n";
	private String benvenuto = ""+"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
							   "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'è?\n"+
							   "I locali sono popolati da strani personaggi, " +
							   "alcuni amici, altri... chissa!\n"+
							   "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
							   "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
							   "o regalarli se pensi che possano ingraziarti qualcuno.\n"+
							   "Per conoscere le istruzioni usa il comando [aiuto]\n\n";

	@Before
	public void setUp() {
		this.console = new IOSimulator();
		this.diadia = new DiaDiaSimulator(console);
		this.input = new ArrayList<>();
	}
	
	public void setInput() {
		this.input.add("aiuto");
		this.input.add("fine");
		this.console.setInput(input);
	}
	
	@Test
	public void testSetInput() {
		this.setInput();
		assertEquals("aiuto",this.console.leggiRiga());
		assertEquals("fine",this.console.leggiRiga());
	}
	
	@Test
	public void testGetOutput() {
		this.setInput();
		this.diadia.gioca();
		assertEquals(benvenuto+aiuto+fine,this.console.getOutput());
	}
	
	@Test
	public void testVinciSubito() {
		this.input.add("vai nord");
		this.console.setInput(input);
		this.diadia.gioca();
		assertEquals(benvenuto+vinto,this.console.getOutput());
	}
	
	@Test
	public void testPrendiVinci() {
		this.input.add("prendi qualcosa");
		this.input.add("vai nord");
		this.console.setInput(input);
		this.diadia.gioca();
		assertEquals(benvenuto+nonInStanza+vinto,this.console.getOutput());
	}
	
	@Test
	public void testAiutoComandiAccasoFine() {
		this.input.add("aiuto");
		this.input.add("prendi");
		this.input.add("posa qualcosa");
		this.input.add("comando a caso");
		this.input.add("fine");
		this.console.setInput(input);
		this.diadia.gioca();
		assertEquals(benvenuto+aiuto+cosaPrendi+nonInBorsa+sconosciuto+fine,this.console.getOutput());
	}
	
	@Test
	public void testEsaurisciCfu() {
		this.input.add("vai est");
		this.input.add("vai ovest");
		this.input.add("vai est");
		this.input.add("vai est");
		this.input.add("vai ovest");
		this.input.add("vai est");
		this.input.add("vai ovest");
		this.input.add("vai ovest");
		this.input.add("vai sud");
		this.console.setInput(input);
		this.diadia.gioca();
		assertEquals(benvenuto+perso,this.console.getOutput());
	}

	@Test
	public void testAiutoComandoNonValidoVaiAccasoFine() {
		this.input.add("aiuto");
		this.input.add("");
		this.input.add("vai");
		this.input.add("vai da quella parte");
		this.input.add("posa");
		this.input.add("prendi osso");
		this.input.add("fine");
		this.console.setInput(input);
		this.diadia.gioca();
		assertEquals(benvenuto+aiuto+invalido+dimmiDove+noDirezione+cosaPosi+fine,this.console.getOutput());
	}
	
}