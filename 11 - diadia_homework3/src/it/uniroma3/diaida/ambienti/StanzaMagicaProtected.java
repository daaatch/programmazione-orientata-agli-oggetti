package it.uniroma3.diaida.ambienti;

import it.uniroma3.diaida.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int sogliaMagica;
	private int contatoreAttrezziPosati;
	
	public StanzaMagicaProtected(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			this.contatoreAttrezziPosati++;
			if(this.contatoreAttrezziPosati>this.sogliaMagica)
				attrezzo = incantaAttrezzo(attrezzo);
	    	this.attrezzi.put(attrezzo.getNome(),attrezzo);
	    	return true;
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