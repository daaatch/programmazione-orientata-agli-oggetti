package it.uniroma3.diadia.fixture;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diaida.DiaDiaSimulator;
import it.uniroma3.diaida.IOSimulator;

public class Simulatore {

	private List<String> listaComandi;
	private IOSimulator console;
	private DiaDiaSimulator simulazione;
	
	public Simulatore() {
		this.listaComandi = new ArrayList<String>();
		this.console = new IOSimulator();
	}
	
	public void simula() {
		this.console.setInput(listaComandi);
		this.simulazione = new DiaDiaSimulator(console);
		this.simulazione.gioca();
	}
	
	public void setInput(List<String> comandi) {
		this.listaComandi = comandi;
		this.simula();
	}
	
	public String getOutput() {
		return this.console.getOutput();
	}
	
}
