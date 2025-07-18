package tetris.tetramino;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import tetris.pozzo.Posizione;

public class Tetramino {

	static final public int MAX_ROTAZIONI = 4;
	
	private Posizione posizione; // del tetramino

	private int rotazione; // 0,1,2,3 %MAX_ROTAZIONI

	/**
	 * @see {@link Tipo}
	 */
	private Tipo tipo;
	
	public Tetramino(Posizione posizione, int rotazione, Tipo tipo) {
		this.posizione = posizione;
		this.rotazione = rotazione;
		this.tipo = tipo;
	}
	
	/**
	 * @return la {@link Posizione} di questo {@link Tetramino}
	 */
	public Posizione getPosizione() {
		return this.posizione;
	}

	/**
	 * @return l'indice di rotazione corrente:  0&leq;indice&lt;4 
	 */
	public int getRotazione() {
		return this.rotazione;
	}

	/**
	 * 
	 * @return il {@link Tipo} di questo {@link Tetramino}
	 */
	public Tipo getTipo() {
		return this.tipo;
	}

	/**
	 * @return i 4 blocchi corrispondenti alla rotazione corrente del {@link Tetramino}
	 */
	public Blocco[] getBlocchi() { 
		return this.getTipo().getBlocchi()[this.getRotazione()];
	}

	/**
	 * 
	 * @return il {@link Color}e del  {@link Tetramino}
	 */
	public Color getColore() {
		return getTipo().getColore();
	}


	/**
	 * Ruota un pezzo in senso orario
	 * @param delta - della rotazione
	 */
	public void ruota(int delta) {
		this.rotazione = ( this.rotazione + delta + MAX_ROTAZIONI) % MAX_ROTAZIONI ;
	}
	
	
	/**
	 * Trasla la posizione di questo  {@link Tetramino}
	 * @param dx
	 * @param dy
	 */
	public void trasla(int dx, int dy) {
		this.posizione = this.posizione.traslata(dx, dy);
	}

	/**
	 * 
	 * @return l'insieme delle posizioni occupate dai 4 {@link Blocco}
	 *         di questo {@link Tetramino}
	 */
	public Set<Posizione> getPosizioneDeiBlocchi() {
		final Set<Posizione> posizioni = new HashSet<>(4);
		for(Blocco blocco : this.getBlocchi())
			posizioni.add(this.getPosizione().traslata(blocco.getDX(), blocco.getDY()));
		return posizioni;
	}
	
	@Override
	public String toString() {
		return getTipo()+" "+getPosizione()+"/"+getRotazione();
	}
	
}
