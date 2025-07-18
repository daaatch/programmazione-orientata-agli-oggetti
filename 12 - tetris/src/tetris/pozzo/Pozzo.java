package tetris.pozzo;

import static tetris.Costanti.COLORE_BORDO;

import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import tetris.Costanti;
import tetris.tetramino.Tetramino;

/**
 * Questa classe modella il pozzo in cui cadono i tetramini del gioco
 * <A href="https://it.wikipedia.org/wiki/Tetris"> <em>Tetris</em></A>
 * <BR/>
 * Possiede un bordo formato da due lati e da il fondo ove si posano
 * gli oggetti {@link Tetramino} mano a mano che cadono.
 * <BR/>
 * Contiene un insieme di oggetti {@link Cella} che derivano dagli oggetti
 * {@link Tetramino} una volta che questi raggiunge il fondo del pozzo e
 * collide con una {@link Cella} già presente. 
 * <BR/>
 * Le righe completate sono rimosse invocando il metodo 
 * {@link #aggiungiCelleErimuoviRigheCompletate(Set)}
 * <BR>
 * Le celle possiedono coordinate basate in (0,0) con ascissa crescente 
 * verso dx, ed ordinata crescente verso il basso, secondo lo schema che
 * segue (<i>h</i> è l'altezza del pozzo ed  <i>l</i> la sua larghezza)
 * <PRE>
 *          (0,0) *   ---->   * (<i>l</i>,0)
 *          (0,1) *     x     * (<i>l</i>,1)
 *                *           *   
 *                . |y        .   
 *                . |         .
 *                . V         .
 *                *           * 
 *                *           *   
 *          (0,h) ************* (<i>l</i>,<i>h</i>)  
 *   
 * </PRE>
 */
public class Pozzo {

	/**
	 * Larghezza di default del pozzo;
	 * include 2 colonne di celle per i bordi
	 */
	static final public int LARGHEZZA = 12; // in celle
	
	/**
	 * Altezza di default del pozzo;
	 * 	include 1 riga di celle per il fondo
	 */
	static final public int ALTEZZA   = 24; // in celle

	
	/* serie di metodi factory per creare celle lungo il bordo */
	static final private Cella bordoDX(int riga, int larghezzaTotale) {
		return new Cella(larghezzaTotale-1,riga, COLORE_BORDO);
	}

	static final private Cella fondo(int colonna, int altezzaTotale) {
		return new Cella(colonna, altezzaTotale-1, COLORE_BORDO);
	}

	static final private Cella bordoSX(int riga) {
		return new Cella(0,riga, COLORE_BORDO);
	}

	/**
	 * Rappresentazione dell'insieme di celle contenute nel pozzo.
	 * <BR/>
	 * N.B. anche i bordi sono oggetti {@link Cella} che fanno 
	 *      parte di questo insieme
	 */
	final private NavigableSet<Cella> celle;
	
	final private int l;
	final private int a;
	
	/**
	 * Crea un pozzo delle dimensioni di default (12x24 bordi inclusi)
	 */
	public Pozzo() {
		this(LARGHEZZA,ALTEZZA);
	}

	/**
	 * Crea un pozzo delle dimensioni date.
	 * <BR/>
	 * <B>E' un costruttore molto utile per scrivere test-minimali!</B>
	 * @param l larghezza
	 * @param h altezza
	 */
	public Pozzo(int l, int h) {
		this.celle = new TreeSet<>();
		this.l = l;
		this.a = h;
		this.addBordo(l, h);
	}

	private void addBordo(int l, int h) {
		this.addBordoSX(h);    // lato sx alto h
		this.addBordoDX(h, l);    // lato dx alto h
		this.addFondo(l, h); // fondo largo l
	}
	
	private void addBordoSX(int h) {
		for (int riga=0; riga<h; riga++) {
			this.celle.add(bordoSX(riga));
		}
	}

	private void addBordoDX(int h, int l) {
		for (int riga=0; riga<h; riga++) {
			this.celle.add(bordoDX(riga, l));
		}
	}

	private void addFondo(int l, int h) {
		for (int colonna=0; colonna<l; colonna++) {
			this.celle.add(fondo(colonna, h));
		}
	}

	public boolean contiene(Cella c) {
		return this.celle.contains(c);
	}
	
	public Set<Cella> getCelle() {
		return this.celle;
	}

