package controles;

import personnage.Joueur;
import affichage.InterfaceTerm;

public class Test {

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur("joueur");
		InterfaceTerm inter = new InterfaceTerm(0);
		
		inter.chargerCarte("../ressources/carte/test");
		
		joueur.seDeplacer(inter.getCarte().getCase(3, 3));
		
		Clavier clavier = new Clavier();
		clavier.setCarte(inter.getCarte());
		clavier.setJoueur(joueur);
		
		while (true) {
			inter.afficher(joueur);
			clavier.saisieDirection();
		}

	}

}
