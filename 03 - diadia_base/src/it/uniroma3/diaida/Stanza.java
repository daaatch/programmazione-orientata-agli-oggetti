package it.uniroma3.diaida;

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome; 
	private String[] direzioni;
	private Stanza[] stanzeAdiacenti;
	private Attrezzo[] attrezzi;
	private int numeroStanzeAdiacenti;
    private int numeroAttrezzi;
	
    public Stanza(String nome) {
        this.nome = nome;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
    }

    public String getNome() {
        return this.nome;
    }
   
    public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }
	
    public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
        	if (this.direzioni[i].equals(direzione))
        		stanza = this.stanzeAdiacenti[i];
        return stanza;
	}
    
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }
	
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}
    
    public String getDescrizione() {
        return this.toString();
    }
 
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
    	for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) {
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni[numeroStanzeAdiacenti] = direzione;
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
    		    this.numeroStanzeAdiacenti++;
    		}
    }
    
    public String getDirezioneOpposta(String direzione) {
    	String opposto = "";
    	if (direzione=="nord") opposto = "sud";
    	if (direzione=="sud") opposto = "nord";
    	if (direzione=="ovest") opposto = "est";
    	if (direzione=="est") opposto = "ovest";
    	return opposto;
    }
    
    public void collegaStanze(String direzione, Stanza stanza) {
    	this.impostaStanzaAdiacente(direzione, stanza);
    	stanza.impostaStanzaAdiacente(getDirezioneOpposta(direzione), this);
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
    	boolean aggiunto = false;
    	if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
    		for (int i=0; i<NUMERO_MASSIMO_ATTREZZI; i++) {
    			if ((this.attrezzi[i]==null)&&(!aggiunto)) {
    				this.attrezzi[i] = attrezzo;
	    			this.numeroAttrezzi++;
	    			aggiunto = true;
    			}
    		}
        } 
    	return aggiunto;
    }
	
    public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean rimosso = false;
		if (this.hasAttrezzo(attrezzo.getNome())) {
			for (int i=0; i<NUMERO_MASSIMO_ATTREZZI; i++) {
				if (this.attrezzi[i].equals(attrezzo)) {
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
					rimosso = true;
				}
			}
		}
		return rimosso;
	}
	
    public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
			}
		return trovato;
	}

    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("(§) Posizione attuale: "+this.nome);
    	risultato.append("\n(§) Uscite:");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append("["+direzione+"]");
    	risultato.append("\n(§) Attrezzi nella stanza:");
    	if (this.numeroAttrezzi==0) {
    		risultato.append(" nessuno");
    	} else {
    		for (Attrezzo attrezzo : this.attrezzi) {
    			if (attrezzo!=null)
    				risultato.append("["+attrezzo.toString()+"]");
    		}
    	}
    	return risultato.toString();
    }
    
}