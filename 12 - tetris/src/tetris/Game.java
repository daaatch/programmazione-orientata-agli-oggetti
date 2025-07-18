package tetris;

import static java.lang.Math.exp;
import static java.lang.Math.max;
import static tetris.Costanti.*;

import java.util.HashSet;
import java.util.Set;

import tetris.pozzo.Cella;
import tetris.pozzo.Posizione;
import tetris.pozzo.Pozzo;
import tetris.tetramino.Blocco;
import tetris.tetramino.Tetramino;
import tetris.tetramino.Factory;

public class Game {

	final private Pozzo pozzo;

	final private Factory factory;

	private Tetramino tetramino; // pezzo correntemente in caduta nel pozzo

	private long punteggio;

	public Game() {
		this.factory = new Factory();
		this.pozzo = new Pozzo();
		this.punteggio = 0;
		this.tetramino = this.generaNuovoPezzoCasuale(); // tetramino iniziale
	}


	/**
	 * Ruota il tetramino corrente
	 * 
	 * @param delta - ad es.: +1 orario ; -1 antiorario
	 */
	public void ruota(int delta) {		
		this.tetramino.ruota(delta);
		if (inCollisione()) {
			this.tetramino.ruota(-delta);
		}
	}

	/**
	 * Sposta il tetramino corrente orizzontalmente
	 * @param dx - ad. es. +1 destra ; -1 sinistra
	 */
	public void sposta(int dx) {
		// prova lo spostamento ma...
		this.tetramino.trasla(dx,0);
		if (inCollisione()) {
			// ...annullalo se impossibilitato
			this.tetramino.trasla(-dx,0);
		}
	}

	/**
	 * lascia cadere di una sola riga il tetramino corrente
	 */
	public void lasciaCadere() {
		// prova lo spostamento ma...
		this.tetramino.trasla(0,+1);
		if (inCollisione()) {
			// ...annullalo se impossibilitato
			this.tetramino.trasla(0,-1);		
			int numLineeRimosse = fermaCaduta();
			aggiornaPunteggio(numLineeRimosse);
			this.tetramino = generaNuovoPezzoCasuale();
			controllaGameOver();
		}	
	}

	private void aggiornaPunteggio(int numRigheCompleteRimosse) {
		switch (numRigheCompleteRimosse) {
		case 1:
			aumentaPunteggio(PUNTI_X1_RIGA);
			break;
		case 2:
			aumentaPunteggio(PUNTI_X2_RIGHE);
			break;
		case 3:
			aumentaPunteggio(PUNTI_X3_RIGHE);
			break;
		case 4: // TETRIS !
			aumentaPunteggio(PUNTI_X4_RIGHE);
			break;
		}
	}

	private void controllaGameOver() {
		if (inCollisione()) 
			this.gameOver();		
	}                  

	/**
	 * @return un {@link Tetramino} casuale
	 */
	public Tetramino generaNuovoPezzoCasuale() {
		return this.factory.nuovoPezzoAcaso();
	}

	/**
	 * 
	 * @return il {@link Tetramino} che sta cadendo in questo momento dentro il {@link Pozzo}
	 * 
	 */
	public Tetramino getCorrente() {
		return this.tetramino;
	}

	/**
	 * Aumenta il punteggio della partita corrente
	 * @param delta 
	 */
	public void aumentaPunteggio(int delta) {
		this.punteggio += delta;
	}

	/**
	 * 
	 * @return punteggio corrente
	 */
	public long getPunteggio() {
		return this.punteggio;
	}

	/**
	 * 
	 * @return livello corrente
	 */
	public long getLivello() {
		return getPunteggio() / PUNTI_PER_LIVELLO ;
	}

	public Pozzo getPozzo() {
		return this.pozzo;
	}
	
	/**
	 * Termina la partita corrente stampando il punteggio finale da console
	 */
	public void gameOver() {
		System.out.println("Punteggio finale: "+this.getPunteggio());
		System.exit(-1);
	}

	
	/**
	 * 
	 * @return tempo in millisecondi che intercorre tra due spostamenti automatici
	 */
	public int getRitmo() {
		// ad. es punteggio = 100 : livello = 0 ; ritmo = 1000;
		return (int)max(TEMPO_BASE_MIN, TEMPO_BASE * exp((double)-getLivello() / RITMO));
	}

	/**
	 * 
	 * @return true se e solo se il tetramino corrente 
	 *              occupa un cella già occupata
	 */
	private boolean inCollisione() {
		for (final Cella c : getCelleDelTetramino()) {
			if (this.pozzo.contiene(c)) return true;
		}
		return false;
	}

	
	/**
	 * Ferma la caduta del pezzo nel pozzo decomponendo
	 * i suoi {@link Blocco} in {@link Cella} del {@link Pozzo}
	 * 
	 * @return il numero di righe complete eliminate
	 */
	private int fermaCaduta() {
		final Set<Cella> celle = getCelleDelTetramino();
		return this.pozzo.aggiungiCelleErimuoviRigheCompletate(celle);
	}

	/**
	 * 
	 * @return l'insieme di {@link Cella} occupate dai {@link Blocco} del {@link Tetramino} 
	 */
	public Set<Cella> getCelleDelTetramino() { 
		final Tetramino tetramino = this.getCorrente();
		final Set<Cella> celle = new HashSet<>();
		
		for(Posizione finale : tetramino.getPosizioneDeiBlocchi()) {
			/* le celle di un tetramino prendono il suo colore */
			celle.add(new Cella(finale, tetramino.getColore()));
		}
		
		return celle;
	}
}
