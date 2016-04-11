package snake;

import javax.swing.JPanel;
/*PROXY DESIGN PATTERN WAS HERE*/

@SuppressWarnings("serial")
public class ProxyPanel extends JPanel implements InterfacePanel{

	private Painel panel;
	private Componets comp;
	
	public ProxyPanel(Componets comp) {

		this.comp = comp;
	}
	
	@Override
	public Painel makePanel() {
		
			this.panel = new Painel(comp);
			panel.add(comp.getSep());
			panel.add(comp.getSep1());
			panel.add(comp.getNivel());
			panel.add(comp.getIniciar());
			panel.add(comp.getSair());
			panel.add(comp.getAjuda());
			panel.add(comp.getBonus());
			panel.add(comp.getPaused());
			panel.add(comp.getRank1());
			panel.add(comp.getRank2());
			panel.add(comp.getRank3());
			panel.add(comp.getRank4());
			panel.add(comp.getRank5());
			panel.add(comp.getRank6());
			panel.add(comp.getRank7());
			panel.add(comp.getRank8());
			panel.add(comp.getRank9());
			panel.add(comp.getRank10());
			panel.add(comp.getLnivel());
			panel.add(comp.getLnome());

		
		return panel;

	}

}
