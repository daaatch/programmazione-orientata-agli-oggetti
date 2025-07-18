package battlefield;

import static org.junit.Assert.*;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {
	
	public Battlefield field;
	
	@Before
	public void setUp() {
		this.field = new Battlefield(2);
	}
	
	@Test
	public void testCampoVuoto() {
		assertEquals(0,field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testCampoSingoloRobot() {
		Walker w = new Walker(new Position(1,0));
		field.addRobot(w);
		assertEquals(1,field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testDueRobotPosizioneDiversa() {
		Walker w = new Walker(new Position(1,0));
		field.addRobot(w);
		Chaser c = new Chaser(new Position(0,1));
		field.addRobot(c);
		assertSame(w,field.getRobotOrdinatiPerPosizione().get(1));
		assertSame(c,field.getRobotOrdinatiPerPosizione().get(0));
	}
	
	@Test
	public void testDueRobotStessaAscissa() {
		Walker w = new Walker(new Position(1,0));
		field.addRobot(w);
		Chaser c = new Chaser(new Position(1,1));
		field.addRobot(c);
		assertSame(w,field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(c,field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void testQuattroRobot() {
		Walker w1 = new Walker(new Position(0,0));
		field.addRobot(w1);
		Walker w2 = new Walker(new Position(1,0));
		field.addRobot(w2);
		Chaser c1 = new Chaser(new Position(0,1));
		field.addRobot(c1);
		Chaser c2 = new Chaser(new Position(1,1));
		field.addRobot(c2);
		assertSame(w1,field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(c1,field.getRobotOrdinatiPerPosizione().get(1));
		assertSame(w2,field.getRobotOrdinatiPerPosizione().get(2));
		assertSame(c2,field.getRobotOrdinatiPerPosizione().get(3));
	}

}
