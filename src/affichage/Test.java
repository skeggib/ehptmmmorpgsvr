package affichage;

import carte.Carte;
import personnage.Joueur;

public class Test {

	public static void main(String[] args) {
				
		Joueur joueur = new Joueur("joueur");
		InterfaceTerm inter = new InterfaceTerm(0);
		
		Carte carte = new Carte();
		carte.chargerFichier("../ressources/carte/test");
		
		inter.setCarte(carte);
		
		joueur.initialiserPos(carte.getCase(3, 2));
		joueur.seDeplacer(carte.getCase(3, 3));
		
		inter.afficher(joueur);
		
	}

}
