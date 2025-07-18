package battlefield;

import java.util.Comparator;

public class ComparatorePerPosizione implements Comparator<Robot> {

	@Override
	public int compare(Robot r1, Robot r2) {
		return r1.getPosizione().compareTo(r2.getPosizione());
	}

}
