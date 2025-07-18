package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;

public interface Comando {

	public void esegui(Partita partita);
	public void setParametro(String parametro);
	public void setConsole(IO console);
	public String getNome();
	public String getParametro();

}