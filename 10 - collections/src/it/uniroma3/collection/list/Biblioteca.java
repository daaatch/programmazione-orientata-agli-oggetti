package it.uniroma3.collection.list;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {

	private List<Libro> elenco;
	
	public Biblioteca() {
		this.elenco = new ArrayList<>();
	}
	
	public void aggiungiLibro(Libro libro) {
		this.elenco.add(libro);
	}
	
	public List<Libro> elencoOrdinatoPerPagine() {
		ComparatorePerPagine comparatore = new ComparatorePerPagine();
		Collections.sort(this.elenco, comparatore);
		return this.elenco;
	}
	
}