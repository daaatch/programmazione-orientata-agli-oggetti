package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando {
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(super.getParametro()==null) {
			this.console.mostraMessaggio("Cosa vuoi posare?\n");
		} else {
			if(partita.getStanzaCorrente().entraQualcosa()) {
				if(partita.giocatore.getBorsa().hasAttrezzo(super.getParametro())) {
					partita.getStanzaCorrente().addAttrezzo(partita.giocatore.getBorsa().removeAttrezzo(super.getParametro()));
				} else this.console.mostraMessaggio("L'attrezzo "+super.getParametro()+" non c'è nella tua borsa\n");
			} else this.console.mostraMessaggio("Questa stanza è già piena!\n");
		}
	}

}
