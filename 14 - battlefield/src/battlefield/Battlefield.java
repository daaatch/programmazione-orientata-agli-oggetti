package battlefield;

import java.util.*;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;
	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;
	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%
	private int dimensione;
	private Random random;	
	private Map<Position, Robot> posizioneRobots;

	public Battlefield(int dimensione) {
		this.dimensione = dimensione;
		this.posizioneRobots = new HashMap<>();
		this.random = new Random();
	}

	public int getDimensione() {
		return this.dimensione;
	}

	public void addRobot(Robot r) {
		this.posizioneRobots.put(r.getPosizione(),r);
	}

	public Robot getRobot(Position p) {
		return posizioneRobots.get(p);
	}

	public Collection<Robot> getAllRobots() {
		return this.posizioneRobots.values();
	}

	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		Collection<Robot> robots = this.posizioneRobots.values();
		Map<Class, Set<Robot>> classeRobots = new HashMap<>();
		for(Robot r : robots) {
			if(!classeRobots.containsKey(r.getClass())) 
				classeRobots.put(r.getClass(), new HashSet<Robot>());
			classeRobots.get(r.getClass()).add(r);
		}
		return classeRobots;
	}
	
	public List<Robot> getRobotOrdinatiPerPosizione() {
		List<Robot> ordinatiPerPosizione = new ArrayList<>(this.posizioneRobots.values());
		Comparator<Robot> comparatorePerPosizione = new ComparatorePerPosizione();
		ordinatiPerPosizione.sort(comparatorePerPosizione);
		return ordinatiPerPosizione;
	}
	
	public SortedSet<Robot> getRobotOrdinatiPerLongevita() {
		SortedSet<Robot> oridnatiPerLongevita = new TreeSet<Robot>();
		oridnatiPerLongevita.addAll(this.getAllRobots());
		return oridnatiPerLongevita;
	}
	
	public List<Position> adiacenti(Position p) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = p.getX();
		int y = p.getY();
		for(int i=-1; i<2; i++) {
			for(int j=-1; j<2; j++) {
				Position adiacente = new Position(x+i,y+j);
				if(inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(p);  				 /* rimuovo la posizione centrale e restituisco*/
		Collections.shuffle(adiacenti); 	/* la lista delle posizioni in ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return ((p.getX()>=0)&&(p.getX()<this.dimensione)&&(p.getY()>=0)&&(p.getY()<this.dimensione));
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if(this.isLibera(p))
				return p;
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return (this.getRobot(posizione)==null);
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dimensione * dimensione);
		for(int i=0; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dimensione);
			int y = this.random.nextInt(this.dimensione);
			Position posizione = new Position(x,y);
			if(this.isLibera(posizione)) {
				switch(this.random.nextInt(NUMERO_TIPOLOGIE)) {
					case 0:  Chaser chaser = new Chaser(posizione);
							 this.addRobot(chaser);
							 break;
					case 1:  Walker walker = new Walker(posizione);
							 this.addRobot(walker);
							 break;
					default: throw new IllegalStateException();
				} 
			}
		}
	}

}
