package it.uniroma3.diaida.ambienti;

import it.uniroma3.diaida.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int soglia_magica;
	private int contatore_attrezzi_posati;
	
	public StanzaMagica(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.soglia_magica = soglia;
		this.contatore_attrezzi_posati = 0;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			this.contatore_attrezzi_posati++;
			if(this.contatore_attrezzi_posati>this.soglia_magica)
				attrezzo = incantaAttrezzo(attrezzo);
			return super.addAttrezzo(attrezzo);
		} else return false;
	}
	
	private Attrezzo incantaAttrezzo(Attrezzo attrezzo) {
		int pesoDoppio = attrezzo.getPeso()*2;
		StringBuilder nomeInvertito;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo.setNome(nomeInvertito.toString());
		attrezzo.setPeso(pesoDoppio);
		return attrezzo;
	}
	
}