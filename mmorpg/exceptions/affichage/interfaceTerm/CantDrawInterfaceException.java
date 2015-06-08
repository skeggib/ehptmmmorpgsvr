package mmorpg.exceptions.affichage.interfaceTerm;

public class CantDrawInterfaceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CantDrawInterfaceException() {
		super();
	}
	
	public CantDrawInterfaceException(String message) {
		super(message);
	}
	
	public CantDrawInterfaceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CantDrawInterfaceException(Throwable cause) {
		super(cause);
	}

}
