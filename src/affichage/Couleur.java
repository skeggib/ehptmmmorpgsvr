package affichage;

public class Couleur {
	public static final String DEFAULT = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	/**
	 * Renvoi le code couleur à partir du nom de cette couleur (ex: "RED")
	 * @param str Nom de la couleur
	 * @return Code couleur
	 */
	public static String getCouleurFromString(String str) {
		switch (str) {
			case "DEFAULT":
				return Couleur.DEFAULT;
			case "BLACK":
				return Couleur.BLACK;
			case "RED":
				return Couleur.RED;
			case "GREEN":
				return Couleur.GREEN;
			case "YELLOW":
				return Couleur.YELLOW;
			case "BLUE":
				return Couleur.BLUE;
			case "PURPLE":
				return Couleur.PURPLE;
			case "CYAN":
				return Couleur.CYAN;
			case "WHITE":
				return Couleur.WHITE;
			default: 
				return Couleur.DEFAULT;
		}
	}
}