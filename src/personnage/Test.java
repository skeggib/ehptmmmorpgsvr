package personnage;

import java.util.Random;

import items.Arme;
import items.Nom;
import items.PotionDeSoin;

public class Test {

	public static void main(String[] args) {

		Random rand = new Random();

		Joueur joueur = new Joueur ();
		Joueur joueur1 = new Joueur ();
		
		
		/**
		 * DECOMENTE CE QUI SUIS POUR TESTER UNE ATTAQUE
		 * ET LE SOIN D'UNE CIBLE
		 */

		/*
		Joueur cible = new Joueur ();
		cible.getCaracteristique().setForce(5);
		cible.getCaracteristique().setAdresse(5);
		cible.getCaracteristique().setResistance(5);
		joueur.getCaracteristique().setForce(5);
		joueur.getCaracteristique().setAdresse(5);
		joueur.getCaracteristique().setResistance(5);

		System.out.println("\n   vie avant attaque : " + cible.getVie().getVie() + "\n");
		joueur.attaquer(cible);
		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
		joueur.attaquer(cible);
		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
		joueur.attaquer(cible);
		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");

		cible.getVie().ajouterVie(6);

		System.out.println("\n   vie apres soin de la cible : " + cible.getVie().getVie() + "\n");
		System.out.println(rand.nextInt(3) + 1);
		*/

		
		
		/**
		 * DECOMMENTER CE QUI SUIT POUR TESTER L'AJOUT 
		 * ET LA SUPPRESSION D'UN OBJET DANS L'INVENTAIRE
		 * L'AJOUT ET LA SUPPRESION SONT CONTROLE
		 */
		
		/*
		PotionDeSoin potion1 = new PotionDeSoin();
		PotionDeSoin potion2 = new PotionDeSoin();
		PotionDeSoin potion3 = new PotionDeSoin();
		Arme arme = new Arme();
		Arme arme1 = new Arme();
		Arme arme2 = new Arme();
		Arme arme3 = new Arme();
		
		joueur.getInventaire().ajouterObjet(potion1);
		joueur.getInventaire().ajouterObjet(arme);
		joueur.getInventaire().ajouterObjet(potion2);
		joueur.getInventaire().ajouterObjet(arme1);
		joueur.getInventaire().ajouterObjet(potion3);
		joueur.getInventaire().ajouterObjet(arme2);
		joueur.getInventaire().ajouterObjet(arme3);
		System.out.println("Voici l'inventaire du joueur : "); 
		System.out.println("\n" + joueur.getInventaire().inventaireToString());
		joueur.getInventaire().deposerObjet(potion2);
		System.out.println("\n\nOn a retire la deuxieme potion, resultat : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());
		

		System.out.println("\n\nOn equipe le joueur de l'arme 1 et 2 presente dans son inventaire");
		joueur.getInventaire().equiperObjet(arme);
		joueur.getInventaire().equiperObjet(arme2);
		System.out.println("\nOn affiche les objets equipé par le joueur : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());

		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());

		System.out.println("\n\nOn essaye de rééquipé le joueur de la premiere arme qu'il a équipé \n(logiqement impossible puisque sont arme n'est plus dans l'inventaire)");
		joueur.getInventaire().equiperObjet(arme);

		System.out.println("\nOn affiche ses objets equipe : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());
		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());
		
		System.out.println("\n\nOn équipe le joueur d'une autre arme qui est dans son inventaire\n(Impossible puisqu'il a deja deux arme equipe)");
		joueur.getInventaire().equiperObjet(arme3);

		System.out.println("\nOn affiche ses objets equipe : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());
		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());

		
		System.out.println("\n\nOn deséquipe le joueur d'une arme");
		joueur.getInventaire().desequiperObjet(arme);

		System.out.println("\nOn affiche ses objets equipe : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());
		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());
		*/
	}
}


