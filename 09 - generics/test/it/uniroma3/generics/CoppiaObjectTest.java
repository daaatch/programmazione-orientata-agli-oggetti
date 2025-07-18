package it.uniroma3.generics;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoppiaObjectTest {

	CoppiaObject coppia;
	String pippo;
	String pluto;
	Persona Pippo;
	Persona Pluto;
	
	@Before
	public void setUp() {
		coppia = new CoppiaObject();
		pippo = new String("Pippo");
		pluto = new String("Pluto");
		Pippo = new Persona(pippo);
		Pluto = new Persona(pluto);
		coppia.setPrimo(Pippo);
		coppia.setSecondo(Pluto);
	}
	
	@Test
	public void testCompilaEdEsegui() {
		Persona persona = (Persona)coppia.getPrimo();
		assertSame(pippo,persona.getNome());
	}
	
	@Test
	public void testCheNonCompila() {
//		il seguente test non compila perchè coppia.getPrimo() mi dà
//		un oggetto di tipo statico Object che non ha il metodo getNome()
//		assertSame(pippo,coppia.getPrimo().getNome());
		assertSame(Pippo,coppia.getPrimo());
	}
	
	@Test
	public void testCheCompila() {
//		qui per farlo compilare eseguo esplicitamente il downcasting
		assertSame(pippo,((Persona)coppia.getPrimo()).getNome());
	}

}
