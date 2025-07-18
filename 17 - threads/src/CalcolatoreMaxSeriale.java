import java.util.NoSuchElementException;

public class CalcolatoreMaxSeriale implements CalcolatoreMax {
	
	@Override
	public int calcolaMax(int[] array) {
		return calcolaMaxArray(array, 0, array.length);
	}
	
	public int calcolaMaxArray(int[] array, int inizio, int fine) {
		
		if(fine-inizio==0)
			throw new NoSuchElementException();
		
		int max = array[inizio];
		
		for(int i=inizio+1; i<fine; i++) 
			if(array[i]>max)
				max = array[i];
		
		return max;
	}

}
