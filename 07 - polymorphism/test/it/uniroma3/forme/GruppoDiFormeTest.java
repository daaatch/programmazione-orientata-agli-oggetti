package it.uniroma3.forme;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GruppoDiFormeTest {

	private GruppoDiForme vuoto;
	private GruppoDiForme nidificato;
	private GruppoDiForme gruppoDiGruppi;
	private Punto origine;
	private Cerchio circle;
	
	@Before
	public void setUp() {
		this.vuoto = new GruppoDiForme();
		this.nidificato = new GruppoDiForme();
		this.gruppoDiGruppi = new GruppoDiForme();
		this.origine = new Punto(0,0);
		this.circle = new Cerchio(origine,3);
	}
	
	@Test
	public void testTraslaGruppoNelGruppo() {
		assertTrue(this.nidificato.aggiungiForma(circle));
		assertTrue(this.gruppoDiGruppi.aggiungiForma(nidificato));
		this.gruppoDiGruppi.trasla(2,1);
		assertEquals(2,circle.getCentro().getX());
		assertEquals(1,circle.getCentro().getY());
	}

	@Test
	public void testGruppoVuoto() {
		assertEquals(0,this.vuoto.getNumeroComponenti());
	}
	
	@Test
	public void testAggiungiGruppoNelGruppo() {
		assertEquals(0,this.gruppoDiGruppi.getNumeroComponenti());
		assertTrue(this.gruppoDiGruppi.aggiungiForma(this.nidificato));
		assertEquals(1,this.gruppoDiGruppi.getNumeroComponenti());
	}

}