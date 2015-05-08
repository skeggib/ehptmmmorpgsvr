package affichage;

import controles.Clavier;
import personnage.Joueur;
import carte.Carte;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("\nChoisissez la taille de l'interface : ");
		System.out.println("    1. Grande");
		System.out.println("    2. Moyenne");
		System.out.println("    3. Petite");
		System.out.print("Votre choix : ");
		int tailleInterface = Clavier.saisieInt();
		
		Carte carte = new Carte("ressources/carte/test");
		
		Joueur joueur = new Joueur();
		joueur.setPositionX(3);
		joueur.setPositionY(3);
		joueur.setCarte(carte);
		
		InterfaceTerm inter = new InterfaceTerm(tailleInterface - 1);
		inter.setJoueur(joueur);
		inter.setCarte(carte);
		
		while (true) {
			inter.afficher();
			System.out.println("VIE DU JOUEUR : " + joueur.getVie().getVie());
			joueur.realiserAction(Clavier.saisieDirection());
		}
		
	}

}
