package it.uniroma3.forme;

public class GruppoDiForme implements Forma {	//adesso un gruppo di forme può essere considerato una forma anch'esso
	
	private static final int MAX_NUMERO_COMPONENTI = 5;
	private Forma[] componentiGruppo;
	
	public GruppoDiForme() {
		this(MAX_NUMERO_COMPONENTI);
	}
	
	public GruppoDiForme(int numeroComponenti) {
		this.componentiGruppo = new Forma[numeroComponenti];
	}

	public void trasla(int deltaX, int deltaY) {
		for(int i=0; i<this.componentiGruppo.length; i++) {
			if(this.componentiGruppo[i]!=null) {
				this.componentiGruppo[i].trasla(deltaX,deltaY);
			}
		}
	}
	
	public boolean aggiungiForma(Forma forma) {
		for(int i=0; i<this.componentiGruppo.length; i++) {
			if(this.componentiGruppo[i]==null) {
				this.componentiGruppo[i] = forma;
				return true;
			}
		}
		return false;
	}
	
	public int getNumeroComponenti() {
		int numeroComponenti = 0;
		for(int i=0; i<this.componentiGruppo.length; i++) {
			if(componentiGruppo[i]!=null)
				numeroComponenti++;
		}
		return numeroComponenti;
	}

}