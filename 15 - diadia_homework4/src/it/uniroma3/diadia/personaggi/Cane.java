package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private boolean addomesticato;
	private static final String NOME_DEFAULT = "Cane";
	private static final String PRESENTAZIONE_DEFAULT = "(¶) Se porti con te un bell'osso sarò il tuo migliore amico per sempre!\n"
													  + "(¶) Altrimenti non provare neanche ad avvicinarti...\n";
	private static final String MESSAGGIO_ADDOMESTICATO = "(¶) Ma che bontà quest'osso prelibato!\n";
	private static final String MESSAGGIO_ABBAIO = "(¶) Ciao! Ehm, volevo dire... Bau!\n";
	private static final String MESSAGGIO_SCONTENTO = "(¶) Ma che è sta schifezza?! Verrai morso e perderai un bel CFU!\n";
	private static final String MESSAGGIO_MORSO = "(¶) Vedo che non ti sei portato nulla per me... Verrai morso e perderai un bel CFU!\n";
	
	public Cane() {
		this(NOME_DEFAULT, PRESENTAZIONE_DEFAULT);
	}
	
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
		this.addomesticato = false;
	}

	@Override
	public String agisci(Partita partita) {
		if(this.addomesticato)
			return MESSAGGIO_ABBAIO;
		else return this.mordi(partita);
	}
	
	public String mordi(Partita partita) {
		partita.getGiocatore().scalaCfu();
		return MESSAGGIO_MORSO;
	}
	
	public String riceviRegalo(Partita partita, Attrezzo attrezzo) {
		if(attrezzo.getNome().equals("osso")) {
			this.addomesticato = true;
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collana",4));
			return MESSAGGIO_ADDOMESTICATO;
		} else {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.mordi(partita);
			return MESSAGGIO_SCONTENTO;
		}
	}

}
