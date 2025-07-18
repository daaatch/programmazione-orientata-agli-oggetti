package it.uniroma3.diaida;

import java.util.Scanner;

public class IOConsole implements IO {
	
	public void mostraMessaggio(String msg) {
		System.out.print(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
//		scannerDiLinee.close();
		return riga;
	}
	
}