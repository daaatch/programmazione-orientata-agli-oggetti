package battlefield;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddWalker() {
		assertEquals(0,this.field.getAllRobots().size());
		this.field.addRobot(new Walker(new Position(0,0)));
		assertEquals(1,this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotCampoVuoto() {
		assertTrue(this.field.raggruppaRobotPerTipo().isEmpty());
	}
	
	@Test
	public void testRaggruppaRobotConUnWalker() {
		this.field.addRobot(new Walker(new Position(0,1)));
		assertEquals(1,this.field.raggruppaRobotPerTipo().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		this.field.addRobot(new Walker(new Position(0,1)));
		this.field.addRobot(new Chaser(new Position(0,0)));
		assertEquals(2,this.field.raggruppaRobotPerTipo().size());
	}

}
