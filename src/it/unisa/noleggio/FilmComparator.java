package it.unisa.noleggio;

import java.util.Comparator;

public class FilmComparator implements Comparator<Noleggio> {

	@Override
	public int compare(Noleggio o1, Noleggio o2) {
		return 
				o1.getFilmNoleggiato().dammiCodice().compareTo(
						o2.getFilmNoleggiato().dammiCodice()
				);
	}

}
