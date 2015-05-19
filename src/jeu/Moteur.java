package jeu;

import java.util.Scanner;

import controles.Clavier;
import affichage.InterfaceTerm;
import affichage.fenetre.FenetreCarte;
import carte.Carte;
import personnage.Joueur;

public class Moteur {
	
	private Joueur joueur;

	public void jouer() {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		// Creer le controleur
		Clavier clavier = new Clavier();
		clavier.setCarte(carte);
		clavier.setJoueur(joueur);
		
		// Boucle principale
		while (true) {
			
			joueur.recupererPA();
			
			// Boucle actions du joueur
			while (joueur.actionDisponible()) {
				// Affichage
				inter.afficher(joueur, carte);
				// Action
				clavier.saisieDirection(); // TODO:skeggib A remplacer par choixAction
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
