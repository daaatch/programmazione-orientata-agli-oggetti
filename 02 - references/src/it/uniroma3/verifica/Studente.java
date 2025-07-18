package it.uniroma3.verifica;

public class Studente {

	private String nome;

    public Studente(String nome) {
        this.nome = nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    public static void main(String[] argc) {    
    	Studente[] studenti = new Studente[3];
        Studente a1 = new Studente("Gigi");
        studenti[0] = a1;
        a1.setNome("Giorgio");
        a1 = new Studente("Luca");
        studenti[1] = a1;
        Studente a2;
        a2 = a1;
        a2.setNome("Paolo");
        studenti[2] = a2;
        for(int i=0; i<studenti.length; i++)
            System.out.print(studenti[i].getNome()+" ");
    }
    
}