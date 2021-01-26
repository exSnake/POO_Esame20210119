package it.unisa.gui;

import it.unisa.noleggio.*;

public class NoleggioController {
	private NoleggioGui gui;
	private ElencoNoleggi elencoNoleggi;
	
	public NoleggioController(ElencoNoleggi elencoNoleggi) {
		//Carico l'elenco dei film noleggiati passati al costruttore
		this.elencoNoleggi = elencoNoleggi;
		//Istanzio l'interfaccia grafica
		gui = new NoleggioGui();
		//Aggiungo il listener al tasto cerca dell'interfaccia
		gui.getBtnCerca().addActionListener(e -> onCercaClick());
		//Visualizzo l'interfaccia
		gui.setVisible(true);
	}

	private void onCercaClick() {
		StringBuilder str = new StringBuilder();
		String titolo = gui.getTxtTitolo().getText();
		//Pulisco la casella dei dettagli
		gui.getTxtDettagli().setText("");
		if(titolo.equals("")) {
			for (Noleggio n : elencoNoleggi.getNoleggi()) {
				str.append(n.toString());
				str.append("\n");
			}
		} else {
			for (Noleggio n : elencoNoleggi.cerca(titolo)) {
				str.append(n.toString());
				str.append("\n");
			}
		}
		//Inserisco i dettagli dei noleggi nella casella txtDettagli
		gui.getTxtDettagli().setText(str.toString());
	}
}
