package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;

public class ComandoSconosciuto implements Comando {

	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Comando Sconosciuto\n");
	}

	@Override
	public void setParametro(String parametro) {
		// non ho nessun parametro da prendere
	}

	@Override
	public void setConsole(IO console) {
		this.console = console;
	}

	@Override
	public String getNome() {
		return "Sconosciuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

}