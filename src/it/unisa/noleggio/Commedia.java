package it.unisa.noleggio;

public class Commedia extends Film {

	private static final double penale = 2.50;
	
	public Commedia(String titolo, String codice) {
		super(titolo, codice);
	}

	@Override
	public String dammiCodice() {
		return codice;
	}

	@Override
	public String dammiTitolo() {
		return titolo;
	}
	
	public double calcolaPenaleRitardo(int giorni) {
		return giorni * penale;
	}
	
	@Override
	public boolean equals(Object obj) {
		// Se e' lo stesso oggetto ritorna true
		if (obj == this) {
			return true;
		}
		/* Se non e' un istanza di Commedia o obj e' null, ritorna false */
		if (!(obj instanceof Commedia)) {
			return false;
		}
		
		// typecast a Commedia in modo da poterli comparare 
		Commedia film = (Commedia) obj;
		return (this.dammiTitolo().equals(film.dammiTitolo()) && 
				this.dammiCodice().equals(film.dammiCodice())
				);
	}

}
