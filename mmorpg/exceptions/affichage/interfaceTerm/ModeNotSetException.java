package mmorpg.exceptions.affichage.interfaceTerm;

public class ModeNotSetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ModeNotSetException() {
		super();
	}
	
	public ModeNotSetException(String message) {
		super(message);
	}
	
	public ModeNotSetException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ModeNotSetException(Throwable cause) {
		super(cause);
	}
	
}
