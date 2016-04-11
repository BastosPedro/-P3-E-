package snake;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Componets {

	private JSeparator sep, sep1;
	public JButton iniciar, sair, ajuda;
	public JComboBox<String> nivel;
	public JLabel lnivel, lnome, bonus, paused,rank1,rank2,rank3,rank4,rank5,rank6,rank7,rank8,rank9,rank10;

	public Componets() {

		//definiçoes botoes, labels, combobox ...
		this.iniciar = new JButton("Iniciar");
		this.sair = new JButton("Sair");
		this.ajuda = new JButton("Ajuda");
		this.lnivel = new JLabel("Nivel");
		this.lnome = new JLabel("");
		this.bonus = new JLabel("");
		this.paused = new JLabel("");
		this.rank1 = new JLabel("1º --- Nome:");
		this.rank2 = new JLabel("2º --- Nome:");
		this.rank3 = new JLabel("3º --- Nome:");
		this.rank4 = new JLabel("4º --- Nome:");
		this.rank5 = new JLabel("5º --- Nome:");
		this.rank6 = new JLabel("Pontuaçao:");
		this.rank7 = new JLabel("Pontuaçao:");
		this.rank8 = new JLabel("Pontuaçao:");
		this.rank9 = new JLabel("Pontuaçao:");
		this.rank10 = new JLabel("Pontuaçao:");
		this.sep = new JSeparator();
		this.sep1 = new JSeparator(SwingConstants.VERTICAL);
		this.nivel = new JComboBox<String>();
		//adicionando botoes, labels ao frame
		this.nivel.addItem("Facil");
		this.nivel.addItem("Médio");
		this.nivel.addItem("Dificil");
	}

	public JSeparator getSep() {
		return sep;
	}

	public JSeparator getSep1() {
		return sep1;
	}

	public JButton getIniciar() {
		return iniciar;
	}

	public JButton getSair() {
		return sair;
	}

	public JButton getAjuda() {
		return ajuda;
	}

	public JComboBox<String> getNivel() {
		return nivel;
	}

	public JLabel getLnivel() {
		return lnivel;
	}

	public JLabel getLnome() {
		return lnome;
	}

	public JLabel getBonus() {
		return bonus;
	}

	public JLabel getPaused() {
		return paused;
	}

	public JLabel getRank1() {
		return rank1;
	}

	public JLabel getRank2() {
		return rank2;
	}

	public JLabel getRank3() {
		return rank3;
	}

	public JLabel getRank4() {
		return rank4;
	}

	public JLabel getRank5() {
		return rank5;
	}

	public JLabel getRank6() {
		return rank6;
	}

	public JLabel getRank7() {
		return rank7;
	}

	public JLabel getRank8() {
		return rank8;
	}

	public JLabel getRank9() {
		return rank9;
	}

	public JLabel getRank10() {
		return rank10;
	}

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
}
