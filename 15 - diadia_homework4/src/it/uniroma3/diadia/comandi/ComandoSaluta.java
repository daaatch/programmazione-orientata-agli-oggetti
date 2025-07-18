package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().hasPersonaggio()) {
			this.console.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		} else {
			this.console.mostraMessaggio("Non c'è nessuno da salutare qui!\n");
		}
	}

}
