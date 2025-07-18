package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	@Override
	@SuppressWarnings("deprecation")
	public AbstractComando costruisciComando(String istruzione, IO console) {
		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;
		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();		
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");	//appendo nome package+"Comando"
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));				   //appendo la prima lettera in UpperCase (0)
			nomeClasse.append(nomeComando.substring(1));									  //appendo la restante sottostringa (1..)	
			comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();	
		} catch (NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			comando = new ComandoSconosciuto();
		}
		comando.setParametro(parametro);
		comando.setConsole(console);
		return comando;
	}

}
