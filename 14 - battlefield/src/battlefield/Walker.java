package battlefield;


public class Walker extends Robot {
	
	public Walker(Position p) {
		super(p);
	}
	
	@Override
	protected Walker creaClone(Position p) {
		return new Walker(p);
	}
	
	@Override
	protected Position decidiMossa(Battlefield field) {
		Position corrente = this.getPosizione();
		Position libera = field.posizioneLiberaVicino(corrente);
		return libera;
	}
	
}
