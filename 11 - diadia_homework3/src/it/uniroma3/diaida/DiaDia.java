package it.uniroma3.diaida;

import it.uniroma3.diaida.ambienti.Labirinto;
import it.uniroma3.diaida.comandi.Comando;
import it.uniroma3.diaida.comandi.FabbricaDiComandi;
import it.uniroma3.diaida.comandi.Fisarmonica;

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'è?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n"+
			"Per conoscere le istruzioni usa il comando [aiuto]\n\n";

	private Partita partita;
	private IO console;

	public DiaDia(IO console) {	
		this.partita = new Partita(new Labirinto().crea("classico"));
		this.console = console;
	}
	
	public DiaDia(Labirinto labiritnto,IO console) {	
		this.partita = new Partita(labiritnto);
		this.console = console;
	}
	
	public void gioca() { 
		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		String istruzione;	
		do istruzione = this.console.leggiRiga();
		while(!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new Fisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione, this.console);
		comandoDaEseguire.esegui(this.partita);
		if(this.partita.vinta())
			this.console.mostraMessaggio("\n*** Hai vinto! ***");
		if((!this.partita.getGiocatore().isVivo())&&(!this.partita.vinta()))
			this.console.mostraMessaggio("\n*** Game Over: hai esaurito i cfu! ***");
		return this.partita.isFinita();
	}		

	public static void main(String[] argc) {
		IO console = new IOConsole();
		Labirinto labirinto = new Labirinto().crea("classico");
		DiaDia gioco = new DiaDia(labirinto,console);
		gioco.gioca();
	}
	
}