package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;

public class ComandoPosa implements Comando {

	private String attrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		if(attrezzo==null) {
			this.console.mostraMessaggio("Cosa vuoi posare?\n");
		} else {
			if(partita.getStanzaCorrente().entraQualcosa()) {
				if(partita.giocatore.getBorsa().hasAttrezzo(attrezzo)) {
					partita.getStanzaCorrente().addAttrezzo(partita.giocatore.getBorsa().removeAttrezzo(attrezzo));
				} else this.console.mostraMessaggio("L'attrezzo "+attrezzo+" non c'è nella tua borsa\n");
			} else this.console.mostraMessaggio("Questa stanza è già piena!\n");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

	@Override
	public void setConsole(IO console) {
		this.console = console;
	}

	@Override
	public String getNome() {
		return "Posa";
	}

	@Override
	public String getParametro() {
		return attrezzo;
	}

}