import java.util.NoSuchElementException;

public class CalcolatoreMinSeriale implements CalcolatoreMin {

	@Override
	public int calcolaMin(int[] array) {
		return calcolaMinArray(array, 0, array.length);
	}
	
	public int calcolaMinArray(int[] array, int inizio, int fine) {
		if(fine-inizio==0)
			throw new NoSuchElementException();
		int min=array[inizio];
		for(int i=inizio+1; i<fine; i++) {
			if(array[i]<min)
				min=array[i];
		}
		return min;
	}

}
