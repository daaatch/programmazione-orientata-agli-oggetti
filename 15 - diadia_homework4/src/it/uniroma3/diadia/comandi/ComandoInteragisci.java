package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoInteragisci extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().hasPersonaggio()) {
			this.console.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().agisci(partita));
		} else {
			this.console.mostraMessaggio("Non c'è nessuno con cui interagire qui!\n");
		}
	}

}
