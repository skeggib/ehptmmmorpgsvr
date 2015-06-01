package mmorpg.jeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Position;
import mmorpg.controles.Controleur;
import mmorpg.exceptions.affichage.interfaceTerm.CantDrawInterfaceException;
import mmorpg.personnage.Joueur;
import mmorpg.personnage.Monstre;

public class Moteur {
	
	private Log log;
	private Carte carte;
	private Joueur joueur;
	private InterfaceTerm inter;
	private Controleur control;
	private ArrayList<Monstre> listeMonstres;
	
	
	
	public Moteur() {
		this.log = new Log();
		this.carte = new Carte();
		this.joueur = new Joueur();
		this.inter = new InterfaceTerm();
		this.control = new Controleur();	
	}
	
	public void jouer() {
		
		Scanner sc = new Scanner(System.in);
		
		/* Chargement de la carte */
		
		this.carte.chargerFichier("ressources/carte/test");
		this.listeMonstres = Moteur.ajoutMonstres(this.carte);
		
		/* Creation du joueur */
		
		this.joueur = new Joueur("Armya", 10, 10, 10);
		// TODO:skeggib Creation interractive du joueur
		this.joueur.initialiserPos(this.carte.getCase(3, 3));
		
		/* Demander la taille de l'interface */
		
		// TODO:skeggib Decommenter et enlever int taille = 0;
		int taille = 0;
//		System.out.println("Taille de l'interface : ");
//		for (int i = 0; i < InterfaceTerm.TAILLES.length; i++) {
//			System.out.println((i+1) + ". " + InterfaceTerm.TAILLES[i]);
//		}
//		int taille = sc.nextInt();
//		taille--;
		
		/* Creation de l'interface */
		
		this.inter = new InterfaceTerm(taille);
		this.inter.setLog(log);
		this.inter.setCarte(carte);
		this.inter.setJoueur(joueur);
		
		/* Initialisation le controleur */
		
		this.control.setCarte(this.carte);
		this.control.setJoueur(this.joueur);
		this.control.setLog(this.log);
		this.control.setInterface(this.inter);
		
		/* Boucle principale */

		boolean run = true;
		while (run) {
			
			this.joueur.recupererPA();
			this.joueur.setPointAction(2); // TODO A enlever
			// Boucle actions du joueur
			while (this.joueur.deplacementPossible() && run) {
				
				try {
					// Affichage
					inter.afficher();
					// Action
					if (this.control.saisieAction() == Controleur.QUITTER)
						run = false;
				}
				catch (CantDrawInterfaceException e) {
					e.printStackTrace();
					run = false;
				}
			}
			
			// TODO:skeggib Decommenter quand les monstres perderont des PA
			// Tour des monstres
			boolean tourMonstres = true;

			for (int i = 0; i < this.listeMonstres.size(); i++) {
				// tourMonstres sera True si au moins un monstre aura realise une action
				this.listeMonstres.get(i).debutTour();
			}
		
			
			while (tourMonstres && run) {
			
			
			
				
				// Chaque monstre doit realiser une action
				tourMonstres = false;
				System.out.println("Nb monstres : " + this.listeMonstres.size());
				for (int i = 0; i < this.listeMonstres.size(); i++) {
					// tourMonstres sera True si au moins un monstre aura realise une action
					boolean resultatAction = this.listeMonstres.get(i).realiserAction(carte);
					tourMonstres = tourMonstres || resultatAction;
					System.out.println(this.listeMonstres.get(i).getNom() + " : " + this.listeMonstres.get(i).getPointAction());
				}
				
				// On affiche l'interface
				try {
					this.inter.afficher();
				}
				catch (CantDrawInterfaceException e) {
					e.printStackTrace();
					run = false;
				}
				
			}
		}
		
		sc.close();
		
	}
	
	/**
	 * Ajout des monstres aleatoirement sur une carte
	 * @param carte
	 * @return La liste de monstres qui ont ete crees
	 */
	private static ArrayList<Monstre> ajoutMonstres(Carte carte) { // TODO:skeggib UML (changer de classe -> Carte ?)
		Random rand = new Random();
		int randInt;
		
		ArrayList<Monstre> liste = new ArrayList<Monstre>();
		ArrayList<Monstre> rtrn = new ArrayList<Monstre>();
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
		
		rtrn.addAll(liste);
		
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
