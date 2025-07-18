package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	private static final String NOME_DEFAULT = "Strega";
	private static final String PRESENTAZIONE_DEFAULT = "(¶) Faccio magie che ti portano in giro per il labirinto senza farti perdere preziosi CFU!\n"
												      + "(¶) Pensa che c'è addirittura chi si lamenta...\n";
	private static final String RISATA_MALEFICA = "(¶) Come ricompensa ti farò sentire la mia risata più malefica, HAHAHAHAHA!\n";
			
	public Strega() {
		this(NOME_DEFAULT, PRESENTAZIONE_DEFAULT);
	}
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		/* creo una lista delle possibili destinazioni che riempio con le stanze corrispondenti alle direzioni */
		List<Stanza> destinazioni = new ArrayList<Stanza>(partita.getStanzaCorrente().getDirezioni().values());
		/* ordino la lista definendo e creando un comparatore (per numero di attrezzi) usa e getta */
		Collections.sort(destinazioni, new Comparator<Stanza>() {
			/* here we are con la dichiarazione del comparatore come classe nidificata anonima */
			@Override
			public int compare(Stanza s1, Stanza s2) {
				return s1.getAttrezzi().size() - s2.getAttrezzi().size();
			}
		});
		if(this.isSalutato()) {
			Stanza destinazione = destinazioni.get(destinazioni.size()-1);
			partita.setStanzaCorrente(destinazione);
			return "(¶) Chi si rivede! Ti porterò in "+destinazione.getNome()+"... è piena di attrezzi utili per te!\n";
		} else {
			Stanza destinazione = destinazioni.get(0);
			partita.setStanzaCorrente(destinazione);
			return "(¶) E tu chi sei? Sparisci!\n";
		}
	}

	@Override
	public String riceviRegalo(Partita partita, Attrezzo attrezzo) {
		return RISATA_MALEFICA;
	}

}
