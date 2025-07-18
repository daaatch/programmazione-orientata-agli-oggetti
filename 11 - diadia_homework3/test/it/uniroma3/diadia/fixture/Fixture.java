package it.uniroma3.diadia.fixture;

import java.util.ArrayList;
import java.util.List;

public class Fixture {

	private Simulatore simulatore;
	private List<String> input;
	
	public String simulazioneAiutoFine() {
		this.simulatore = new Simulatore();
		this.input = new ArrayList<String>();
		this.input.add("aiuto");
		this.input.add("fine");
		this.simulatore.setInput(input);
		return this.simulatore.getOutput();
	}
	
	public void main() {
		System.out.println(this.simulazioneAiutoFine());
	}
	
}
