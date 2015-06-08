package mmorpg.affichage.fenetre;

import mmorpg.exceptions.affichage.fenetre.CantDrawWindowException;

public class Test {

	public static void main(String[] args) {
		
		FenetreFinJeu fen = new FenetreFinJeu();
		try {
			fen.getMatriceFen().afficher();
		} catch (CantDrawWindowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
