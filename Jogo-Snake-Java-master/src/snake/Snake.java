package snake;
//imports 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import javafx.scene.layout.Pane;


public class Snake implements ActionListener, KeyListener {

	public Componets comp;

	public static Snake snake, Snake;

	public JFrame jFrame;

	public ProxyPanel painel;

	public Timer timer = new Timer(10, this);

	public ArrayList<Point> partsSnake = new ArrayList<Point>();

	public ArrayList<Point> obs = new ArrayList<Point>();

	public ArrayList<Rank> rank = new ArrayList<Rank>();

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, ESCALA = 10;

	public int ticks = 0, direcao = DOWN, pontos, compCauda, tempo, velo, vida = 0, pontosbonus = 0;

	public String nome;

	public Point head, comida;

	public Random random;

	public Boolean status = false, pause;

	public Dimension dim;

	public Snake(){
		// definiçoes do frame
		comp = new Componets();
		painel = new ProxyPanel(comp);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame = new JFrame("Snake");
		jFrame.setVisible(true);
		jFrame.setSize(995, 519);
		jFrame.setResizable(false);
		jFrame.setLocation(dim.width / 2 - jFrame.getWidth() / 2, dim.height / 2 - jFrame.getHeight() / 2);

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.addKeyListener(this);
		/*//definiçoes botoes, labels, combobox ...
		iniciar = new JButton("Iniciar");
		sair = new JButton("Sair");
		ajuda = new JButton("Ajuda");
		lnivel = new JLabel("Nivel");
		lnome = new JLabel("");
		bonus = new JLabel("");
		paused = new JLabel("");
		rank1 = new JLabel("1º --- Nome:");
		rank2 = new JLabel("2º --- Nome:");
		rank3 = new JLabel("3º --- Nome:");
		rank4 = new JLabel("4º --- Nome:");
		rank5 = new JLabel("5º --- Nome:");
		rank6 = new JLabel("Pontuaçao:");
		rank7 = new JLabel("Pontuaçao:");
		rank8 = new JLabel("Pontuaçao:");
		rank9 = new JLabel("Pontuaçao:");
		rank10 = new JLabel("Pontuaçao:");
		sep = new JSeparator();
		sep1 = new JSeparator(SwingConstants.VERTICAL);
		nivel = new JComboBox<String>();
		//adicionando botoes, labels ao frame
		nivel.addItem("Facil");
		nivel.addItem("Médio");
		nivel.addItem("Dificil");
		/*painel.add(sep);
		painel.add(sep1);
		painel.add(nivel);
		painel.add(iniciar);
		painel.add(sair);
		painel.add(ajuda);
		painel.add(bonus);
		painel.add(paused);
		painel.add(rank1);
		painel.add(rank2);
		painel.add(rank3);
		painel.add(rank4);
		painel.add(rank5);
		painel.add(rank6);
		painel.add(rank7);
		painel.add(rank8);
		painel.add(rank9);
		painel.add(rank10);
		painel.add(lnivel);
		painel.add(lnome);*/
		comp.getPaused().setForeground(Color.white); 
		// action listener pra cada botao

		comp.getIniciar().addActionListener(this);
		comp.getSair().addActionListener(this);
		comp.getAjuda().addActionListener(this);
		inicio();
	}

	// metodo que define as variaveis para o inicio do jogo
	public void inicio(){

		jFrame.add(painel.makePanel());
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
		timer.start();

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
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		comp.getIniciar().setFocusable(false);
		comp.getSair().setFocusable(false);
		comp.getAjuda().setFocusable(false);
		comp.getNivel().setFocusable(false);
		comp.getSep().setFocusable(false);
		comp.getSep1().setFocusable(false);
		//botao iniciar 		
		if (arg0.getSource() == comp.getIniciar()){

			nome = JOptionPane.showInputDialog("Qual seu Nome ??");
			comp.getLnome().setText("Jogador:  "+nome);
			switch(comp.getNivel().getSelectedIndex()){
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
		if (arg0.getSource() == comp.getSair()){
			System.exit(0);
		}
		//botao ajuda
		if (arg0.getSource() == comp.getAjuda()){
			JOptionPane.showMessageDialog(null, "O clássico jogo Snake onde você tem de pegar comida\nsem bater nas paredes, no seu próprio corpo ou em obstaculos.\nA cada 20 pontos o jogador recebe uma vida como bonus.\nAs teclas direcionais controlam o jogo.\nA tecla espaço pausa o jogo.");
		}

		painel.repaint();
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
						comp.getBonus().setText("Voce perdeu uma vida !!!!");

					}
				// se bateu na parade de baixo
				if(direcao == DOWN)
					if(head.y +1 <= 48 && batercausa(head.x, head.y + 1) && batObs(head.x, head.y + 1)){
						head = new Point(head.x, head.y + 1);

					}else{
						vida--;
						comp.getBonus().setText("Voce perdeu uma vida !!!!");

					}
				// se bateu na parade da esquerda
				if(direcao == LEFT)
					if(head.x -1 >= 0 && batercausa(head.x - 1, head.y) && batObs(head.x - 1, head.y)){
						head = new Point(head.x - 1, head.y);
					}else{
						vida--;
						comp.getBonus().setText("Voce perdeu uma vida !!!!");

					}
				// se bateu na parade da direita
				if(direcao == RIGHT)
					if(head.x + 1 <= 69 && batercausa(head.x + 1, head.y) && batObs(head.x + 1, head.y)){
						head = new Point(head.x + 1, head.y);
					}else{
						vida--;
						comp.getBonus().setText("Voce perdeu uma vida !!!!");


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
						comp.getBonus().setText("");
					}
				}
				//se pontos maior que 20 ganha nova vida
				if(pontosbonus == 20){
					vida++;
					pontosbonus = 0;
					comp.getBonus().setText("Voce ganhou uma vida !!!!");
				}	
			}
		}
		//se nao possui mais vidas, Game over !!!
		else {
			vida = 0;
			JOptionPane.showMessageDialog(null, "GAME OVER !!!");
			comp.getBonus().setText("");
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
		comp.getRank1().setText("1º --- Nome: "+ rank.get(0).nome);
		comp.getRank2().setText("2º --- Nome: " + rank.get(1).nome);
		comp.getRank3().setText("3º --- Nome: " + rank.get(2).nome);
		comp.getRank4().setText("4º --- Nome: " + rank.get(3).nome);
		comp.getRank5().setText("5º --- Nome: " + rank.get(4).nome);
		comp.getRank6().setText("Pontuação: " + rank.get(0).pontos());
		comp.getRank7().setText("Pontuação: " + rank.get(1).pontos());
		comp.getRank8().setText("Pontuação: " + rank.get(2).pontos());
		comp.getRank9().setText("Pontuação: " + rank.get(3).pontos());
		comp.getRank10().setText("Pontuação: " + rank.get(4).pontos());

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
				comp.getBonus().setText("Voce perdeu uma vida !!!!");
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
				comp.getBonus().setText("Voce perdeu uma vida !!!!");
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
			comp.getPaused().setText("Jogo Pausado");
		}
		else{
			comp.getPaused().setText("");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}