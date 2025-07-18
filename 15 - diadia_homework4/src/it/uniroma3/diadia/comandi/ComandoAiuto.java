package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"aiuto","fine","guarda","interagisci","posa","prendi","regala","saluta","vai"};
	
	//TODO: fornire l'elenco dei comandi disponibili tramite riflessione sul package it.uniroma3.diadia.comandi.Comando(...)
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Comandi disponibili:");
		for(int i=0; i<elencoComandi.length; i++) 
			this.console.mostraMessaggio("["+elencoComandi[i]+"]");
		this.console.mostraMessaggio("\n");
	}

}
