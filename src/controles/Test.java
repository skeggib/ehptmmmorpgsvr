package controles;

import carte.Carte;
import personnage.Joueur;
import affichage.InterfaceTerm;

public class Test {

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur("joueur");
		InterfaceTerm inter = new InterfaceTerm(0);
		
		Carte carte = new Carte();
		carte.chargerFichier("../ressources/carte/test");
		
		inter.setCarte(carte);
		
		joueur.seDeplacer(carte.getCase(3, 3));
		
		Clavier clavier = new Clavier();
		clavier.setCarte(carte);
		clavier.setJoueur(joueur);
		
		while (true) {
			inter.afficher(joueur);
			clavier.saisieDirection();
		}

	}

}
