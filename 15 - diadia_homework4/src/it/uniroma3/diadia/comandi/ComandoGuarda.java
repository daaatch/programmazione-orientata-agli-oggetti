package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio(partita.getStanzaCorrente().toString());
		this.console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		this.console.mostraMessaggio("(§) Crediti residui: "+partita.getGiocatore().getCfu()+" cfu\n");
	}

}
