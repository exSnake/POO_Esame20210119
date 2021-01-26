package it.unisa.noleggio;

public class Noleggio {
	private Film filmNoleggiato;
	private int idCliente;
	private int giorniRitardo;
	
	public Noleggio(Film filmNoleggiato, int idCliente, int giorniRitardo) throws BadIDException {
		if(this.idCliente < 0)
			throw new BadIDException();
		this.filmNoleggiato = filmNoleggiato;
		this.idCliente = idCliente;
		this.giorniRitardo = giorniRitardo;
	}
	
	public Film getFilmNoleggiato() {
		return filmNoleggiato;
	}

	public void setFilmNoleggiato(Film filmNoleggiato) {
		this.filmNoleggiato = filmNoleggiato;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public double calcolaPenaleNoleggio() {
		return this.filmNoleggiato.calcolaPenaleRitardo(giorniRitardo);
	}

	@Override
	public String toString() {
		return 	filmNoleggiato.dammiTitolo() + 
				" - IDFilm: " + filmNoleggiato.dammiCodice() +
				" - IDCliente: " + idCliente;
				
	}

	@Override
	public boolean equals(Object obj) {
		// Se e' lo stesso oggetto ritorna true
		if (obj == this) {
			return true;
		}
		/* Se non e' un istanza di Noleggio o obj e' null, ritorna false */
		if (!(obj instanceof Noleggio)) {
			return false;
		}
		// typecast a Noleggio in modo da poterli comparare 
		Noleggio noleggio = (Noleggio) obj;
		
		
		return this.filmNoleggiato.equals(noleggio.getFilmNoleggiato()) &&
				this.idCliente == noleggio.idCliente &&
				this.giorniRitardo == noleggio.giorniRitardo;
	}
	
	
	
}
