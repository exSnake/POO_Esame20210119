package it.unisa.noleggio;

public class BadIDException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadIDException() {
		super("Errore id non valido");
	}
	
	
}
