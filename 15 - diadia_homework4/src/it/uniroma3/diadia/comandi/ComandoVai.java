package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(super.getParametro()==null) {
			this.console.mostraMessaggio("Dove vuoi andare?\n");
		} else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(super.getParametro());
			if (prossimaStanza==null) {
				this.console.mostraMessaggio("Direzione inesistente\n");
			} else {
				partita.setStanzaCorrente(prossimaStanza);
				partita.giocatore.scalaCfu();
			}
		}
	}

}
