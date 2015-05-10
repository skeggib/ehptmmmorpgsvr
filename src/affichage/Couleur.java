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
	
	private static boolean loaded = false;
	
	private static void loadCouleurs() {
		if (Couleur.loaded == false) {
			Couleur.loaded = true;
			
			// Apparement il est impossible de colorer du texte sous windows...
			if (DetectOS.Windows()) {
				Couleur.DEFAULT = "";
				Couleur.BLACK = "";
				Couleur.RED = "";
				Couleur.GREEN = "";
				Couleur.YELLOW = "";
				Couleur.BLUE = "";
				Couleur.PURPLE = "";
				Couleur.CYAN = "";
				Couleur.WHITE = "";
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
			}
		}
	}
	
	/**
	 * Renvoi le code couleur à partir du nom de cette couleur (ex: "RED")
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
				default: 
					return Couleur.DEFAULT;
			}
		}
			
		else
			return "";
	}

}
