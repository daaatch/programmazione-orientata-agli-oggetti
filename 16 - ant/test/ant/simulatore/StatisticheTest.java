package ant.simulatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final private Coordinate origine = new Coordinate(0, 0);
	
	private Esploratrice formica ;
	private Inseguitrice altraFormica ;
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
	}

	
	private Cibo creaCiboRaccoltoDaEsploratore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaEsploratrice());	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaInseguitrice());	
		return cibo;
	}
	
	private Cibo creaCiboRaccoltoDaAggressiva() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaAggressiva());	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormicaNullo() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		assertEquals(Collections.emptyMap(), this.stats.raccoltoPerFormica(new HashSet<Cibo>()));
	}
	
	@Test
	public void testRaccoltoPerFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		final Set<Cibo> ciboRaccolto = new HashSet<>();
		ciboRaccolto.add(creaCiboRaccoltoDaEsploratore());
		ciboRaccolto.add(creaCiboRaccoltoDaInseguitore());
		ciboRaccolto.add(creaCiboRaccoltoDaAggressiva());
		assertNotNull(this.stats.raccoltoPerFormica(ciboRaccolto));
		assertEquals(3, this.stats.raccoltoPerFormica(ciboRaccolto).size());
	}
	
	@Test
	public void testRaccoltoPerTipoDiFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 4 ) SUGG.: USARE I METODI FACTORY SOPRA
		final Set<Cibo> ciboRaccolto = new HashSet<>();
		ciboRaccolto.add(creaCiboRaccoltoDaEsploratore());
		ciboRaccolto.add(creaCiboRaccoltoDaInseguitore());
		ciboRaccolto.add(creaCiboRaccoltoDaAggressiva());
		assertNotNull(this.stats.raccoltoPerTipoDiFormica(ciboRaccolto));
		assertEquals(3, this.stats.raccoltoPerTipoDiFormica(ciboRaccolto).size());
	}
	
}
