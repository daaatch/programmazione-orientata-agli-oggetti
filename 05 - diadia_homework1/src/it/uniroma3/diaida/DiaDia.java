package it.uniroma3.diaida;

import it.uniroma3.diaida.IOConsole.IOConsole;
import it.uniroma3.diaida.ambienti.Stanza;

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
	
	static final private String[] elencoComandi = {"vai","prendi","posa","aiuto","fine"};

	private Partita partita;
	private IOConsole IOConsole;

	public DiaDia(IOConsole IOConsole) {	
		this.partita = new Partita();
		this.IOConsole = IOConsole;
	}

	public void gioca() { 
		this.IOConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.IOConsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString());		
		String istruzione;		
		do istruzione = this.IOConsole.leggiRiga();
		while(!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) {		
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
			this.IOConsole.mostraMessaggio("");
		} else {
			if(comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else {
				if(comandoDaEseguire.getNome().equals("vai")) {
					this.vai(comandoDaEseguire.getParametro());
				} else { 
					if(comandoDaEseguire.getNome().equals("aiuto")) {
						this.aiuto();
					} else {
						if(comandoDaEseguire.getNome().equals("prendi")) {
							this.prendi(comandoDaEseguire.getParametro());
						} else {
							if(comandoDaEseguire.getNome().equals("posa")) {
								this.posa(comandoDaEseguire.getParametro());
							} else {
								this.IOConsole.mostraMessaggio("Comando sconosciuto\n");
							}
						}	
					}	
				}
			}
		}		
		if (this.partita.vinta()) {
			this.IOConsole.mostraMessaggio("\n### Hai vinto! ###");
			return true;
		} else {
			if (this.partita.isFinita()) {
				this.IOConsole.mostraMessaggio("\n### Game Over: hai esaurito i cfu! ###");
				return true;
			} else {
				return false;
			}
		}
	}   

	private void aiuto() {
		this.IOConsole.mostraMessaggio("Comandi disponibili:");
		for(int i=0; i<elencoComandi.length; i++) 
			this.IOConsole.mostraMessaggio("["+elencoComandi[i]+"]");
		this.IOConsole.mostraMessaggio("\n");
	}

	private void vai(String direzione) {
		if(direzione==null) {
			this.IOConsole.mostraMessaggio("Dove vuoi andare?\n");
		} else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null) {
				this.IOConsole.mostraMessaggio("Direzione inesistente\n");
			} else {
				this.partita.setStanzaCorrente(prossimaStanza);
				this.partita.giocatore.scalaCfu();
				this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
				this.IOConsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}
		}
	}
	
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			this.IOConsole.mostraMessaggio("Cosa vuoi prendere?\n");
		} else {
			if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				if(this.partita.giocatore.getBorsa().entra(this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo))) {
					this.partita.giocatore.prendi(this.partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo));
					this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
					this.IOConsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
				} else this.IOConsole.mostraMessaggio("La tua borsa è troppo pesante\n");
			} else this.IOConsole.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente in questa stanza\n");
		}
	}
	
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			this.IOConsole.mostraMessaggio("Cosa vuoi posare?\n");
		} else {
			if(this.partita.getStanzaCorrente().entraQualcosa()) {
				if(this.partita.giocatore.getBorsa().hasAttrezzo(nomeAttrezzo)) {
					this.partita.getStanzaCorrente().addAttrezzo(this.partita.giocatore.getBorsa().removeAttrezzo(nomeAttrezzo));
					this.IOConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
					this.IOConsole.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
				} else this.IOConsole.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non c'è nella tua borsa\n");
			} else this.IOConsole.mostraMessaggio("Questa stanza è già piena!\n");
		}
	}

	private void fine() {
		this.IOConsole.mostraMessaggio("\n### Grazie per aver giocato! ###");
	}

	public static void main(String[] argc) {
		IOConsole IOConsole = new IOConsole();
		DiaDia gioco = new DiaDia(IOConsole);
		gioco.gioca();
	}

}