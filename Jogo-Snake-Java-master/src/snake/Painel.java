package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

@SuppressWarnings("serial")
public class Painel extends ProxyPanel {
	
	private Color color;
	private Componets comp;
	Graphics g ;
	
	public Painel(Componets comp) {
		
		super(comp);
		this.g = null;
		this.comp = comp;
		this.color  = new Color(100,150,100);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(0, 0, 700, 490);
		Snake snake = Snake.Snake;
		g.setColor(Color.BLACK);		

		try{
			for (Point point : snake.partsSnake){
				g.fillRect(point.x * Snake.ESCALA, point.y * Snake.ESCALA, Snake.ESCALA, Snake.ESCALA);
			}
			g.fillRect(snake.head.x * Snake.ESCALA, snake.head.y * Snake.ESCALA, Snake.ESCALA, Snake.ESCALA);

			g.setColor(Color.WHITE);
			g.fillRect(snake.comida.x * Snake.ESCALA, snake.comida.y * Snake.ESCALA, Snake.ESCALA, Snake.ESCALA);

			g.setColor(Color.ORANGE);
			for (Point point : snake.obs){
				g.fillRect(point.x * Snake.ESCALA, point.y * Snake.ESCALA, Snake.ESCALA, Snake.ESCALA);
			}

			String string = "Pontos: " + snake.pontos + "    Tempo: " + snake.tempo /20+ "  Vidas: " + snake.vida;
			g.setColor(Color.BLACK);
			g.drawString(string,(int)(getWidth()/1 - string.length()*8), 180);

			comp.getIniciar().setBounds(790, 75, 90, 25);
			comp.getSair().setBounds(890, 75, 70, 25);
			comp.getAjuda().setBounds(790, 115, 90, 25);
			comp.getNivel().setBounds(710, 75, 65, 25);
			comp.getLnome().setBounds(710, 20, 240, 20);
			comp.getBonus().setBounds(710, 140, 240, 20);
			comp.getPaused().setBounds(310, 180, 240, 50);
			comp.getLnivel().setBounds(710, 55, 240, 20);
			comp.getRank1().setBounds(710, 200, 240, 20);
			comp.getRank2().setBounds(710, 220, 240, 20);
			comp.getRank3().setBounds(710, 240, 240, 20);
			comp.getRank4().setBounds(710, 260, 240, 20);
			comp.getRank5().setBounds(710, 280, 240, 20);
			comp.getRank6().setBounds(850, 200, 240, 20);
			comp.getRank7().setBounds(850, 220, 240, 20);
			comp.getRank8().setBounds(850, 240, 240, 20);
			comp.getRank9().setBounds(850, 260, 240, 20);
			comp.getRank10().setBounds(850, 280, 240, 20);
			comp.getSep().setBounds(706, 160, 280, 20);
			comp.getSep1().setBounds(703, 10, 10, 470);

		} catch(Exception e){

		}
	}
}
