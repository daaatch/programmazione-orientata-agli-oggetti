package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzo_luminoso;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.setAttrezzoLuminoso(attrezzo);
	}
	
	public void setAttrezzoLuminoso(String attrezzo) {
		this.attrezzo_luminoso = attrezzo;
	}
	
	public String getAttrezzoLuminoso() {
		return this.attrezzo_luminoso;
	}
	
	@Override
	public String getDescrizione() {
		if(this.getAttrezzoLuminoso()==null)
			return "(§) Questo posto resterà buio per sempre.\n";
		else if(this.hasAttrezzo(this.getAttrezzoLuminoso()))
				return super.getDescrizione();
			 else return "(§) Ci sta un buio pesto qua dentro...\n" + 
					     "(§) Procurati "+this.getAttrezzoLuminoso()+" per vedere qualcosa\n";
	}
	
}
