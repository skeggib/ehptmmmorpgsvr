package personnage;

import items.Arme;
import items.Casque;
import items.Pantalon;
import items.PotionDeSoin;


//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Random;
//import items.Arme;
//import items.Nom;
//import items.PotionDeSoin;

public class Test {
	public static void main(String[] args) {
		
		
			
//		float x = 10;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		x = 20;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 30;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 40;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 50;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 60;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 70;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 80;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
//		 x = 90;
//		System.out.println(5.00 + (30 * Math.exp(-(40/(x+10)))));
		
		
//				int result;
//		Random rand = new Random();
//				for(int i = 0; i < 5000; i++){
//					result = rand.nextInt(3) + 4;
//						System.out.println(result);
//				}

//		for(int i = 0; i < 1000; i++){
//			Pantalon j = new Pantalon ();
//			System.out.println(j.getEncombrement());
//			System.out.println(j.getQualite());
//			System.out.println(j.getProtection());
//			System.out.println(j.getNom());
//
//		}
//		Joueur joueur = new Joueur ();
//		Joueur joueur1 = new Joueur ();
//		Monstre cible = new Monstre ();
		/*
		String filePath = "src/arme.txt";
		String[] tab = null;
		if(tab == null){
			try{
				// Creation du flux bufferise sur un FileReader, immediatement suivi par un 
				// try/finally, ce qui permet de ne fermer le flux QUE s'il le reader
				// est correctement instancie (evite les NullPointerException)
				BufferedReader buff = new BufferedReader(new FileReader(filePath));

				try {
					String line;
					// Lecture du fichier ligne par ligne. Cette boucle se termine
					// quand la methode retourne la valeur null.
					int i = 0;
					while ((line = buff.readLine()) != null) {
						System.out.println(i + " : " + line);
						i++;
						//faites ici votre traitement
					}
					System.out.println("nombre de ligne : " + (i));
					buff.close();
					buff = new BufferedReader(new FileReader(filePath));
					tab = new String [i]; 
					i = 0;
					while ((line = buff.readLine()) != null) {
						tab[i] = line;
						i++;
						//faites ici votre traitement
					}
				} finally {
					// dans tous les cas, on ferme nos flux
					buff.close();
				}
			} catch (IOException ioe) {
				// erreur de fermeture des flux
				System.out.println("Erreur --" + ioe.toString());
			}
		}
		System.out.println("\nlecture du tableau : \n");
		for (int i = 0; i < tab.length; i++){
			System.out.println(tab[i]);
		}
		 */




		/**
		 * DECOMMENTER CE QUI SUIT POUR TESTER L'AJOUT 
		 * ET LA SUPPRESSION D'UN OBJET DANS L'INVENTAIRE
		 * L'AJOUT ET LA SUPPRESION SONT CONTROLE
		 */

//
//		PotionDeSoin potion1 = new PotionDeSoin();
//		PotionDeSoin potion2 = new PotionDeSoin();
//		PotionDeSoin potion3 = new PotionDeSoin();
//		Arme arme = new Arme();
//		Arme arme1 = new Arme();
//		Pantalon jambe = new Pantalon();
//		Casque casque = new Casque();
//
//		PotionDeSoin potion11 = new PotionDeSoin();
//		PotionDeSoin potion21 = new PotionDeSoin();
//		PotionDeSoin potion31 = new PotionDeSoin();
//		Arme arme12 = new Arme();
//		Arme arme11 = new Arme();
//		Pantalon jambe1 = new Pantalon();
//		Casque casque1 = new Casque();
//
//		//System.out.println(arme.getNom());
//		joueur.getInventaire().ajouterObjet(potion1);
//		joueur.getInventaire().ajouterObjet(arme);
//		joueur.getInventaire().ajouterObjet(potion2);
//		joueur.getInventaire().ajouterObjet(arme1);
//		joueur.getInventaire().ajouterObjet(potion3);
//		joueur.getInventaire().ajouterObjet(jambe);
//		joueur.getInventaire().ajouterObjet(casque);
//		joueur1.getInventaire().ajouterObjet(potion11);
//		joueur1.getInventaire().ajouterObjet(arme12);
//		joueur1.getInventaire().ajouterObjet(potion21);
//		joueur1.getInventaire().ajouterObjet(arme11);
//		joueur1.getInventaire().ajouterObjet(potion31);
//		joueur1.getInventaire().ajouterObjet(jambe1);
//		joueur1.getInventaire().ajouterObjet(casque1);
//		System.out.println("Voici l'inventaire du joueur : "); 
//		System.out.println("\n" + joueur.getInventaire().inventaireToString());
//		joueur.getInventaire().deposerObjet(potion2);
//		System.out.println("\n\nOn a retire la deuxieme potion, resultat : ");
//		System.out.println("\n" + joueur.getInventaire().inventaireToString());

//
//		System.out.println("\n\nOn equipe le joueur de l'arme 1 et 2 presente dans son inventaire");
//		joueur.getInventaire().equiperObjet(arme);
//		joueur.getInventaire().equiperObjet(arme1);
//		joueur.getInventaire().equiperObjet(jambe);
//		joueur.getInventaire().equiperObjet(casque);
//		joueur1.getInventaire().equiperObjet(arme11);
//		joueur1.getInventaire().equiperObjet(arme12);
//		joueur1.getInventaire().equiperObjet(jambe1);
//		joueur1.getInventaire().equiperObjet(casque1);
//		System.out.println("\nOn affiche les objets equipé par le joueur : ");
//		System.out.println("\n" + joueur.getInventaire().equipeToString());
////
//		System.out.println("\nOn affiche l'inventaire du joueur : ");
//		System.out.println("\n" + joueur.getInventaire().inventaireToString());
//		System.out.println("\n\nOn equipe le joueur de l'arme 1 et 2 presente dans son inventaire");
//		
//		System.out.println("\nOn affiche les objets equipé par le joueur : ");
//		System.out.println("\n" + joueur1.getInventaire().equipeToString());
////
//		System.out.println("\nOn affiche l'inventaire du joueur : ");
//		System.out.println("\n" + joueur1.getInventaire().inventaireToString());

//		System.out.println("\n\nOn essaye de rééquipé le joueur de la premiere arme qu'il a équipé \n(logiqement impossible puisque sont arme n'est plus dans l'inventaire)");
//		joueur.getInventaire().equiperObjet(arme);
//
//		System.out.println("\nOn affiche ses objets equipe : ");
//		System.out.println("\n" + joueur.getInventaire().equipeToString());
//		System.out.println("\nOn affiche l'inventaire du joueur : ");
//		System.out.println("\n" + joueur.getInventaire().inventaireToString());
//
//		System.out.println("\n\nOn équipe le joueur d'une autre arme qui est dans son inventaire\n(Impossible puisqu'il a deja deux arme equipe)");
//		joueur.getInventaire().equiperObjet(arme3);
//
//		System.out.println("\nOn affiche ses objets equipe : ");
//		System.out.println("\n" + joueur.getInventaire().equipeToString());
//		System.out.println("\nOn affiche l'inventaire du joueur : ");
//		System.out.println("\n" + joueur.getInventaire().inventaireToString());


//		System.out.println("\n\nOn deséquipe le joueur d'une arme");
//		joueur.getInventaire().desequiperObjet(arme);
//
//		System.out.println("\nOn affiche ses objets equipe : ");
//		System.out.println("\n" + joueur.getInventaire().equipeToString());
//		System.out.println("\nOn affiche l'inventaire du joueur : ");
//		System.out.println("\n" + joueur.getInventaire().inventaireToString());
		
		
		
		
		/**
		 * DECOMENTE CE QUI SUIS POUR TESTER UNE ATTAQUE
		 * ET LE SOIN D'UNE CIBLE
		 */


//		
//		joueur1.getCaracteristique().setForce(5);
//		joueur1.getCaracteristique().setAdresse(5);
//		joueur1.getCaracteristique().setResistance(5);
//		joueur.getCaracteristique().setForce(5);
//		joueur.getCaracteristique().setAdresse(5);
//		joueur.getCaracteristique().setResistance(5);
////
//		System.out.println("\n   vie avant attaque : " + cible.getVie().getVie() + "\n");
//		joueur.attaquer(cible);
//		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
//		joueur.attaquer(cible);
//		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
//		joueur.attaquer(cible);
//		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");

//
//		System.out.println("\n   vie avant attaque : " + joueur1.getVie().getVie() + "\n");
//		joueur.attaquer(joueur1);
//		System.out.println("\n   vie apres attaque : " + joueur1.getVie().getVie() + "\n");
//		joueur.attaquer(joueur1);
//		System.out.println("\n   vie apres attaque : " + joueur1.getVie().getVie() + "\n");
//		joueur.attaquer(joueur1);
//		System.out.println("\n   vie apres attaque : " + joueur1.getVie().getVie() + "\n");
//
//		cible.getVie().ajouterVie(10);
//
//		System.out.println("\n   vie apres soin de la cible : " + cible.getVie().getVie() + "\n");
	
		
		 
	}
}


