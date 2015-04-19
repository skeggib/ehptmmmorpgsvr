package personnage;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Random;
//import items.Arme;
//import items.Nom;
//import items.PotionDeSoin;

public class Test {

	public static void main(String[] args) {
	
		
		//Random rand = new Random();

		Joueur joueur = new Joueur ();
		Monstre cible = new Monstre ();
		/*
		String filePath = "src/arme.txt";
		String[] tab = null;
		if(tab == null){
			try{
				// Création du flux bufférisé sur un FileReader, immédiatement suivi par un 
				// try/finally, ce qui permet de ne fermer le flux QUE s'il le reader
				// est correctement instancié (évite les NullPointerException)
				BufferedReader buff = new BufferedReader(new FileReader(filePath));

				try {
					String line;
					// Lecture du fichier ligne par ligne. Cette boucle se termine
					// quand la méthode retourne la valeur null.
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
		 * DECOMENTE CE QUI SUIS POUR TESTER UNE ATTAQUE
		 * ET LE SOIN D'UNE CIBLE
		 */

		
		/*
		cible.getCaracteristique().setForce(5);
		cible.getCaracteristique().setAdresse(5);
		cible.getCaracteristique().setResistance(5);
		joueur.getCaracteristique().setForce(7);
		joueur.getCaracteristique().setAdresse(7);
		joueur.getCaracteristique().setResistance(7);

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
		System.out.println("\nOn affiche les objets equipÃ© par le joueur : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());

		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());

		System.out.println("\n\nOn essaye de rÃ©Ã©quipÃ© le joueur de la premiere arme qu'il a Ã©quipÃ© \n(logiqement impossible puisque sont arme n'est plus dans l'inventaire)");
		joueur.getInventaire().equiperObjet(arme);

		System.out.println("\nOn affiche ses objets equipe : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());
		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());

		System.out.println("\n\nOn Ã©quipe le joueur d'une autre arme qui est dans son inventaire\n(Impossible puisqu'il a deja deux arme equipe)");
		joueur.getInventaire().equiperObjet(arme3);

		System.out.println("\nOn affiche ses objets equipe : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());
		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());


		System.out.println("\n\nOn desÃ©quipe le joueur d'une arme");
		joueur.getInventaire().desequiperObjet(arme);

		System.out.println("\nOn affiche ses objets equipe : ");
		System.out.println("\n" + joueur.getInventaire().equipeToString());
		System.out.println("\nOn affiche l'inventaire du joueur : ");
		System.out.println("\n" + joueur.getInventaire().inventaireToString());
		 */
	}
}


