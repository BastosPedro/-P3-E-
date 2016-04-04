package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SnakeMenu {
	public JFrame jFrame;
	public JButton iniciar;
	public JButton sair;
	public JButton ajuda;
	public JComboBox<String> nivel;
	public JSeparator sep;
	public JSeparator sep1;
	public JLabel lnivel;
	public JLabel lnome;
	public JLabel bonus;
	public JLabel paused;
	public JLabel rank1;
	public JLabel rank2;
	public JLabel rank3;
	public JLabel rank4;
	public JLabel rank5;
	public JLabel rank6;
	public JLabel rank7;
	public JLabel rank8;
	public JLabel rank9;
	public JLabel rank10;
	public Painel painel;
	public Timer timer;
	public Dimension dim;

	public SnakeMenu(Timer timer) {
		this.FrameDefining();
		this.ButtonDefining();
		this.AddButtons();
		this.timer = timer;
	}
	public void FrameDefining(){
		// defini�oes do frame 
		this.dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.jFrame = new JFrame("Snake");
		this.jFrame.setVisible(true);
		this.jFrame.setSize(995, 519);
		this.jFrame.setResizable(false);
		this.jFrame.setLocation(this.dim.width / 2 - this.jFrame.getWidth() / 2, 
								this.dim.height / 2 - this.jFrame.getHeight() / 2);
		this.jFrame.add(this.painel = new Painel());
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void ButtonDefining(){
		//defini�oes botoes, labels, combobox ...
		this.iniciar = new JButton("Iniciar");
		this.sair = new JButton("Sair");
		this.ajuda = new JButton("Ajuda");
		this.lnivel = new JLabel("Nivel");
		this.lnome = new JLabel("");
		this.bonus = new JLabel("");
		this.paused = new JLabel("");
		this.rank1 = new JLabel("1� --- Nome:");
		this.rank2 = new JLabel("2� --- Nome:");
		this.rank3 = new JLabel("3� --- Nome:");
		this.rank4 = new JLabel("4� --- Nome:");
		this.rank5 = new JLabel("5� --- Nome:");
		this.rank6 = new JLabel("Pontua�ao:");
		this.rank7 = new JLabel("Pontua�ao:");
		this.rank8 = new JLabel("Pontua�ao:");
		this.rank9 = new JLabel("Pontua�ao:");
		this.rank10 = new JLabel("Pontua�ao:");
		this.sep = new JSeparator();
		this.sep1 = new JSeparator(SwingConstants.VERTICAL);
		this.nivel = new JComboBox<String>();
	}
	public void AddButtons(){
		//adicionando botoes, labels ao frame
		this.nivel.addItem("Facil");
		this.nivel.addItem("M�dio");
		this.nivel.addItem("Dificil");
		this.painel.add(this.sep);
		this.painel.add(this.sep1);
		this.painel.add(this.nivel);
		this.painel.add(this.iniciar);
		this.painel.add(this.sair);
		this.painel.add(this.ajuda);
		this.painel.add(this.bonus);
		this.painel.add(this.paused);
		this.painel.add(this.rank1);
		this.painel.add(this.rank2);
		this.painel.add(this.rank3);
		this.painel.add(this.rank4);
		this.painel.add(this.rank5);
		this.painel.add(this.rank6);
		this.painel.add(this.rank7);
		this.painel.add(this.rank8);
		this.painel.add(this.rank9);
		this.painel.add(this.rank10);
		this.painel.add(this.lnivel);
		this.painel.add(this.lnome);
		this.paused.setForeground(Color.white); 
	}
}