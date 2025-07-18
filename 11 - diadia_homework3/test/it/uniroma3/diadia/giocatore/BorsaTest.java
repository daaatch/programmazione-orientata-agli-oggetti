package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diaida.attrezzi.Attrezzo;
import it.uniroma3.diaida.giocatore.Borsa;

public class BorsaTest {

	private Borsa borsa = new Borsa();
	private Attrezzo torcia = new Attrezzo("torcia",2);
	private Attrezzo mappa = new Attrezzo("mappa",3);
	private Attrezzo giacca = new Attrezzo("giacca",5);
	private Attrezzo quaderno = new Attrezzo("quaderno",2);
	private Attrezzo fazzoletti = new Attrezzo("fazzoletti",1);
	private List<Attrezzo> listaPerPeso = new ArrayList<>();
	private SortedSet<Attrezzo> ordineAlfabetico = new TreeSet<>();
	private SortedSet<Attrezzo> gruppoPeso2 = new TreeSet<>();
	private SortedSet<Attrezzo> gruppoPeso5 = new TreeSet<>();
	private Map<Integer,Set<Attrezzo>> contenutoRaggruppato = new HashMap<>();
	private SortedSet<Attrezzo> sortedSet = new TreeSet<>();
	
	@Before
	public void setUp() {
		this.borsa.addAttrezzo(giacca);
		this.borsa.addAttrezzo(torcia);
		this.borsa.addAttrezzo(quaderno);
		this.listaPerPeso.add(quaderno);
		this.listaPerPeso.add(torcia);
		this.listaPerPeso.add(giacca);
		this.ordineAlfabetico.add(giacca);
		this.ordineAlfabetico.add(quaderno);
		this.ordineAlfabetico.add(torcia);
		this.gruppoPeso2.add(quaderno);
		this.gruppoPeso2.add(torcia);
		this.gruppoPeso5.add(giacca);
		this.contenutoRaggruppato.put(5,gruppoPeso5);
		this.contenutoRaggruppato.put(2,gruppoPeso2);
		this.sortedSet.add(torcia);
		this.sortedSet.add(giacca);
		this.sortedSet.add(quaderno);
	}
	
	@Test
	public void testAddAttrezzoMancante() {
		assertTrue(this.borsa.addAttrezzo(fazzoletti));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(this.borsa.addAttrezzo(null));
	}
	
	@Test
	public void testOverflowPesoBorsa() {
		assertFalse(this.borsa.addAttrezzo(mappa));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		assertEquals(torcia, this.borsa.removeAttrezzo("torcia"));
	}
	
	@Test
	public void testRemoveAttrezzoAssente() {
		assertEquals(null, this.borsa.removeAttrezzo("fazzoletti"));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		assertNull(this.borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzoPresente() {
		assertTrue(this.borsa.hasAttrezzo("quaderno"));
	}
	
	@Test
	public void testHasAttrezzoAssente() {
		assertFalse(this.borsa.hasAttrezzo("bussola"));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		assertFalse(this.borsa.hasAttrezzo(null));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		assertEquals(listaPerPeso,this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		assertEquals(ordineAlfabetico,this.borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetGruppettoPerPeso() {
		assertEquals(this.gruppoPeso2,this.borsa.getGruppettoPerPeso(2));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		assertEquals(contenutoRaggruppato,this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		assertEquals(sortedSet,this.borsa.getSortedSetOrdinatoPerPeso());
	}

}