	/**
	 * Aggiunge un insieme di celle e quindi rimuove tutte le righe 
	 * completate, dal basso verso l'alto, spostandole le celle sopra 
	 * le righe completate di una posizione verso il basso
	 * @param celle - un {@link Set} di celle da aggiungere
	 * @return il numero di righe completate e rimosse
	 */
	public int aggiungiCelleErimuoviRigheCompletate(Set<Cella> celle) {
		/* aggiungi le nuove celle */
		this.celle.addAll(celle);
		
		/* controlla le linee dalla più in basso verso l'alto (y decrescenti) */
		final NavigableSet<Integer> righeCoinvolte = getInsiemeOrdinateY(celle);
		int contatoreRimosse = 0;
		while (!righeCoinvolte.isEmpty()) {
			int rigaPiùInBasso = righeCoinvolte.pollLast() + contatoreRimosse; // y alta <-> riga bassa
		
			if (isCompleta(rigaPiùInBasso)) {
				rimuoviRigaScendendoCelleSopra(rigaPiùInBasso);
				contatoreRimosse++;
			}
		}
		
		return contatoreRimosse;
	}
	
	/**
	 * 
	 * @param inputCelle - un insieme di celle
	 * @return l'insieme ({@link NavigableSet}) delle ordinate (y)
	 *         delle posizioni delle celle passate. L'insieme è
	 *         ordinato crescente.
	 * @see {@link Posizione},  {@link Cella}
	 */
	public NavigableSet<Integer> getInsiemeOrdinateY(Set<Cella> inputCelle) {
		NavigableSet<Integer> risultato = new TreeSet<Integer>();
		for(Cella cella : inputCelle)
			risultato.add(cella.getPosizione().getY());
		return risultato;
	}

	/**
	 * @param y ordinata della riga controllata
	 * @return true se e solo se la riga è attualmente completa
	 */
	public boolean isCompleta(int y) {
		return y == this.a - 1 || ( getCelleDellaRigaSenzaBordo(y).size() == this.l-2 ); // "-2" esclude il bordo
	}

	/**
	 * Sposta le celle sopra alla riga di riferimento di una posizione
	 * verso il basso (y risultata incrementato)
	 * 
	 * @param riga - indice della riga di riferimento
	 */
	void rimuoviRigaScendendoCelleSopra(int riga) {
		this.celle.removeAll(getCelleDellaRigaSenzaBordo(riga));
		for(Cella cella : getCelleSopraRigaYdecrescente(riga)) {
			this.celle.remove(cella);
			this.celle.add(cella.scesaDiUnaRiga());
		}
	}

	/**
	 * @param riga indice di una riga
	 * @return l'insieme di celle (escluso i bordi) della riga di indice dato
	 */
	public Set<Cella> getCelleDellaRigaSenzaBordo(int riga) {
		if(riga==this.a-1)
			return Collections.emptySet();
		return this.celle.subSet(new Cella(0,riga,Costanti.COLORE_BORDO),false,new Cella(this.l-1,riga,Costanti.COLORE_BORDO),false);
	}
	
	/**
	 * 
	 * @param riga
	 * @return il  @link {@link NavigableSet} di tutte le celle attualmente nel
	 *         pozzo e sopra la riga passata come riferimento; le celle sono 
	 *         ordinate per Y decrescente delle rispettive posizioni, ed a
	 *         parità di Y, per X.
	 *         N.B. il risultato non include le celle del bordo! */
	 
	public NavigableSet<Cella> getCelleSopraRigaYdecrescente(int riga) {
		NavigableSet<Cella> righeSopra = new TreeSet<>(
			new Comparator<Cella>() {
				@Override
				public int compare(Cella one, Cella two) {
					int dx = one.getPosizione().getX()-two.getPosizione().getX();
					if(dx!=0)
						return dx;
					return one.getPosizione().getY()-two.getPosizione().getY();
				}
			});
		righeSopra.addAll(this.celle.headSet(new Cella(0,riga,COLORE_BORDO),false));
		NavigableSet<Cella> risultato = new TreeSet<Cella>(new ComparatoreCelleDecrescente());
		risultato.addAll(righeSopra.subSet(new Cella(1,0,Costanti.COLORE_BORDO),true,new Cella(this.l-1,0,Costanti.COLORE_BORDO),false));
		return risultato;
	}
	
}
