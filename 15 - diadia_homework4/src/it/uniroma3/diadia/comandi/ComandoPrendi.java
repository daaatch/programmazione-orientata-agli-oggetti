package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPrendi extends AbstractComando {

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(super.getParametro()==null) {
			this.console.mostraMessaggio("Cosa vuoi prendere?\n");
		} else {
			if(partita.getStanzaCorrente().hasAttrezzo(super.getParametro())) {
				if(partita.giocatore.getBorsa().entra(partita.getStanzaCorrente().getAttrezzo(super.getParametro()))) {
					partita.giocatore.prendi(partita.getStanzaCorrente().removeAttrezzo(super.getParametro()));
				} else this.console.mostraMessaggio("La tua borsa è troppo pesante\n");
			} else this.console.mostraMessaggio("L'attrezzo "+super.getParametro()+" non è presente in questa stanza\n");
		}
	}

}
