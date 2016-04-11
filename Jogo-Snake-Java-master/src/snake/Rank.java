package snake;

public class Rank {
	public String nome;
	public int pontos;
	
	public Rank(String n, int p){
		nome = n;
		pontos = p;
	}
	
	public String pontos(){
		return "" + pontos;		
	}
	
}
