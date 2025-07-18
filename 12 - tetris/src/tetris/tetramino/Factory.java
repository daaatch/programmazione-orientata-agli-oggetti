package tetris.tetramino;

import java.util.Random;

import tetris.pozzo.Posizione;
import static tetris.tetramino.Tetramino.MAX_ROTAZIONI;
import static tetris.pozzo.Pozzo.LARGHEZZA;

/**
 * Fabbrica di pezzi a {@link Tetramino} scelti casualmente
 */
public class Factory {

	static final private int MAX_NUM_TETRAMINI = Tipo.values().length;
	
	static final private Posizione POSIZIONE_INIZIALE_NUOVI_TETRAMINI = 
			new Posizione( (LARGHEZZA-2)/2, 2 );

	final private Random random;
	
	public Factory() {
		this.random = new Random();
	}
	
	/**
	 * @return un nuovo {@link Tetramino} il cui tipo e la cui rotazione
	 *         sono scelti scelti casualmente
	 */
	public Tetramino nuovoPezzoAcaso() {
		return new Tetramino(
				POSIZIONE_INIZIALE_NUOVI_TETRAMINI, 
				rotazioneAcaso(), 
				tipoAcaso()
		);
	}

	private int rotazioneAcaso() {
		return this.random.nextInt(MAX_ROTAZIONI);
	}

	private Tipo tipoAcaso() {
		return Tipo.values()[this.random.nextInt(MAX_NUM_TETRAMINI)];
	}
	
}
