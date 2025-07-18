package it.uniroma3.diaida.IOConsole;

import java.util.Scanner;

public class IOConsole {
	
	public void mostraMessaggio(String msg) {
		System.out.print(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
	//	scannerDiLinee.close();
		return riga;
	}
	
}