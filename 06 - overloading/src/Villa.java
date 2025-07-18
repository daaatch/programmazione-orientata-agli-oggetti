
interface Edificio {
	void numeroPiani();
}

class Palazzo implements Edificio {
	public void numeroPiani() {}
}

public class Villa implements Edificio {
	
	public void numeroPiani() {}

	public static void main(String[] argc){
		Edificio e = new Villa();
		Villa v = new Villa();
		Edificio e1 = new Villa();
		e=v;	//inverto l'ordine di v=e per avere upcasting				
		e1=v;					
		e1.numeroPiani();		
		e = new Palazzo();					
	}

}