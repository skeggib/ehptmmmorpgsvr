package mmorpg.jeu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Position;
import mmorpg.controles.Controleur;
import mmorpg.exceptions.affichage.interfaceTerm.CantDrawInterfaceException;
import mmorpg.fichiers.EcritureObjet;
import mmorpg.items.Arme;
import mmorpg.items.Casque;
import mmorpg.items.Pantalon;
import mmorpg.items.PotionDeDegat;
import mmorpg.items.PotionDeSoin;
import mmorpg.items.PotionEffet;
import mmorpg.personnage.Joueur;
import mmorpg.personnage.Monstre;

public class Moteur implements Serializable {

	private static final long serialVersionUID = -6706730199045501365L;

	private Log log;
	private Carte carte;
	private Joueur joueur;
	private InterfaceTerm inter;
	private Controleur control;
	private ArrayList<Monstre> listeMonstres;

	private boolean run;

	public Moteur() {
		this.log = new Log();
		this.carte = new Carte();
		this.joueur = new Joueur();
		this.inter = new InterfaceTerm();
		this.control = new Controleur();

		this.init();
		this.initJoueur();
		
		this.run = true;
	}

	public void jouer() {
		// Boucle principale
		while (this.run) {
			// Tour du joueur
			this.tourJoueur();
			// Tour des monstres
			this.tourMonstres();
			
			EcritureObjet.ecrire(this); //TODO : Retirer quand on aura fini l'implementation
		}

	}

	private void init() {

		/* Chargement de la carte */

		this.carte.chargerFichier("carte/test");
		this.listeMonstres = Moteur.ajoutMonstres(this.carte);

		/* Creation du joueur */

		this.joueur = new Joueur("Armya", 0, 0, 0);
		// TODO:skeggib Creation interractive du joueur
		this.joueur.initialiserPos(this.carte.getCase(3, 3));
		// TODO: skeggib A enlver
		this.joueur.ramasserObjet(new PotionDeSoin());
		this.joueur.ramasserObjet(new PotionDeDegat());
		this.joueur.ramasserObjet(new PotionEffet());
		this.joueur.ramasserObjet(new PotionDeSoin());
		this.joueur.ramasserObjet(new PotionDeDegat());
		this.joueur.ramasserObjet(new Casque());
		this.joueur.ramasserObjet(new Arme());
		this.joueur.ramasserObjet(new Pantalon());
		this.joueur.ramasserObjet(new Pantalon());

		/* Demander la taille de l'interface */

		// TODO:skeggib Decommenter et enlever int taille = 0;
		int taille = 1;
		// System.out.println("Taille de l'interface : ");
		// for (int i = 0; i < InterfaceTerm.TAILLES.length; i++) {
		// System.out.println((i+1) + ". " + InterfaceTerm.TAILLES[i]);
		// }
		// int taille = sc.nextInt();
		// taille--;

		/* Creation de l'interface */

		this.inter = new InterfaceTerm(taille);
		this.inter.setLog(this.log);
		this.inter.setCarte(this.carte);
		this.inter.setJoueur(this.joueur);

		/* Initialisation le controleur */

		this.control.setCarte(this.carte);
		this.control.setJoueur(this.joueur);
		this.control.setLog(this.log);
		this.control.setInterface(this.inter);

	}

	private void initJoueur() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Saisissez un pseudo pour votre joueur : ");
		this.joueur.setNom(sc.nextLine());

		int pointRestant = 18;

		System.out.println("\nVous disposez de " + pointRestant
				+ " a attribuer entre vos caracteristiques");

