
public class CalcolatoreMaxParallelo implements CalcolatoreMax {

	final private CalcolatoreMaxSeriale calcolatoreSeriale = new CalcolatoreMaxSeriale();
	
	@Override
	public int calcolaMax(final int[] array) {
		
		int numeroCore = Runtime.getRuntime().availableProcessors();	// numero di processori utilizzabili
		
		final int[] massimiRelativi = new int[numeroCore];				    // array con il massimo di ogni sotto-array
		
		final Thread[] lavoratori = new Thread[numeroCore]; 			    // array di tanti thread quanti i processori in uso
		
		int dimesioneProzioni = array.length/numeroCore;
		int sfrido = array.length%numeroCore;
		int inizioPorzione = 0;
		
		for(int i=0; i<numeroCore; i++) {
			
			int finePorzione = inizioPorzione + dimesioneProzioni;
			if(i<sfrido) finePorzione++;
			final int start = inizioPorzione;
			final int end = finePorzione;
			final int indice = i;
			
			lavoratori[indice] = new Thread(new Runnable() {				
				@Override
				public void run() {
					massimiRelativi[indice] = calcolatoreSeriale.calcolaMaxArray(array, start, end);
				}	
			});
			lavoratori[indice].start();					// fa si che i thread inizino a calcolare
			inizioPorzione = finePorzione;			// aggiorno l'inzice da cui iniziare la porzione successiva
		}
		
		for(int i=0; i<numeroCore; i++) {
			try {
				lavoratori[i].join();
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
		}
		
		return calcolatoreSeriale.calcolaMax(massimiRelativi);
	}

}
