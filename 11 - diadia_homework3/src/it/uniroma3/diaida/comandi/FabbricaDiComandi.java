package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.IO;

public interface FabbricaDiComandi {

	public Comando costruisciComando(String istruzione, IO console);
	
}