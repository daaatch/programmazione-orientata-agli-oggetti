package it.uniroma3.collection.list;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComparatoreTest {

	private Biblioteca biblioteca;
	private Libro l1;
	private Libro l2;
	private Libro l3;
	
	@Before
	public void setUp() {
		this.biblioteca = new Biblioteca();
		this.l1 = new Libro("Libro Uno",13);
		this.l2 = new Libro("Libro Due",6);
		this.l3 = new Libro("Libro Tre",44);
		this.biblioteca.aggiungiLibro(l1);
		this.biblioteca.aggiungiLibro(l2);
		this.biblioteca.aggiungiLibro(l3);
	}
	
	@Test
	public void test() {
		assertEquals(l2,biblioteca.elencoOrdinatoPerPagine().get(0));
		assertEquals(l1,biblioteca.elencoOrdinatoPerPagine().get(1));
		assertEquals(l3,biblioteca.elencoOrdinatoPerPagine().get(2));
	}

}
