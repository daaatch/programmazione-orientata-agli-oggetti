package it.uniroma3.diaida.comandi;

import it.uniroma3.diaida.Partita;
import it.uniroma3.diaida.IO;

public class ComandoPrendi implements Comando {

	private String attrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		if(this.attrezzo==null) {
			this.console.mostraMessaggio("Cosa vuoi prendere?\n");
		} else {
			if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
				if(partita.giocatore.getBorsa().entra(partita.getStanzaCorrente().getAttrezzo(attrezzo))) {
					partita.giocatore.prendi(partita.getStanzaCorrente().removeAttrezzo(attrezzo));
				} else this.console.mostraMessaggio("La tua borsa è troppo pesante\n");
			} else this.console.mostraMessaggio("L'attrezzo "+attrezzo+" non è presente in questa stanza\n");
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
		return "Prendi";
	}

	@Override
	public String getParametro() {
		return attrezzo;
	}

}