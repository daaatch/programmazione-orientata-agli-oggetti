package tetris.tetramino;

import static java.awt.Color.blue;
import static java.awt.Color.cyan;
import static java.awt.Color.green;
import static java.awt.Color.orange;
import static java.awt.Color.pink;
import static java.awt.Color.red;
import static java.awt.Color.yellow;

import java.awt.Color;
/**
 * 
 * @see https://it.wikipedia.org/wiki/Tetramino
 */
public enum Tipo {
    /* nome(colore,
     * 	tetramino(blocco(x0,y0),...,blocco(x3,y3)) rotazione 0;
     *  ...                     ...                     ...
     * 	tetramino(blocco(x0,y0),...,blocco(x3,y3)) rotazione 3; 
     */
	I(cyan,
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(3, 1)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(1, 2), blocco(1, 3)),
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(3, 1)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(1, 2), blocco(1, 3))),
	J(blue,	
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(2, 0)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(1, 2), blocco(2, 2)),
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(0, 2)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(1, 2), blocco(0, 0))),
	L(orange, 
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(2, 2)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(1, 2), blocco(0, 2)),
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(0, 0)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(1, 2), blocco(2, 0))),
	O(yellow,
			tetramino(blocco(0, 0), blocco(0, 1), blocco(1, 0), blocco(1, 1)),
			tetramino(blocco(0, 0), blocco(0, 1), blocco(1, 0), blocco(1, 1)),
			tetramino(blocco(0, 0), blocco(0, 1), blocco(1, 0), blocco(1, 1)),
			tetramino(blocco(0, 0), blocco(0, 1), blocco(1, 0), blocco(1, 1))),
	S(green, 
			tetramino(blocco(1, 0), blocco(2, 0), blocco(0, 1), blocco(1, 1)),
			tetramino(blocco(0, 0), blocco(0, 1), blocco(1, 1), blocco(1, 2)),
			tetramino(blocco(1, 0), blocco(2, 0), blocco(0, 1), blocco(1, 1)),
			tetramino(blocco(0, 0), blocco(0, 1), blocco(1, 1), blocco(1, 2))),			
	T(pink, 
			tetramino(blocco(1, 0), blocco(0, 1), blocco(1, 1), blocco(2, 1)),
			tetramino(blocco(1, 0), blocco(0, 1), blocco(1, 1), blocco(1, 2)),
			tetramino(blocco(0, 1), blocco(1, 1), blocco(2, 1), blocco(1, 2)),
			tetramino(blocco(1, 0), blocco(1, 1), blocco(2, 1), blocco(1, 2))),
	Z(red, 
			tetramino(blocco(0, 0), blocco(1, 0), blocco(1, 1), blocco(2, 1)),
			tetramino(blocco(1, 0), blocco(0, 1), blocco(1, 1), blocco(0, 2)),
			tetramino(blocco(0, 0), blocco(1, 0), blocco(1, 1), blocco(2, 1)),
			tetramino(blocco(1, 0), blocco(0, 1), blocco(1, 1), blocco(0, 2)));

	static private Blocco blocco(int dx, int dy) { return new Blocco(dx,dy); }

	static private Blocco[] tetramino(Blocco...blocchi) { return blocchi; }

	private Color colore;

	private Blocco[][] blocchi;
	
	private Tipo(Color colore, Blocco[]... blocchi) {
		this.colore = colore;
		this.blocchi = blocchi;
	}

	public Color getColore() {
		return this.colore;
	}

	public Blocco[][] getBlocchi() {
		return this.blocchi;
	}

}
