package affichage;

import os.DetectOS;

public class Couleur {
	
	private static String DEFAULT;
	
	private static String BLACK;
	private static String RED;
	private static String GREEN;
	private static String YELLOW;
	private static String BLUE;
	private static String PURPLE;
	private static String CYAN;
	private static String WHITE;
	
	private static String BACK_BLACK;
	private static String BACK_RED;
	private static String BACK_GREEN;
	private static String BACK_YELLOW;
	private static String BACK_BLUE;
	private static String BACK_PURPLE;
	private static String BACK_CYAN;
	private static String BACK_WHITE;
	
	private static boolean loaded = false;
	
	private static void loadCouleurs() {
		if (Couleur.loaded == false) {
			Couleur.loaded = true;
			
			// Apparement il est impossible de colorer du texte sous windows...
			if (DetectOS.Windows()) {
				Couleur.DEFAULT = "";
				
				Couleur.BLACK = "\033[30m";
				Couleur.RED = "\033[31m";
				Couleur.GREEN = "\033[32m";
				Couleur.YELLOW = "\033[33m";
				Couleur.BLUE = "\033[34m";
				Couleur.PURPLE = "\033[35m";
				Couleur.CYAN = "\033[36m";
				Couleur.WHITE = "\033[37m";
				
				Couleur.BACK_BLACK = "";
				Couleur.BACK_RED = "";
				Couleur.BACK_GREEN = "";
				Couleur.BACK_YELLOW = "";
				Couleur.BACK_BLUE = "";
				Couleur.BACK_PURPLE = "";
				Couleur.BACK_CYAN = "";
				Couleur.BACK_WHITE = "";
			}
			
			else if (DetectOS.Unix()) {
				Couleur.DEFAULT = "\u001B[0m";
				
				Couleur.BLACK = "\u001B[30m";
				Couleur.RED = "\u001B[31m";
				Couleur.GREEN = "\u001B[32m";
				Couleur.YELLOW = "\u001B[33m";
				Couleur.BLUE = "\u001B[34m";
				Couleur.PURPLE = "\u001B[35m";
				Couleur.CYAN = "\u001B[36m";
				Couleur.WHITE = "\u001B[37m";
				
				Couleur.BACK_BLACK = "\u001B[40m";
				Couleur.BACK_RED = "\u001B[41m";
				Couleur.BACK_GREEN = "\u001B[42m";
				Couleur.BACK_YELLOW = "\u001B[43m";
				Couleur.BACK_BLUE = "\u001B[44m";
				Couleur.BACK_PURPLE = "\u001B[45m";
				Couleur.BACK_CYAN = "\u001B[46m";
				Couleur.BACK_WHITE = "\u001B[47m";
			}
			
			else {
				Couleur.DEFAULT = "";
				
				Couleur.BLACK = "";
				Couleur.RED = "";
				Couleur.GREEN = "";
				Couleur.YELLOW = "";
				Couleur.BLUE = "";
				Couleur.PURPLE = "";
				Couleur.CYAN = "";
				Couleur.WHITE = "";
				
				Couleur.BACK_BLACK = "";
				Couleur.BACK_RED = "";
				Couleur.BACK_GREEN = "";
				Couleur.BACK_YELLOW = "";
				Couleur.BACK_BLUE = "";
				Couleur.BACK_PURPLE = "";
				Couleur.BACK_CYAN = "";
				Couleur.BACK_WHITE = "";
			}
		}
	}
	
	/**
	 * Renvoi le code couleur a partir du nom de cette couleur (ex: "RED")
	 * @param str Nom de la couleur
	 * @return Code couleur
	 */
	public static String getCouleur(String str) {
		Couleur.loadCouleurs();
		
		if (Couleur.loaded) {
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
				case "BACK_BLACK":
					return Couleur.BACK_BLACK;
				case "BACK_RED":
					return Couleur.BACK_RED;
				case "BACK_GREEN":
					return Couleur.BACK_GREEN;
				case "BACK_YELLOW":
					return Couleur.BACK_YELLOW;
				case "BACK_BLUE":
					return Couleur.BACK_BLUE;
				case "BACK_PURPLE":
					return Couleur.BACK_PURPLE;
				case "BACK_CYAN":
					return Couleur.BACK_CYAN;
				case "BACK_WHITE":
					return Couleur.BACK_WHITE;
				default: 
					return Couleur.DEFAULT;
			}
		}
			
		else
			return "";
	}

}
