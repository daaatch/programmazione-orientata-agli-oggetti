package it.uniroma3.generics;
public class CoppiaWildcard {

	public CoppiaWildcard() { }
	
	public static <T> void reverse(Coppia<T> coppia) {
		T temp = coppia.getPrimo();
		coppia.setPrimo(coppia.getSecondo());
		coppia.setSecondo(temp);
	}
	
	public static <T> void copy(Coppia<? super T> dest, Coppia<? extends T> src) {
//	<? super T> vuol dire un riferimento a una coppia di tipo T o di qualsiasi supertipo di T	
		dest.setPrimo(src.getPrimo());
		dest.setSecondo(src.getSecondo());
	}
	
}
