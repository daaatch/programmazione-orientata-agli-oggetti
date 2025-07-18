package battlefield;

public class Position implements Comparable<Position> {
	
	private int x,y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return "("+this.x+"-"+this.y+")";
	}

	@Override
	public boolean equals(Object obj) {
		Position that = (Position) obj;
		return ((this.getX()==that.getX())&&(this.getY()==that.getY()));
	}
	
	@Override
	public int hashCode() {
		return (this.getX()+this.getY()+17);
	}

	@Override
	public int compareTo(Position that) {
		if((this.getX()-that.getX())!=0)
			return this.getX()-that.getX();
		return this.getY()-that.getY();
	}
	
}
