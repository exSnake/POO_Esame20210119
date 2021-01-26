package it.unisa.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import it.unisa.noleggio.*;

public class NoleggioStarter {
	final static String AZIONE = "Azione";
	final static String COMMEDIA = "Commedia";
	final static String GENERICO = "Generico";
	
	public static void main(String[] args) {
		//Carico i film noleggiati da un film per test
		//il file deve essere del tipo: TipoFilm,Titolo,CodiceFilm,IdCliente\n
		ElencoNoleggi elencoNoleggi = loadFromFile();
		//Istanzio il controller della GUI
		new NoleggioController(elencoNoleggi);
	}

	private static ElencoNoleggi loadFromFile() {
		ElencoNoleggi nlst = new ElencoNoleggi();
		File myObj = new File("listaFilmNoleggiati.txt"); //Prende il path dalla main dir
		Random rnd = new Random(); //per generare randomicamente l'id del cliente
		//try con chiusura automatica dello scanner
		try (Scanner myReader = new Scanner(myObj)) {
			while (myReader.hasNextLine()) {
				Film fm = null;
				String data = myReader.nextLine();
				String[] split = data.split(",");
				if(split[0].equals(AZIONE)) {
					fm = new Azione(split[1],split[2]);
				} else if (split[0].equals(COMMEDIA)) {
					fm = new Commedia(split[1],split[2]);
				} else if (split[0].equals(GENERICO)){
					fm = new Film(split[1], split[2]);
				}
				Noleggio n = new Noleggio(fm,Integer.parseInt(split[3]), rnd.nextInt(10));
				nlst.aggiungiNoleggio(n);
			}
		} catch (FileNotFoundException | NumberFormatException | BadIDException e) {
			e.printStackTrace();
		}
		return nlst;
	}

}
