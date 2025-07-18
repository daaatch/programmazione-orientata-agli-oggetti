package it.uniroma3.diadia.fixture;

import it.uniroma3.diaida.DiaDia;
import it.uniroma3.diaida.IOSimulator;
import it.uniroma3.diaida.ambienti.Stanza;
import it.uniroma3.diaida.attrezzi.Attrezzo;

public class Fixture {

	public static IOSimulator creaSimulazionePartitaEGioca(String... righeDaLeggere) {
		IOSimulator io = new IOSimulator();
		io.setInput(righeDaLeggere);
		new DiaDia(io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEMettiInStanza(Stanza stanza, String nome, int peso) {
		Attrezzo attrezzo = new Attrezzo(nome,peso);
		stanza.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
}
