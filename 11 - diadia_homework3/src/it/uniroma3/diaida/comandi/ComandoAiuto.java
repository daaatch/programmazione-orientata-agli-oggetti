package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai","guarda","prendi","posa","aiuto","fine"};
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Comandi disponibili:");
		for(int i=0; i<elencoComandi.length; i++) 
			this.console.mostraMessaggio("["+elencoComandi[i]+"]");
		this.console.mostraMessaggio("\n");
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
		return "Aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

}