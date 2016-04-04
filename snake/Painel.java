package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painel extends JPanel {

	public static Color verde = new Color(1066076);

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(verde);
		g.fillRect(0, 0, 700, 490);
		Snake snake = Snake.Snake;
		g.setColor(Color.RED);		

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

			snake.data.iniciar.setBounds(790, 75, 90, 25);
			snake.data.sair.setBounds(890, 75, 70, 25);
			snake.data.ajuda.setBounds(790, 115, 90, 25);
			snake.data.nivel.setBounds(710, 75, 65, 25);
			snake.data.lnome.setBounds(710, 20, 240, 20);
			snake.data.bonus.setBounds(710, 140, 240, 20);
			snake.data.paused.setBounds(310, 180, 240, 50);
			snake.data.lnivel.setBounds(710, 55, 240, 20);
			snake.data.rank1.setBounds(710, 200, 240, 20);
			snake.data.rank2.setBounds(710, 220, 240, 20);
			snake.data.rank3.setBounds(710, 240, 240, 20);
			snake.data.rank4.setBounds(710, 260, 240, 20);
			snake.data.rank5.setBounds(710, 280, 240, 20);
			snake.data.rank6.setBounds(850, 200, 240, 20);
			snake.data.rank7.setBounds(850, 220, 240, 20);
			snake.data.rank8.setBounds(850, 240, 240, 20);
			snake.data.rank9.setBounds(850, 260, 240, 20);
			snake.data.rank10.setBounds(850, 280, 240, 20);
			snake.data.sep.setBounds(706, 160, 280, 20);
			snake.data.sep1.setBounds(703, 10, 10, 470);

		} catch(Exception e){

		}
	}
}
