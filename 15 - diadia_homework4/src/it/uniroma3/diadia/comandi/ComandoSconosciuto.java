package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSconosciuto extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Comando Sconosciuto\n");
	}

}
