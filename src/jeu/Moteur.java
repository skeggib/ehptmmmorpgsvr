package jeu;

import java.util.Scanner;

import controles.Controleur;
import affichage.InterfaceTerm;
import affichage.fenetre.FenetreCarte;
import carte.Carte;
import personnage.Joueur;

public class Moteur {
	
	private Joueur joueur;

	public void jouer() {
		
		Scanner sc = new Scanner(System.in);
		
		Log log = new Log(); // TODO:skeggib Log de test, a enlever
		log.add("Salut 1");
		log.add("Salut 2");
		log.add("Salut 3");
		log.add("Salut 4");
		log.add("Salut 5");
		log.add("Salut 6");
		log.add("Salut 7");
		log.add("Salut 8");
		log.add("Salut 9");
		log.add("Salut 10");
		log.add("Salut 11");
		log.add("Salut 12");
		log.add("Salut 13");
		log.add("Salut 14");
		log.add("Salut 15");
		log.add("Test");
		log.add("Message");
		
		// TODO:skeggib A faire
		
		// Affichage du menu
		
		// Creer la carte
		Carte carte = new Carte();
		carte.chargerFichier("../ressources/carte/test");
		
		// Creer le joueur
		Joueur joueur = new Joueur("default");
		// Creation du joueur interactive
		// TODO:skeggib Mettre la creation interractive dans InterfaceTerm
//		System.out.print("Nom du joueur : ");
//		joueur.setNom(sc.nextLine());
		joueur.initialiserPos(carte.getCase(3, 3));
		
		// Remplir la carte avec des monstres
		
		// Demander la taille de l'interface
//		System.out.println("Taille de l'interface : ");
//		for (int i = 0; i < FenetreCarte.TAILLES.length; i++) {
//			System.out.println((i+1) + ". " + FenetreCarte.TAILLES[i]);
//		}
//		int taille = sc.nextInt();
//		taille--;
		// Creer l'interface
		InterfaceTerm inter = new InterfaceTerm();
		inter.setLog(log);
		
		// Creer le controleur
		Controleur controleur = new Controleur();
		controleur.setCarte(carte);
		controleur.setJoueur(joueur);
		
		// Boucle principale
		while (true) {
			
			joueur.recupererPA();
			
			// Boucle actions du joueur
			while (joueur.deplacementPossible()) {
				// Affichage
				inter.afficher(joueur, carte);
				// Action
				controleur.saisieAction();
			}
			
			// Boucle action des monstres
				// Affichage
				// Action
		}
		
	}
	
	public static void main(String[] args) {
		
		Moteur moteur = new Moteur();
		moteur.jouer();
		
	}

}
