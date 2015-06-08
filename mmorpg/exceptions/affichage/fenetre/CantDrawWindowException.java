package mmorpg.exceptions.affichage.fenetre;

public class CantDrawWindowException extends Exception {
	private static final long serialVersionUID = 1L;

	public CantDrawWindowException() {
		super();
	}
	
	public CantDrawWindowException(String message) {
		super("Impossible de dessiner la fenetre : " + message);
	}
	
	public CantDrawWindowException(String message, Throwable cause) {
		super("Impossible de dessiner la fenetre : " + message, cause);
	}
	
	public CantDrawWindowException(Throwable cause) {
		super(cause);
	}
}
