package tetris;

import static java.awt.Color.GRAY;

import java.awt.Color;

public interface Costanti {


	static final public int TEMPO_BASE_MIN = 100;
	
	static final public int TEMPO_BASE = 1000;
	
	static final public int RITMO = 2; // deve essere>0; 1 MAX velocità	

	static final public int PUNTI_PER_LIVELLO = 100;

	static final public int PUNTI_X1_RIGA = 100;

	static final public int PUNTI_X2_RIGHE = 300;

	static final public int PUNTI_X3_RIGHE = 500;

	static final public int PUNTI_X4_RIGHE = 800;

	// dimensione in px di una cella
	static final public int DIM_CELLE = 30;

	static final public Color COLORE_BORDO = GRAY;
	
}
