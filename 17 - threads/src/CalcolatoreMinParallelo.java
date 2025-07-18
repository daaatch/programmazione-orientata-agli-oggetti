
public class CalcolatoreMinParallelo implements CalcolatoreMin {

	final private CalcolatoreMinSeriale calcolatore = new CalcolatoreMinSeriale();
	
	@Override
	public int calcolaMin(final int[] array) {
		
		final int numeroCore = Runtime.getRuntime().availableProcessors();
		
		final int[] minimiRelativi = new int[numeroCore];
		
		final Thread[] threads = new Thread[numeroCore];
		
		final int porzione = array.length/numeroCore;
		final int sfrido = array.length%numeroCore;
		int inizioPorzione = 0;
		
		for(int i=0; i<numeroCore; i++) {
			
			final int indice = i;
			final int inizio = inizioPorzione;
			final int fine;
			if(i<sfrido) fine = inizio+porzione+1;
			else fine = inizio+porzione;
			
			threads[indice] = new Thread(new Runnable() {
				@Override
				public void run() {
					minimiRelativi[indice]=calcolatore.calcolaMinArray(array,inizio,fine);
				}			
			});		
			threads[indice].start();
			inizioPorzione = fine;		
		}
		
		for(int i=0; i<numeroCore; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
		}
		
		return calcolatore.calcolaMin(minimiRelativi);
		
	}

}
