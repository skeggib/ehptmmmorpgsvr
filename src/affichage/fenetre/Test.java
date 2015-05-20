package affichage.fenetre;

import personnage.Joueur;

public class Test {

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur("Name");
		
		FenetreInfosJoueur fen = new FenetreInfosJoueur(20, 20);
		fen.setJoueur(joueur);
		
		fen.getMatriceFen().afficher();

	}

}
