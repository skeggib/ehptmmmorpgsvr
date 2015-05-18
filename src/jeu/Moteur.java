package jeu;

import java.util.Scanner;

import affichage.InterfaceTerm;
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
		Joueur joueur = new Joueur();
		// Creation du joueur interactive
		// TODO:skeggib Mettre la creation interractive dans InterfaceTerm
		System.out.print("Nom du joueur : ");
		joueur.setNom(sc.nextLine());
		
		// Remplir la carte avec des monstres
		
		// Demander la taille de l'interface
		System.out.println("Taille de l'interface : ");
		for (int i = 0; i < InterfaceTerm.TAILLES.length; i++) {
			System.out.println((i+1) + ". " + InterfaceTerm.TAILLES[i]);
		}
		int taille = sc.nextInt();
		taille--;
		// Creer l'interface
		InterfaceTerm inter = new InterfaceTerm(taille);
		
		// Boucle principale
			// Boucle actions joueur
				// Action
				// Affichage
			// Boucle action des monstres
				// Action
				// Affichage
	}

}
