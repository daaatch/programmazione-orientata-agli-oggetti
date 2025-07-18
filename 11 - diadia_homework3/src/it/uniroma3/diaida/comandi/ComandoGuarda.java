package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.IO;
import it.uniroma3.diaida.Partita;

public class ComandoGuarda implements Comando {

	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio(partita.getStanzaCorrente().toString());
		this.console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		this.console.mostraMessaggio("(§) Crediti residui: "+partita.getGiocatore().getCfu()+" cfu\n");
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
		return "Guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}