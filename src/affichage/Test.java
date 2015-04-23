package affichage;

import controles.Clavier;
import personnage.Joueur;
import carte.Carte;

public class Test {

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur();
		joueur.setPositionX(18);
		joueur.setPositionY(18);
		Carte carte = new Carte("");
		InterfaceTerm inter = new InterfaceTerm();
		inter.setJoueur(joueur);
		inter.setCarte(carte);
		
		while (true) {
			inter.afficher();
			joueur.seDeplacer(Clavier.saisieDirection());
		}
		
	}

}
