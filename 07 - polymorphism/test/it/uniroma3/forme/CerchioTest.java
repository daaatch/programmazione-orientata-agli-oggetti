package it.uniroma3.forme;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CerchioTest {

	private Punto origine;
	private Cerchio cerchio;
	
	@Before
	public void setUp() {
		this.origine = new Punto(0,0);
		this.cerchio = new Cerchio(origine,2);
	}
	
	@Test
	public void testTrasla() {
		cerchio.trasla(3,2);
		assertEquals(new Punto(3,2),this.cerchio.getCentro());
	}

	@Test
	public void testNonTraslare() {
		cerchio.trasla(0,0);
		assertEquals(origine,this.cerchio.getCentro());
	}

}