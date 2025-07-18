package tetris.pozzo;

/**
 * Rappresenta una posizione, modellata come coppia di interi 
 * ascissa (x) ed ordinata (y), all'interno del {@link Pozzo}.
 * 
 */
public class Posizione implements Comparable<Posizione> {

	private int x;
	
	private int y;
	
	public Posizione(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	/**
	 * Crea un oggetto {@link Posizione} traslato rispetto all'originale.
	 * 
	 * @param dx - delta sull'ascissa  della posizione corrente
	 * @param dy - delta sull'ordinata della posizione corrente
	 * @return il nuovo oggetto {@link Posizione} traslato
	 */
	public Posizione traslata(int dx, int dy) {
		return new Posizione(getX()+dx, getY()+dy);
	}

	@Override
	public String toString() {
		return "("+getX()+","+getY()+")";
	}
	
	@Override
	public int hashCode() {
		return 17 + this.x + this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Posizione that = (Posizione)obj;
		return (this.getX()==that.getX())&&(this.getY()==that.getY());
	}

	@Override
	public int compareTo(Posizione obj) {
		int dx = this.x - obj.getX();
		if(dx!=0)
			return dx;
		return this.y - obj.getY();
	}
	
}