package it.uniroma3.generics;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class CoppiaTest {

	@Test
	public void testCoppiaDiPersone() {
		Coppia<Persona> coppia;
		Persona stanlio = new Persona("Stanlio");
		Persona ollio = new Persona("Ollio");
		coppia = new Coppia<Persona>(stanlio, ollio);
		assertSame(stanlio,coppia.getPrimo());
		assertSame(ollio,coppia.getSecondo());
	}
	
	@Test
	public void testCheCompilaSenzaRompere() {
		Coppia<Persona> coppia;
		Persona stanlio = new Persona("Stanlio");
		Persona ollio = new Persona("Ollio");
		coppia = new Coppia<Persona>(stanlio, ollio);
		assertSame("Stanlio",coppia.getPrimo().getNome());
		assertSame("Ollio",coppia.getSecondo().getNome());
	}
	
	@Test
	public void testCoppiaDiColori() {
		Coppia<Color> colori;
		Color rosso = new Color(255,0,0);
		Color blu = new Color(0,0,255);
		colori = new Coppia<Color>(rosso, blu);
		assertSame(rosso,colori.getPrimo());
		assertSame(blu,colori.getSecondo());
	}
	
	@Test
	public void testClasseWrapper() {
//		non potendo creare coppie formate da tipi primitivi ho 
//		bisogno di avvalermi delle corrispondenti classi wrapped
		Coppia<Integer> coppia;
//		Integer uno = new Integer(1);
//		Integer due = new Integer(2);
		Integer uno = 1;
    	Integer due = 2;
		coppia = new Coppia<Integer>(uno,due);
		assertSame(1,coppia.getPrimo().intValue());
		assertSame(2,coppia.getSecondo().intValue());
	}
	
	@Test
	public void testBoxingClasseWrapper() {
		Coppia<Double> coppia;
		Double unoemezzo = 1.50;
		Double dueetrequarti = 2.75;
		coppia = new Coppia<Double>(unoemezzo,dueetrequarti);
		assertTrue(1.50==coppia.getPrimo().doubleValue());
		assertTrue(2.75==coppia.getSecondo().doubleValue());
	}

}
