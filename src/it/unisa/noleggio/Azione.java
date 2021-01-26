package it.unisa.noleggio;

public class Azione extends Film {
	
	private static final double penale = 3.00;
	
	public Azione(String titolo, String codice) {
		super(titolo, codice);
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
		/* Se non e' un istanza di Azione o obj e' null, ritorna false */
		if (!(obj instanceof Azione)) {
			return false;
		}
		// typecast a Azione in modo da poterli comparare 
		Azione film = (Azione) obj;
		return (this.dammiTitolo().equals(film.dammiTitolo()) && 
				this.dammiCodice().equals(film.dammiCodice())
				);
	}

}
