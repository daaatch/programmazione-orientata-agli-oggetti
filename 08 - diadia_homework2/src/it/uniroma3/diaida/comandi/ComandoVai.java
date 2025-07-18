package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		if(direzione==null) {
			this.console.mostraMessaggio("Dove vuoi andare?\n");
		} else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza==null) {
				this.console.mostraMessaggio("Direzione inesistente\n");
			} else {
				partita.setStanzaCorrente(prossimaStanza);
				partita.giocatore.scalaCfu();
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public void setConsole(IO console) {
		this.console = console;		
	}

	@Override
	public String getNome() {
		return "Vai";
	}

	@Override
	public String getParametro() {
		return direzione;
	}

}