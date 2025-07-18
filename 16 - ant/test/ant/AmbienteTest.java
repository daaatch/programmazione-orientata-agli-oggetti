package ant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {

	private Ambiente ambiente3x3;
	private Ambiente ambiente4x4;
	private Ambiente ambiente5x5;
	
	@Before
	public void setUp() {
		this.ambiente3x3 = new Ambiente(3);
		this.ambiente4x4 = new Ambiente(4);
		this.ambiente5x5 = new Ambiente(5);
	}
	
	@Test
	public void testGetPossibiliDirezioni3x3() {
		assertTrue(this.ambiente3x3.getPossibiliDirezioni(new Coordinate(1,1)).isEmpty());
	}
	
	@Test
	public void testGetPossibiliDirezioni4x4() {
		assertFalse(this.ambiente4x4.getPossibiliDirezioni(new Coordinate(1,1)).isEmpty());
	}
	
	@Test
	public void testGetPossibiliDirezioni5x5() {
		assertEquals(3, this.ambiente5x5.getPossibiliDirezioni(new Coordinate(1,1)).size());
	}
	
	@Test
	public void testGetPossibiliDirezioniCentro5x5() {
		assertEquals(8, this.ambiente5x5.getPossibiliDirezioni(new Coordinate(2,2)).size());
	}

}
