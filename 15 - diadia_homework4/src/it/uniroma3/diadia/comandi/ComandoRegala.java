package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoRegala extends AbstractComando {

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(this.parametro==null) {
			this.console.mostraMessaggio("Cosa vuoi regalare?\n");
		} else {
			if(partita.getStanzaCorrente().hasPersonaggio()) {
				if(partita.getGiocatore().getBorsa().hasAttrezzo(this.parametro)) {
					this.console.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(partita,partita.getGiocatore().getBorsa().removeAttrezzo(parametro)));
				} else this.console.mostraMessaggio("L'attrezzo "+this.parametro+" non è presente nella borsa!\n");
			} else this.console.mostraMessaggio("Non c'è nessuno al quale puoi fare regali in questa stanza!\n");
		}
	}

}
