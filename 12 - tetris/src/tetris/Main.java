package tetris;

import static tetris.GUI.VK_HEARTBEAT;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * <P>
 * Credits: è un refactoring di uno dei tanti cloni Java di Tetris 
 * disponibili online, ad es.
 * <A href="https://bitbucket.org/repo/all?name=tetris">
 * https://bitbucket.org/repo/all?name=tetris
 * </A>
 * </P>
 * <BR/>
 * Il codice è stato rivisto con questi obiettivi didattici principali:
 * <ul>
 * <li> preparare un esercizio sulle collezioni ed in particolare 
 *      {@link java.util.SortedSet}
 * <li> mostrare una modellazione di dominio alternativa a diadia
 * <li> preparare il terreno per introdurre alcuni strumenti offerti dal
 *   linguaggio Java, ovvero {@link java.lang.Enum}, classi anonime 
 *   (che si vogliono coprire), e {@link java.lang.Thread} (che si vogliono 
 *   solo introdurre) in vista delle future evoluzioni del corso.
 * </ul>
 */
public class Main {

	public static void main(String[] args) throws Exception {

		final Game game = new Game();
		final GUI gui = new GUI(game);
		gui.initControlliDaTastiera(game);
		cominciaIlGioco(game);
	}

	/**
	 * Cadenza la caduta dei pezzi al ritmo corrente
	 * @see http://stackoverflow.com/questions/18169598/how-can-i-programmatically-generate-keypress-events
	 */
	private static void cominciaIlGioco(final Game game) throws AWTException {
		/**
		 * Genera artificialmente la pressione di un tasto al ritmo corrente
		 */
		while (true) {
			final Robot robot = new Robot();
			robot.keyPress(VK_HEARTBEAT);
			robot.keyRelease(VK_HEARTBEAT);			
			robot.delay(game.getRitmo());
		}
	}

	/*  // Esponendo i thread in alternativa:
	 * 	// ... TimerTask?
		final Thread thread = new Thread() {
			@Override public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						game.lasciaCadere();
						gui.repaint();
					} catch ( InterruptedException e ) {}
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
	}
	 */


}
