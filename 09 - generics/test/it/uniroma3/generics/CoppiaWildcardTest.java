package it.uniroma3.generics;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoppiaWildcardTest {

	private Coppia<Persona> persone;
	private Coppia<Studente> studenti;
	private Studente wan;
	private Studente chu;
	
	@Before
	public void setUp() {
		this.wan = new Studente("Wan","123456");
		this.chu = new Studente("Chu","654321");
		this.studenti = new Coppia<Studente>(wan,chu);
	}
	
	@Test
	public void testReverse() {
		CoppiaWildcard.reverse(studenti);
		assertSame(chu,studenti.getPrimo());
		assertSame(wan,studenti.getSecondo());
	}
	
	@Test
	public void testCopy() {
		this.persone = new Coppia<Persona>();
		CoppiaWildcard.copy(persone,studenti);
		assertSame(wan,persone.getPrimo());
		assertSame(chu,persone.getSecondo());
	}

}
