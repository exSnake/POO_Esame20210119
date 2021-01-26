package it.unisa.noleggio;

public class BadCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadCodeException() {
		super("Errore nel codice noleggio");
	}
	
	public BadCodeException(String str) {
		super(str);
	}
	
}
