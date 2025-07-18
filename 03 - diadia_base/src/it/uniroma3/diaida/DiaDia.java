package it.uniroma3.diaida;

import java.util.Scanner;

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		
		scannerDiLinee = new Scanner(System.in);		
		do	istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}   

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome()==null) {
			System.out.print("");
		} else {
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else {
				if (comandoDaEseguire.getNome().equals("vai")) {
					this.vai(comandoDaEseguire.getParametro());
				} else { 
					if (comandoDaEseguire.getNome().equals("aiuto")) {
						this.aiuto();
					} else {
						System.out.println("Comando sconosciuto");	
					}	
				}
			}
		}
		
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else {
			if (this.partita.isFinita()) {
				System.out.println("Game over: hai esaurito i cfu!");
				return true;
			} else {
				return false;
			}
		}
	}   

	private void aiuto() {
		System.out.print("Comandi disponibili:");
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(" {"+elencoComandi[i]+"}");
		System.out.println("");
	}

	private void vai(String direzione) {
		if(direzione==null) {
			System.out.println("Dove vuoi andare?");
		} else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null) {
				System.out.println("Direzione inesistente");
			} else {
				this.partita.setStanzaCorrente(prossimaStanza);
				this.partita.scalaCfu();
			}
			System.out.println(partita.getStanzaCorrente().getDescrizione());
		}
	}

	private void fine() {
		System.out.println("Grazie per aver giocato!");
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
	
}