		while (pointRestant > 0) {

			int temp;

			System.out.println("\nCombien de Force ajouter : ");
			temp = this.saisieCaracteristique(pointRestant);
			this.joueur.getCaractPrinc().ajouterForce(temp);
			pointRestant -= temp;

			System.out.println("Combien de Adresse ajouter : ");
			temp = this.saisieCaracteristique(pointRestant);
			this.joueur.getCaractPrinc().ajouterAdresse(temp);
			pointRestant -= temp;

			System.out.println("Combien de Resistance ajouter : ");
			temp = this.saisieCaracteristique(pointRestant);
			this.joueur.getCaractPrinc().ajouterResistance(temp);
			pointRestant -= temp;

			System.out.println("\n1 . Force : "
					+ this.joueur.getCaractPrinc().getForce());
			System.out.println("2 . Adresse : "
					+ this.joueur.getCaractPrinc().getAdresse());
			System.out.println("3 . Resistance : "
					+ this.joueur.getCaractPrinc().getResistance());

			System.out.println("\nIl reste " + pointRestant
					+ " point a depenser");
		}

	}

	private int saisieCaracteristique(int pointRestant) {
		Scanner sc = new Scanner(System.in);

		int saisie = 0;

		try {
			saisie = sc.nextInt();
		} catch (Exception e) {
			saisie = 0;
		}

		if ((pointRestant - saisie) >= 0) {
			return saisie;
		} else {
			return 0;
		}
	}

	private void tourJoueur() {
		this.joueur.debutTour();
		// Boucle actions du joueur
		boolean continuerTour = true;
		while (this.run && continuerTour) {
			try {
				// Affichage
				inter.afficher();
				// Action
				int action = this.control.saisieAction();
				if (action == Controleur.QUITTER)
					this.run = false;
				else if (action == Controleur.TERMINER_TOUR)
					continuerTour = false;
			} catch (CantDrawInterfaceException e) {
				e.printStackTrace();
				this.run = false;
			}
		}
	}

	private void tourMonstres() {
		boolean tourMonstres = true;

		for (int i = 0; i < this.listeMonstres.size(); i++) {
			this.listeMonstres.get(i).debutTour();
		}

		while (tourMonstres && this.run) {

			// On affiche l'interface
			try {
				this.inter.afficher();
			} catch (CantDrawInterfaceException e) {
				e.printStackTrace();
				this.run = false;
			}

			// Pause
			try {

				Thread.sleep(1000);

				/*
				 * Je m'excuse d'avance aupres de mon professeur de Java pour
				 * avoir utilise une methode de la classe Thread (alors qu'il
				 * nous a precise qu'il ne voulait pas voir d'interfaces
				 * graphiques ou de threads dans ce projet).
				 * 
				 * C'est la seule methode que j'ai trouve pour mettre en pause
				 * le programme (c'est necessaire pour y voir quelque chose
				 * entre deux deplacements de monstres).
				 * 
				 * Cordialement, Votre eleve passionne.
				 */

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Chaque monstre doit realiser une action
			tourMonstres = false;
			for (int i = 0; i < this.listeMonstres.size(); i++) {
				// tourMonstres sera true si au moins un monstre aura realise
				// une action
				boolean resultatAction = this.listeMonstres.get(i)
						.realiserAction(carte);
				tourMonstres = tourMonstres || resultatAction;
				// System.out.println(this.listeMonstres.get(i).getNom() + " : "
				// + this.listeMonstres.get(i).getPointAction());
			}

			// Verifier que le joueur est vivant
			if (!this.joueur.estVivant()) {
				this.run = false;
				this.inter.setMode(InterfaceTerm.FIN_JEU);

				try {
					this.inter.afficher();
				} catch (CantDrawInterfaceException e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * Ajout des monstres aleatoirement sur une carte
	 * 
	 * @param carte
	 * @return La liste de monstres qui ont ete crees
	 */
	private static ArrayList<Monstre> ajoutMonstres(Carte carte) { // TODO:skeggib
																	// UML
																	// (changer
																	// de classe
																	// -> Carte
																	// ?)
		Random rand = new Random();
		int randInt;

		ArrayList<Monstre> liste = new ArrayList<Monstre>();
		ArrayList<Monstre> rtrn = new ArrayList<Monstre>(); // Liste de monstres
															// qui va etre
															// retournee
		Monstre tempMonstre;

		// Chance qu'a chaque case de recevoir un Monstre en %
		int chanceCase = 5;
		// Chance que chaque monstre a de devenir un groupe de monstres en %
		int chanceDevientGroupe = 10;

		// On ajoute des monstres aleatoirement dans la carte sur les cases
		// vides
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

		rtrn.addAll(liste);

		Position posM;

		// On creer les groupes de monstre
		// Pourque chaque monstre existant
		for (int i = 0; i < liste.size(); i++) {
			// On fait un rand pour savoir si le monstre va devenir un groupe
			randInt = rand.nextInt(100);
			if (randInt < chanceDevientGroupe) {
				posM = carte.getPosContenu(liste.get(i));

				// Chaque case autours du monstre a 1 chance sur 3 de recevoir
				// un monstre
				for (int y = posM.getY() - 1; y <= posM.getY() + 1; y++) {
					for (int x = posM.getX() - 1; x <= posM.getX() + 1; x++) {
						randInt = rand.nextInt(100);
						if (randInt < 33) {
							tempMonstre = new Monstre();
							tempMonstre.initialiserPos(carte.getCase(x, y));
							rtrn.add(tempMonstre);
						}
					}
				}
			}
		}

		return rtrn;
	}

	public static void main(String[] args) {

		Moteur moteur = new Moteur();
		moteur.jouer();

	}

}
