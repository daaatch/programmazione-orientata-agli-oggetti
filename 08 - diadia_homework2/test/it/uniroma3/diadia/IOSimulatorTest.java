//package it.uniroma3.diadia;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import it.uniroma3.diaida.DiaDia;
//import it.uniroma3.diaida.IOSimulator;
//
//public class IOSimulatorTest {
//
//	private DiaDia diadia;
//	private IOSimulator console;
//	
//	private String aiuto = "Comandi disponibili:[vai][guarda][prendi][posa][aiuto][fine]";
//	private String fine = "\n*** Grazie per aver giocato! ***";
//	private String vinto = "\n*** Hai vinto! ***";
//	private String perso = "\n*** Game Over: hai esaurito i cfu! ***";
//	private String invalido = "Comando Non Valido\n";
//	private String sconosciuto = "Comando Sconosciuto\n";
//	private String dimmidove = "Dove vuoi andare?\n";
//	private String nodirezione = "Direzione inesistente\n";
//	private String cosaprendi = "Cosa vuoi prendere?\n";
//	private String noninstanza = "L'attrezzo Attrezzo non è presente in questa stanza\n";
//	private String borsapiena = "La tua borsa è troppo pesante\n";
//	private String cosaposi = "Cosa vuoi posare?\n";
//	private String noninborsa = "L'attrezzo Attrezzo non c'è nella tua borsa\n";
//	private String stanzapiena = "Questa stanza è già piena!\n";
//	private String benvenuto = ""+"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
//							   "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'è?\n"+
//							   "I locali sono popolati da strani personaggi, " +
//							   "alcuni amici, altri... chissa!\n"+
//							   "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
//							   "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
//							   "o regalarli se pensi che possano ingraziarti qualcuno.\n"+
//							   "Per conoscere le istruzioni usa il comando [aiuto]\n\n";
//	
//	@Before
//	public void setUp() {
//		this.console = new IOSimulator();
//		this.diadia = new DiaDia(console);
//	}
//	
//	@Test
//	public void testPartitaAiuto() {
//		String[] input = {"aiuto","fine"};
//		this.console.setInput(input);
//		this.diadia.gioca();
//		assertEquals(benvenuto+aiuto+fine,this.console.getOutput());
//	}
//
//}