package mmorpg.jeu;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Position;
import mmorpg.controles.Controleur;
import mmorpg.items.Arme;
import mmorpg.items.Casque;
import mmorpg.items.Pantalon;
import mmorpg.items.Potion;
import mmorpg.items.PotionDeDegat;
import mmorpg.personnage.Joueur;
import mmorpg.personnage.Monstre;

public class Moteur {
	
	private Joueur joueur;

	public void jouer() {
		
		Scanner sc = new Scanner(System.in);
		
		Log log = new Log();
		
		// TODO:skeggib A faire
		
		// Affichage du menu
		
		// Creer la carte
		Carte carte = new Carte();
		carte.chargerFichier("ressources/carte/test");
		Moteur.ajoutMonstres(carte);
		
		// Creer le joueur
		this.joueur = new Joueur("Armya", 10, 10, 10);
		// Creation du joueur interactive
		// TODO:skeggib Mettre la creation interractive dans InterfaceTerm
//		System.out.print("Nom du joueur : ");
//		joueur.setNom(sc.nextLine());
		this.joueur.initialiserPos(carte.getCase(3, 3));
		
		// TODO:skeggib A enlever (pour tester)
		this.joueur.rammasserObjet(new Arme());
		this.joueur.rammasserObjet(new Casque());
		this.joueur.rammasserObjet(new Pantalon());
		this.joueur.rammasserObjet(new Arme());
		this.joueur.rammasserObjet(new Arme());
		this.joueur.rammasserObjet(new PotionDeDegat());
		
		this.joueur.equiperObjet(this.joueur.getInventaire().getObjet(0));
		this.joueur.equiperObjet(this.joueur.getInventaire().getObjet(0));
		this.joueur.equiperObjet(this.joueur.getInventaire().getObjet(0));
		
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
		inter.setLog(log);
		inter.setCarte(carte);
		inter.setJoueur(joueur);
		
		// Creer le controleur
		Controleur controleur = new Controleur();
		controleur.setCarte(carte);
		controleur.setJoueur(joueur);
		controleur.setLog(log);
		controleur.setInterface(inter);
		
		// Boucle principale
		boolean run = true;
		while (run) {
			
			this.joueur.recupererPA();
			
			// Boucle actions du joueur
			while (this.joueur.deplacementPossible() && run) {
				// Affichage
				inter.afficher();
				// Action
				if (controleur.saisieAction() == Controleur.QUITTER)
					run = false;
			}
			
			// Boucle action des monstres (si run)
				// Affichage
				// Action
		}
		
		sc.close();
		
	}
	
	private static void ajoutMonstres(Carte carte) {
		Random rand = new Random();
		int randInt;
		
		LinkedList<Monstre> liste = new LinkedList<Monstre>();
		Monstre tempMonstre;
		
		// Chance qu'a chaque case de recevoir un Monstre
		int chanceCase = 5;
		// Chance que chaque monstre a de devenir un groupe de monstres
		int chanceDevientGroupe = 10;
		
		// On ajoute des monstres aleatoirement dans la carte sur les cases vides
		for (int i = 0; i < carte.getHauteur(); i++) {
			for (int j = 0; j < carte.getLargeur(); j++) {
				if (carte.getCase(j, i).estVide()) {
					randInt = rand.nextInt(100);
					if (randInt < chanceCase) {
						tempMonstre = new Monstre();
						liste.add(tempMonstre);
						tempMonstre.initialiserPos(carte.getCase(j, i));
					}
				}
			}
		}
		
		Position posM;
		
		// On creer les groupes de monstre
		for (int i = 0; i < liste.size(); i++) {
			randInt = rand.nextInt(100);
			if (randInt < chanceDevientGroupe) {
				posM = carte.getPosContenu(liste.get(i));
				
				for (int y = posM.getY() - 1; y <= posM.getY() + 1; y++) {
					for (int x = posM.getX() - 1; x <= posM.getX() + 1; x++) {
						randInt = rand.nextInt(100);
						if (randInt < 33) {
							tempMonstre = new Monstre();
							tempMonstre.initialiserPos(carte.getCase(x, y));
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Moteur moteur = new Moteur();
		moteur.jouer();
		
	}

}
