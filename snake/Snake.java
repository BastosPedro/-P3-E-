package snake;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Snake implements ActionListener, KeyListener {
	
	public static Snake snake, Snake;
	public ArrayList<Point> partsSnake = new ArrayList<Point>();
	public ArrayList<Point> obs = new ArrayList<Point>();
	public ArrayList<Rank> rank = new ArrayList<Rank>();
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, ESCALA = 10;
	public int ticks = 0, direcao = DOWN, pontos, compCauda, tempo, velo, vida = 0, pontosbonus = 0;
	public String nome;
	public Point head, comida;
	public Random random;
	public Boolean status = false, pause;
	public SnakeMenu data = new SnakeMenu(new Timer(10, this));

	public Snake(){
		data.jFrame.addKeyListener(this);
		// action listener pra cada botao
		data.iniciar.addActionListener(this);
		data.sair.addActionListener(this);
		data.ajuda.addActionListener(this);
		inicio();
	}
	// metodo que define as variaveis para o inicio do jogo
	public void inicio(){
		velo = 5;
		status = false;
		pontos = 0;
		pause = true;
		tempo = 0;
		vida = 0;
		pontosbonus = 0;
		compCauda = 3;
		direcao = DOWN;
		head = new Point(0, -1);
		random = new Random();
		partsSnake.clear();
		obs.clear();
		comida = new Point(111,111);
		data.timer.start();
		
		for(int i=0; i < 5; i++){
			rank.add(new Rank("", 0));
		}
		
	
	}
	
	public void iniciaGame(){
		status = false;
		pontos = 0;
		pause = false;
		tempo = 0;
		compCauda = 3;
		vida = 0;
		pontosbonus = 0;
		direcao = DOWN;
		head = new Point(0, -1);
		random = new Random();
		partsSnake.clear();
		obs.clear();
		comida = new Point(random.nextInt(69), random.nextInt(48));
		data.timer.start();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		data.iniciar.setFocusable(false);
		data.sair.setFocusable(false);
		data.ajuda.setFocusable(false);
		data.nivel.setFocusable(false);
		data.sep.setFocusable(false);
		data.sep1.setFocusable(false);
		//botao iniciar 		
		if (arg0.getSource() == data.iniciar){
			
			nome = JOptionPane.showInputDialog("Qual seu Nome ??");
			data.lnome.setText("Jogador:  "+nome);
			switch(data.nivel.getSelectedIndex()){
				//nivel facil
				case 0:	
					velo = 10;
					iniciaGame();
					obs.clear();
					break;
				//nivel medio	
				case 1:
					velo = 5;
					iniciaGame();
					obs.clear();
					for(int i=35; i>10; i--){
						obs.add(new Point(15, i));
						obs.add(new Point(55, i));
						
					}
					break;
				//nivel dificil	
				case 2:
					velo = 3;
					iniciaGame();
					obs.clear();
					for(int i=35, e=60 ; i>10; i--, e--){
						obs.add(new Point(15, i));
						obs.add(new Point(55, i));
						obs.add(new Point(i, 3));
						obs.add(new Point(i, 45));
						obs.add(new Point(e, 3));
						obs.add(new Point(e, 45));
					}
					break;
				
				default:
			
			}
		}
		//botao sair
		if (arg0.getSource() == data.sair){
			System.exit(0);
		}
		//botao ajuda
		if (arg0.getSource() == data.ajuda){
			JOptionPane.showMessageDialog(null, "O cl�ssico jogo Snake onde voc� tem de pegar comida\nsem bater nas paredes, no seu pr�prio corpo ou em obstaculos.\nA cada 20 pontos o jogador recebe uma vida como bonus.\nAs teclas direcionais controlam o jogo.\nA tecla espa�o pausa o jogo.");
		}
		
		data.painel.repaint();
		ticks++;
		//verifica se o jogador ainda possui vidas 
		if(vida >= 0){
		
		if(ticks % velo == 0 && head != null && !status && !pause && vida >= 0){ 
			
			
			tempo++;
			partsSnake.add(new Point(head.x, head.y));
			// se bateu na parade de cima
			if(direcao == UP)
				if(head.y -1 >= 0 && batercausa(head.x, head.y - 1) && batObs(head.x, head.y - 1)){
					head = new Point(head.x, head.y - 1);
				
				}else{
					vida--;
					data.bonus.setText("Voce perdeu uma vida !!!!");
					
				}
			// se bateu na parade de baixo
			if(direcao == DOWN)
				if(head.y +1 <= 48 && batercausa(head.x, head.y + 1) && batObs(head.x, head.y + 1)){
					head = new Point(head.x, head.y + 1);
					
				}else{
					vida--;
					data.bonus.setText("Voce perdeu uma vida !!!!");
					
				}
			// se bateu na parade da esquerda
			if(direcao == LEFT)
				if(head.x -1 >= 0 && batercausa(head.x - 1, head.y) && batObs(head.x - 1, head.y)){
					head = new Point(head.x - 1, head.y);
				}else{
					vida--;
					data.bonus.setText("Voce perdeu uma vida !!!!");
					
				}
			// se bateu na parade da direita
			if(direcao == RIGHT)
				if(head.x + 1 <= 69 && batercausa(head.x + 1, head.y) && batObs(head.x + 1, head.y)){
					head = new Point(head.x + 1, head.y);
				}else{
					vida--;
					data.bonus.setText("Voce perdeu uma vida !!!!");
					
				}
			
			if(partsSnake.size() > compCauda)
				partsSnake.remove(0);
			// se a snake comer a comida
			if(comida != null){
				if(head.equals(comida)){
					pontos += 10;
					pontosbonus += 10;
					compCauda++;
					comida.setLocation(geraposX(), geraposY());
					data.bonus.setText("");
				}
			}
			//se pontos maior que 20 ganha nova vida
			if(pontosbonus == 20){
				vida++;
				pontosbonus = 0;
				data.bonus.setText("Voce ganhou uma vida !!!!");
			}	
		}
	}
		//se nao possui mais vidas, Game over !!!
		else {
			vida = 0;
			JOptionPane.showMessageDialog(null, "GAME OVER !!!");
			data.bonus.setText("");
			status = true;
			rank();
		}
		
	}
	
	
	
	
	private int geraposX() {
		int x, y;
		
		x = random.nextInt(69);
		y = random.nextInt(48);
		
		if(!batObs(x, y)){
			geraposX();
		}
		
		return x;
	}
	
	private int geraposY() {
		int x, y;
		
		x = random.nextInt(69);
		y = random.nextInt(48);
		
		if(!batObs(x, y)){
			geraposY();
		}
		
		return y;

	}
	
	public void rank(){
		Rank e = new Rank(nome, pontos);

		rank.remove(rank.size()-1);
		rank.add(e);
		
		
		if(rank.size() > 1){
			ordena();
		}
	
		mostrarank();
		
	}
	
	private void mostrarank() {
		data.rank1.setText("1� --- Nome: "+ rank.get(0).nome);
		data.rank2.setText("2� --- Nome: " + rank.get(1).nome);
		data.rank3.setText("3� --- Nome: " + rank.get(2).nome);
		data.rank4.setText("4� --- Nome: " + rank.get(3).nome);
		data.rank5.setText("5� --- Nome: " + rank.get(4).nome);
		data.rank6.setText("Pontua��o: " + rank.get(0).pontos());
		data.rank7.setText("Pontua��o: " + rank.get(1).pontos());
		data.rank8.setText("Pontua��o: " + rank.get(2).pontos());
		data.rank9.setText("Pontua��o: " + rank.get(3).pontos());
		data.rank10.setText("Pontua��o: " + rank.get(4).pontos());
		
	}
	
	public void ordena(){
		
		Rank aux = new Rank("", 0);
		int i, e;
		
		for(e=0; e < rank.size()-1; e++){
			for(i=0; i < rank.size()-1; i++){
				if(rank.get(i).pontos <= rank.get(i+1).pontos){
					aux = rank.get(i);
					rank.set(i, rank.get(i+1));
					rank.set(i+1, aux);				
				}
			}
		}
	}
	// caso bater no obstaculo
	public boolean batObs(int x, int y) {
		for(Point point: obs){
			
			if(point.equals(new Point(x, y))){
					vida--;
					data.bonus.setText("Voce perdeu uma vida !!!!");
			}
			if(vida < 0){
				return false;
			}
			
			}
		
		return true;
	}
   // caso bater nela mesmo
	public boolean batercausa(int x, int y) {
		for(Point point: partsSnake){
			if(point.equals(new Point(x, y))){
				vida--;
				data.bonus.setText("Voce perdeu uma vida !!!!");
		}
		if(vida < 0){
			return false;
		}
		}
		return true;
	}
   
	public static void main(String[] args){
		Snake = new Snake();
	}

	@Override
	// tratamento do evento das teclas
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		
		if (i == KeyEvent.VK_F12 ){
			iniciaGame();
			velo=2;
			compCauda = 20;
		}
				
		if (i == KeyEvent.VK_LEFT && direcao != RIGHT)
			direcao = LEFT;
		if (i == KeyEvent.VK_RIGHT && direcao != LEFT)
			direcao = RIGHT;
		if (i == KeyEvent.VK_UP && direcao != DOWN)
			direcao = UP;
		if (i == KeyEvent.VK_DOWN && direcao != UP)
			direcao = DOWN;
		if (i == KeyEvent.VK_SPACE){
			pause = !pause;
			data.paused.setText("Jogo Pausado");
		}
		else{
			data.paused.setText("");
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}