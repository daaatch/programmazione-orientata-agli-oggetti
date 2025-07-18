package tetris.tetramino;

/**
 * Modella i blocchi che compongono i {@link Tetramino}
 * e che diventano {@link Cella} una volta nel {@link Pozzo}.
 * <BR/>
 * Conserva la posizione relativa (dx e dy) rispetto alla posizione
 * del {@link Tetramino} di cui fa parte.
 */
public class Blocco {

	private int dx;
	
	private int dy;

	public Blocco(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	/**
	 * @return ascissa relativa del blocco (dx)
	 */
	public int getDX() {
		return this.dx;
	}

	/**
	 * @return ordinata relativa del blocco (dy)
	 */
	public int getDY() {
		return this.dy;
	}

}
