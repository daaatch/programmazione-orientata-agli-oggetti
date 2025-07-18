package it.uniroma3.forme;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RettangoloTest {

	private Punto vertice;
	private Rettangolo rettangolo;
	
	@Before
	public void setUp() {
		this.vertice = new Punto(1,1);
		this.rettangolo = new Rettangolo(vertice,4,5);
	}
	
	@Test
	public void testTrasla() {
		rettangolo.trasla(7,3);
		assertEquals(new Punto(8,4),this.rettangolo.getVertice());
	}

	@Test
	public void testNonTraslare() {
		rettangolo.trasla(0,0);
		assertEquals(new Punto(1,1),this.rettangolo.getVertice());
	}

}