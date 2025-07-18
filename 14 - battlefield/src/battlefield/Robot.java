package battlefield;

public abstract class Robot implements Comparable<Robot> {

	private Position posizione;
	private int longevita;
	
	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0;
	}
	
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	public void incrementaLongevita() {
		++this.longevita;
	}
	
	public void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);
		if(nuova!=null) {
			Robot clone = this.creaClone(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	@Override
	public int compareTo(Robot that) {
		if(this.getLongevita()-that.getLongevita()!=0)
			return this.getLongevita()-that.getLongevita();
		return 1;
	}
	
	protected abstract Robot creaClone(Position p);
	
	protected abstract Position decidiMossa(Battlefield field);
	
}
