package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private Attrezzo attrezzo;
	private static final String NOME_DEFAULT = "Mago";
	private static final String PRESENTAZIONE_DEFAULT = "(¶) Quando incontro qualcuno di simpatico, gli regalo un bell'attrezzo!\n";
	private static final String MESSAGGIO_DONO = "(¶) Sei un vero simpaticone, con una mia magica azione troverai un nuovo oggetto per il tuo borsone!\n";
	private static final String MESSAGGIO_SCUSE = "(¶) Mi dispiace, ma non ho piu' nulla da donarti...\n";
	private static final String MESSAGGIO_SOSPETTO = "(¶) ...ci conosciamo?\n";
	private static final String MESSAGGIO_REGALO = "(¶) Ma che gentile, non dovevi disturbarti! Vediamo cosa ci posso fare... ecco!\n";

	public Mago(Attrezzo attrezzo) {
		this(NOME_DEFAULT, PRESENTAZIONE_DEFAULT, attrezzo);
	}
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		if(this.isSalutato()) {
			if(this.attrezzo!=null) {
				partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
				this.attrezzo = null;
				return MESSAGGIO_DONO;
			} else return MESSAGGIO_SCUSE;
		}
		return MESSAGGIO_SOSPETTO;
	}

	@Override
	public String riceviRegalo(Partita partita, Attrezzo attrezzo) {
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo(attrezzo.getNome(),attrezzo.getPeso()/2));
		return MESSAGGIO_REGALO;
	}

}
