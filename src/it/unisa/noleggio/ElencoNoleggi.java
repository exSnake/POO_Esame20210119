package it.unisa.noleggio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ElencoNoleggi {
	
	public ArrayList<Noleggio> noleggi;

	public ElencoNoleggi() {
		this.noleggi = new ArrayList<Noleggio>();
	}
	
	public List<Noleggio> getNoleggi() {
		return new ArrayList<Noleggio>(noleggi);
	}

	public void aggiungiNoleggio(Noleggio n) {
		for (Noleggio noleggio : noleggi) {
			if(noleggio.getFilmNoleggiato().dammiCodice().equals(
					n.getFilmNoleggiato().dammiCodice())
				)
				throw new BadCodeException("Film Gia Presente");
		}	

		this.noleggi.add(n);
		noleggi.sort(new FilmComparator());

	}
	
	public double calcolaPenaliRitardo() {
		double sum = 0;
		for (Noleggio noleggio : noleggi) {
			sum += noleggio.calcolaPenaleNoleggio();
		}
		return sum;
	}
	
	public ArrayList<Noleggio> cerca(String titolo) {
		ArrayList<Noleggio> noleggiList = new ArrayList<>();
		for (Noleggio noleggio : noleggi) {
			if(noleggio.getFilmNoleggiato().dammiTitolo().toLowerCase().contains(titolo.toLowerCase())) {
				noleggiList.add(noleggio);
			}
		}
		return noleggiList;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(String.format("Film Noleggiati: %d%n", noleggi.size()));
		for (Noleggio noleggio : noleggi) {
			str.append(String.format("%s%n", noleggio.toString()));
		}
		return str.toString();
	}
	
	
}
