package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;

public class ComandoFine implements Comando {

	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("\n*** Grazie per aver giocato! ***");
	}

	@Override
	public void setParametro(String parametro) {
		// questo comando non prende nessun parametro
	}

	@Override
	public void setConsole(IO console) {
		this.console = console;
	}

	@Override
	public String getNome() {
		return "Fine";
	}

	@Override
	public String getParametro() {
		return null;
	}

}