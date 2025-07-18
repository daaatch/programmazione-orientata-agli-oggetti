package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {

	protected IO console;
	protected String parametro;
	
	public void setConsole(IO console) {
		this.console = console;
	}
		
	public void setParametro(String parametro) {	}
	
	public String getParametro() {
		return this.parametro;
	}

	public String getNome() {
		int i = this.getClass().getCanonicalName().indexOf("Comando");
		return this.getClass().getCanonicalName().substring(i+7);
	}

	public abstract void esegui(Partita partita);
	
}
