package tetris;

import static java.awt.event.KeyEvent.*;
import static tetris.Costanti.DIM_CELLE;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tetris.pozzo.Cella;

import static tetris.pozzo.Pozzo.*;

public class GUI extends JPanel {

	static final private long serialVersionUID = 0L;

	static final public int VK_HEARTBEAT = VK_SHIFT; // meglio un tasto "innocuo"
	
	final private Game game;

	final private JFrame jframe;

	GUI(final Game game) {
		this.game = game;
		this.jframe = new JFrame("Tetris");		
		jframe.add(this);
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jframe.setSize(LARGHEZZA*DIM_CELLE, (ALTEZZA+1)*DIM_CELLE);
		jframe.setVisible(true);
	}

	public void initControlliDaTastiera(final Game game) {

		// Gestione eventi associati alla tastiera
		this.jframe.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case VK_UP:
					game.ruota(-1);
					break;
				case VK_DOWN:
					game.ruota(+1);
					break;
				case VK_LEFT:
					game.sposta(-1);
					break;
				case VK_RIGHT:
					game.sposta(+1);
					break;
				case VK_SPACE:
					game.aumentaPunteggio(+1);
				case VK_HEARTBEAT:
					game.lasciaCadere();
					break;
				case VK_ESCAPE:
					game.gameOver();
					break;
				}
				repaint();
			}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, LARGHEZZA*DIM_CELLE, ALTEZZA*DIM_CELLE);
		for (Cella c : this.game.getPozzo().getCelle()) {
			disegnaCella(g, c);
		}

		final long livello = this.game.getLivello();
		final long punteggio = this.game.getPunteggio();
		riportaLivelloPunteggio(livello, punteggio);

		disegnaTetraminoCorrente(g);	
	}

	private void riportaLivelloPunteggio(long livello, long punteggio) {
		this.jframe.setTitle("Livello: "+livello+"\tPunteggio: "+punteggio);
	}

	/**
	 * Disegna le 4 {@link Cella} del {@link Tetramino} corrente
	 * @param g
	 */
	private void disegnaTetraminoCorrente(Graphics g) {
		for (Cella c : this.game.getCelleDelTetramino()) {
			disegnaCella(g, c);
		}
	}

	/**
	 * @param g
	 * @param cella - la {@link Cella} da disegnare
	 */
	private void disegnaCella(Graphics g, Cella cella) {
		final int x = cella.getPosizione().getX();
		final int y = cella.getPosizione().getY();
		final Color colore = cella.getColore();
		g.setColor(colore);
		int d = DIM_CELLE;
		int gx = x*d, gy = y*d;
		disegnaCellaInRilievo(g, d, gx, gy);
	}

	private void disegnaCellaInRilievo(Graphics g, int l, int x, int y) {
		g.fill3DRect(   x,  y,   l-1, l-1, false);
		g.fillRoundRect(x+2,y+2, l-4, l-4, 2, 2 );
		g.fill3DRect(   x+3,y+3, l-6, l-6, true );
	}

}
