package esercitazione.testing;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersoneTest {

	@Test
	public void testPersoneVuote() {
		assertEquals(0, persone().contaOmonimi("Gianni"));
	}
	
	@Test
	public void testPersoneSingletonConOmonimo() {
		assertEquals(1, persone("Gianni").contaOmonimi("Gianni"));
	}
	
	@Test
	public void testPersoneSingletonSenzaOmonimo() {
		assertEquals(0, persone("Barba").contaOmonimi("Gianni"));
	}

	private Persone persone(String... nomi) {
		Persone peepol = new Persone(nomi.length);
		for(int i=0; i<nomi.length; i++) {
			peepol.inserisciNome(i, nomi[i]);
		}
		return peepol;
	}
	
}
