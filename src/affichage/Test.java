package affichage;

import personnage.Joueur;
import affichage.fenetre.FenetreCarte;
import carte.Carte;

public class Test {

	public static void main(String[] args) {
		
		Carte carte = new Carte();
		carte.chargerFichier("../ressources/carte/test");
		
		Joueur joueur = new Joueur("default");
		joueur.initialiserPos(carte.getCase(3, 3));
		
		FenetreCarte fen = new FenetreCarte(0);
		fen.setCarte(carte);
		fen.setJoueur(joueur);
		System.out.println(fen);
		Matrice matr = new Matrice(80, 40);
		
		matr.dessinerFenetre(1, 1, fen);
		
		matr.afficher();
		
	}

}
