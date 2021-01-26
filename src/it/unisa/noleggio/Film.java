package it.unisa.noleggio;

public class Film implements Cloneable {
	private final static double penale = 2.00;
	protected String codice;
	protected String titolo;
	
	public Film(String titolo, String codice) {
		this.codice = codice;
		this.titolo = titolo;
	}
	
	public String dammiCodice() {
		return this.codice;
	}
	public String dammiTitolo() {
		return this.titolo;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public double calcolaPenaleRitardo(int giorniRitardo) {
		return giorniRitardo * penale;
	}

	@Override
	public boolean equals(Object obj) {
		// Se e' lo stesso oggetto ritorna true
		if (obj == this) {
			return true;
		}
		/* Se non e' un istanza di Film o obj e' null, ritorna false */
		if (!(obj instanceof Film)) {
			return false;
		}
		
		// typecast a Film in modo da poterli comparare 
		Film film = (Film) obj;
		return (this.dammiTitolo().equals(film.dammiTitolo()) && 
				this.dammiCodice().equals(film.dammiCodice())
				);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + 
				"\nTitolo" + this.dammiTitolo() + 
				"\nCodice" + this.dammiCodice();
	}

	@Override
	protected Film clone() throws CloneNotSupportedException {
		Film fm = new Film(dammiTitolo(), dammiCodice());
		return fm;
	}
	
	

}
