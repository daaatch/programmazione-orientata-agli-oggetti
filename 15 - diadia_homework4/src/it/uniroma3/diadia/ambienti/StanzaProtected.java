package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class StanzaProtected {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 5;
	
	private String nome; 
	private HashMap<String,StanzaProtected> direzioni;
	protected HashMap<String,Attrezzo> attrezzi;
	private int numeroDirezioni;
    protected int numeroAttrezzi;
    private AbstractPersonaggio personaggio;
	
    public StanzaProtected(String nome) {
    	this.nome = nome;
        this.direzioni = new HashMap<>();
        this.attrezzi = new HashMap<>();
        this.numeroDirezioni = 0;
        this.numeroAttrezzi = 0;
    }

    public StanzaProtected(String nome, AbstractPersonaggio personaggio) {
        this.nome = nome;
        this.direzioni = new HashMap<>();
        this.attrezzi = new HashMap<>();
        this.numeroDirezioni = 0;
        this.numeroAttrezzi = 0;
        this.personaggio = personaggio;
    }

    public String getNome() {
        return this.nome;
    }
    
    public AbstractPersonaggio getPersonaggio() {
    	return this.personaggio;
    }
    
    public void setPersonaggio(AbstractPersonaggio p) {
    	if(!this.hasPersonaggio())
    		this.personaggio = p;
    }
    
    public boolean hasPersonaggio() {
    	return this.personaggio!=null;
    }
    
    public boolean entraQualcosa() {
    	return (this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI);
    }
    
    public HashMap<String,StanzaProtected> getDirezioni() {
	    return this.direzioni;
    }
	
    public StanzaProtected getStanzaAdiacente(String direzione) {
        return this.direzioni.get(direzione);
	}
    
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
    
    public String getDescrizione() {
        return this.toString();
    }
 
    public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
        if(this.direzioni.containsKey(direzione))
        	this.direzioni.replace(direzione,stanza);
        if(this.numeroDirezioni<NUMERO_MASSIMO_DIREZIONI) {
        	this.direzioni.put(direzione, stanza);
        	this.numeroDirezioni++;
        }
    }
    
    public String getDirezioneOpposta(String direzione) {
    	if(direzione=="nord") return "sud";
    	if(direzione=="sud") return "nord";
    	if(direzione=="ovest") return "est";
    	if(direzione=="est") return "ovest";
    	return "";
    }
    
    public void collegaStanze(String direzione, StanzaProtected stanza) {
    	if((stanza!=null)&&(direzione!=null)) {
    		this.impostaStanzaAdiacente(direzione, stanza);
    		stanza.impostaStanzaAdiacente(getDirezioneOpposta(direzione), this);
    	}
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if((attrezzo==null)||(this.numeroAttrezzi==NUMERO_MASSIMO_ATTREZZI))
    		return false;
    	this.attrezzi.put(attrezzo.getNome(),attrezzo);
    	this.numeroAttrezzi++;
    	return true;
    }
	
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
    	if(this.hasAttrezzo(nomeAttrezzo)) 
    		return this.attrezzi.remove(nomeAttrezzo);
    	else return null;
    }
	
    public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

    public String direzioniToString() {
    	StringBuilder risultato = new StringBuilder();
    	for(Map.Entry<String,StanzaProtected> entry : direzioni.entrySet())
    		risultato.append("["+entry.getKey()+"]");
    	return risultato.toString();
    }

    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("(§) Posizione attuale: "+this.nome);
    	risultato.append("\n(§) Uscite:");
    	if(this.direzioniToString().equals(""))
    		risultato.append(" nessuna");
    	else risultato.append(this.direzioniToString());
    	risultato.append("\n(§) Attrezzi nella stanza:");
    	if(this.numeroAttrezzi==0)
    		risultato.append(" nessuno");
    	else for(Map.Entry<String,Attrezzo> entry : attrezzi.entrySet())
        		risultato.append("["+entry.getValue().toString()+"]");
    	risultato.append("\n(§) Personaggi nella stanza:");
    	if(this.hasPersonaggio())
    		risultato.append("["+this.getPersonaggio().toString()+"]");
    	else risultato.append(" nessuno");
    	risultato.append("\n");
    	return risultato.toString();
    }
    
}