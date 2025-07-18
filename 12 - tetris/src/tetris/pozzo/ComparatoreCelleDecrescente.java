package tetris.pozzo;

import java.util.Comparator;

public class ComparatoreCelleDecrescente implements Comparator<Cella> {

	@Override
	public int compare(Cella one, Cella two) {
		int dy = -(one.getPosizione().getY()-two.getPosizione().getY());
		if(dy!=0)
			return dy;
		return -(one.getPosizione().getX()-two.getPosizione().getX());
	}
	
}
