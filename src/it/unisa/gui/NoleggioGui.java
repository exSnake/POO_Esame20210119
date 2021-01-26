package it.unisa.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class NoleggioGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel paneContent;
	private JButton btnCerca;
	private JTextField txtTitolo;
	private JTextArea txtDettagli;
	
	public NoleggioGui() {
		initialize();
	}

	private void initialize() {
		//Fase 1 Inizializzazione del frame
		//Dimensione del frame e centramento nello schermo
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension(600, 400);
		setBounds(ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width,
				frameSize.height);
		//Titolo Frame
		setTitle("Ricerca Film");
		//Exposed panel
		paneContent = new JPanel();
		//Padding del frame
		paneContent.setBorder(new EmptyBorder(5, 30, 30, 30));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Panello principale del JFrame
		setContentPane(paneContent);
		GridBagLayout gbc = new GridBagLayout();
		//numero colonne (arr.length) e width minimo
		gbc.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		//peso colonne, 1.0 = Grow per riempire lo spazio restante in orizzontale
		gbc.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		//numero righe (arr.length) e width minimo
		gbc.rowHeights = new int[] { 0, 0 };
		//peso righe, 1.0 = Grow per riempire lo spazio restante in verticale
		gbc.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		paneContent.setLayout(gbc);
		
		//Fase 2 Inserimento dei componenti nel frame
		//Label Film
		GridBagConstraints lblFilmGbc = new GridBagConstraints();
		JLabel lblFilm = new JLabel("Film");
		lblFilmGbc.fill = GridBagConstraints.HORIZONTAL;
		lblFilmGbc.gridx = 1;
		lblFilmGbc.gridy = 0;
		lblFilmGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(lblFilm, lblFilmGbc);
		
		//Text Field Titolo
		GridBagConstraints txtTitoloGbc = new GridBagConstraints();
		txtTitolo = new JTextField();
		txtTitoloGbc.fill = GridBagConstraints.HORIZONTAL;
		txtTitoloGbc.gridx = 2;
		txtTitoloGbc.gridy = 0;
		txtTitoloGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(txtTitolo, txtTitoloGbc);
		
		//Button Cerca
		GridBagConstraints btnCercaGbc = new GridBagConstraints();
		btnCerca = new JButton("Cerca");
		btnCercaGbc.fill = GridBagConstraints.BOTH;
		btnCercaGbc.gridx = 3;
		btnCercaGbc.gridy = 0;
		btnCercaGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(btnCerca, btnCercaGbc);
		
		//Text Area Dettagli
		GridBagConstraints txtDettagliGbc = new GridBagConstraints();
		txtDettagli = new JTextArea();
		txtDettagli.append("");
		//Bordo Nero alla txt area
		txtDettagli.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(50, 50, 50), new Color(255, 255, 255)));
		txtDettagliGbc.fill = GridBagConstraints.BOTH;
		txtDettagliGbc.gridx = 0;
		txtDettagliGbc.gridy = 1;
		txtDettagliGbc.gridwidth = 5;
		txtDettagliGbc.insets = new Insets(5, 5, 5, 5);
		txtDettagli.setEditable(false);
		paneContent.add(txtDettagli, txtDettagliGbc);
		
		//Fine
	}

	/**
	 * Componenti Esposti per poterli gestire dalla classe NoleggioController
	 */
	public JButton getBtnCerca() {
		return btnCerca;
	}

	public JTextField getTxtTitolo() {
		return txtTitolo;
	}

	public JTextArea getTxtDettagli() {
		return txtDettagli;
	}

}
