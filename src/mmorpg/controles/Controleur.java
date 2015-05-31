package mmorpg.controles;

import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Case;
import mmorpg.carte.Position;
import mmorpg.items.Objet;
import mmorpg.jeu.Log;
import mmorpg.personnage.Coffre;
import mmorpg.personnage.EntiteVivante;
import mmorpg.personnage.Joueur;

public class Controleur {
	
	
	
	
	/* --- ACTIONS --- */
	
	public static final int HAUT = 1;
	public static final int BAS = 2;
	public static final int GAUCHE = 3;
	public static final int DROITE = 4;
	public static final int INVENTAIRE = 5;
	public static final int PERSONNAGE = 6;
	public static final int AIDE = 7;
	public static final int QUITTER = 8;
	public static final int RETOUR = 9; // Retour au jeu
	public static final int EQUIPER = 10;
	public static final int DESEQUIPER = 11;
	
	
	
	
	/* --- TEXTE AIDE --- */
	
	private static final String TEXTE_AIDE_JEU = 
			"Aide :"
			+ "\n\t h : Afficher cette aide"
			+ "\n\t z : Haut"
			+ "\n\t s : Bas"
			+ "\n\t q : Gauche"
			+ "\n\t d : Droite"
			+ "\n\t i : Ouvrir l'inventaire"
			+ "\n\t p : Ouvrir la fenetre personnage"
			+ "\n\t r : Retour"
			+ "\n\t x : Quitter";
	
	private static final String TEXTE_AIDE_INVENTAIRE = 
			"Aide :"
			+ "\n\t h : Afficher cette aide"
			+ "\n\t e : Equiper un objet"
			+ "\n\t d : Desequiper un objet"
			+ "\n\t r : Retour"
			+ "\n\t x : Quitter";
	
	private static final String TEXTE_AIDE_PERSONNAGE = 
			"Aide :"
			+ "\n\t h : Afficher cette aide"
			+ "\n\t r : Retour"
			+ "\n\t x : Quitter";
	
	
	
	
	/* --- AUTRES ATTRIBUTS --- */

	private static Scanner sc = new Scanner(System.in);
	
	private Joueur joueur;
	private Carte carte;
	private Log log;
	
	private InterfaceTerm inter;
	
	/**
	 * Demande une saisie et retourne le premier caractere saisit
	 * @return
	 */
	private char saisieCar() {
		String str = sc.nextLine();
		if (str.isEmpty())
			return ' ';
		else
			return str.toLowerCase().charAt(0);
	}
	
	
	
	
	/* --- SAISIE ACTION --- */
	
	/**
	 * Demande la saisie d'une action
	 * @return L'int correspondant a la direction ou -1 si la saisie ne correspond pas a la demande
	 */
	public int saisieAction() {
		System.out.print("Que voulez vous faire ? (tapez 'h' pour afficher l'aide) ");
		
		// On fonction du mode dans lequel est l'interface
		switch (this.inter.getMode()) {
		
		case InterfaceTerm.MODE_JEU:
			return this.saisieActionJeu();
		case InterfaceTerm.MODE_INVENTAIRE:
			return this.saisieActionInventaire();
		case InterfaceTerm.MODE_PERSONNAGE:
			return this.saisieActionPersonnage();
			
		}
		
		return -1;
	}
	
	/* --- JEU --- */
	
	private int saisieActionJeu() {
		char car = this.saisieCar();
		
		int action = -1;
		
		switch (car) {
		case 'z':
			action = Controleur.HAUT;
			break;
		case 's':
			action = Controleur.BAS;
			break;
		case 'd':
			action = Controleur.DROITE;
			break;
		case 'q':
			action = Controleur.GAUCHE;
			break;
		case 'i':
			action = Controleur.INVENTAIRE;
			break;
		case 'p':
			action = Controleur.PERSONNAGE;
			break;
		case 'h':
			action = Controleur.AIDE;
			break;
		case 'x':
			return Controleur.QUITTER;
		}
		
		if (action != -1) {
			if (this.realiserActionJeu(action))
				return action;
		}
		
		return -1;
	}
	
	/* --- INVENTAIRE --- */
	
	private int saisieActionInventaire() {
		char car = this.saisieCar();
		
		int action = -1;
		
		switch (car) {
		case 'h':
			action = Controleur.AIDE;
			break;
		case 'e':
			action = Controleur.EQUIPER;
			break;
		case 'd':
			action = Controleur.DESEQUIPER;
			break;
		case 'r':
			action = Controleur.RETOUR;
			break;
		case 'x':
			return Controleur.QUITTER;
		}
		
		if (action != -1) {
			if (this.realiserActionInventaire(action))
				return action;
		}
		
		return -1;
	}
	
	/* --- PERSONNAGE --- */
	
	private int saisieActionPersonnage() {
		char car = this.saisieCar();
		
		int action = -1;
		
		switch (car) {
		case 'h':
			action = Controleur.AIDE;
			break;
		case 'r':
			action = Controleur.RETOUR;
			break;
		case 'x':
			return Controleur.QUITTER;
		}
		
		if (action != -1) {
			if (this.realiserActionPersonnage(action))
				return action;
		}
		
		return -1;
	}
	
	
	
	
	/* --- REALISER ACTION --- */
	
	/* --- JEU --- */
	
	/**
	 * Realise une action
	 * @param action Action a effectuer
	 * @return True si l'action a ete realisee
	 */
	private boolean realiserActionJeu(int action) {
		
		if (action == Controleur.AIDE) {
			this.afficherAide();
		}
		
		else if (action == Controleur.HAUT ||
			action == Controleur.BAS ||
			action == Controleur.DROITE ||
			action == Controleur.GAUCHE) {
			return this.deplacement(action);
		}
		
		else if (action == Controleur.INVENTAIRE) {
			return this.ouvrirInventaire();
		}
		
		else if (action == Controleur.PERSONNAGE) {
			return this.ouvrirPersonnage();
		}
		
		return false;
	}
	
	/* --- INVENTAIRE --- */
	
	private boolean realiserActionInventaire(int action) {
		
		if (action == Controleur.AIDE) {
			this.afficherAide();
		}
		
		else if (action == Controleur.EQUIPER) {
			System.out.print("Entrez le numero de l'objet a equiper : ");
			int numObj = this.saisieInt() - 1;
			// -1 car la numerotation des objets dans l'affichage commence a 1
			Objet objAEquiper = this.joueur.getInventaire().getObjet(numObj);
			if (this.joueur.equiperObjet(objAEquiper))
				System.out.println("Vous avez equipe : " + objAEquiper.getNom());
		}
		
		else if (action == Controleur.DESEQUIPER) {
			System.out.println("Entrez le numero de l'objet a desequiper : ");
			int numObj = this.saisieInt() - 1;
			// -1 car la numerotation des objets dans l'affichage commence a 1
			Objet objADesequiper = this.joueur.getEquipement().getObjet(numObj);
			if (this.joueur.desequiperObjet(objADesequiper))
				System.out.println("Vous avez desequipe : " + objADesequiper.getNom());
		}
		
		else if (action == Controleur.RETOUR) {
			return this.ouvrirJeu();
		}
		
		return false;
	}
	
	/* --- PERSONNAGE --- */
	
	private boolean realiserActionPersonnage(int action) {
		
		if (action == Controleur.AIDE) {
			this.afficherAide();
		}
		
		else if (action == Controleur.RETOUR) {
			return this.ouvrirJeu();
		}
		
		return false;
	}
	
	
	
	
	/* --- AIDE --- */
	
	private void afficherAide() {
		
		switch (this.inter.getMode()) {
		case InterfaceTerm.MODE_JEU:
			System.out.println(Controleur.TEXTE_AIDE_JEU);
			break;
		case InterfaceTerm.MODE_INVENTAIRE:
			System.out.println(Controleur.TEXTE_AIDE_INVENTAIRE);
			break;
		case InterfaceTerm.MODE_PERSONNAGE:
			System.out.println(Controleur.TEXTE_AIDE_PERSONNAGE);
			break;
		}
		
		System.out.println("\nAppuyez sur Entrer pour continuer...");
		sc.nextLine();
	}

	private boolean ouvrirPersonnage() {
		this.inter.setMode(InterfaceTerm.MODE_PERSONNAGE);
		return true;
	}

	private boolean ouvrirInventaire() {
		this.inter.setMode(InterfaceTerm.MODE_INVENTAIRE);
		return true;
	}
	
	private boolean ouvrirJeu() {
		this.inter.setMode(InterfaceTerm.MODE_JEU);
		return true;
	}

	private boolean deplacement(int direction) {
		// Verifier que je joueur et la carte on ete definis
		if (this.carte == null || this.joueur == null)
			return false;
		
		Case destination;
		Position posJoueur;
		
		posJoueur = this.carte.getPosContenu(this.joueur);
		
		if (posJoueur == null)
			return false;
		
		// Calcul de la position de la destination
		Position posDest = posJoueur;
		switch (direction) {
		case Controleur.HAUT:
			posDest.setY(posDest.getY() - 1);
			break;
		case Controleur.BAS:
			posDest.setY(posDest.getY() + 1);
			break;
		case Controleur.GAUCHE:
			posDest.setX(posDest.getX() - 1);
			break;
		case Controleur.DROITE:
			posDest.setX(posDest.getX() + 1);
			break;
		}
		
		// On recupere la case qui correspond a la destination
		destination = this.carte.getCase(posDest.getX(), posDest.getY());
		
		// Si la dest est vide on deplace le joueur
		if (destination.estVide()) {
			return this.joueur.seDeplacer(destination);
		}
		
		// Si la dest contient une entite on l'attaque
		else if (destination.contientEntite()) {
			EntiteVivante ennemi = (EntiteVivante)destination.getContenu();
			int degats = this.joueur.attaquer(ennemi);
			if (this.log != null) {
				if (degats > 0)
					this.ecrireLog(this.joueur.getNom() + " attaque " + ennemi.getNom() + " (-" + degats + ")");
				else if (degats == -1)
					this.ecrireLog(ennemi.getNom() + " esquive !");
			}
		}
		
		// Si la dest contient un objet, on le ramasse puis on se deplace
		else if (destination.contientObjet()) {
			Objet obj = (Objet)destination.getContenu();
			this.joueur.rammasserObjet(obj);
			this.ecrireLog(this.joueur.getNom() + " rammasse " + obj.getNom());
			destination.supprContenu();
			return this.joueur.seDeplacer(destination);
		}
		
		else if (destination.contientCoffre()) {
			Coffre coffre = (Coffre)destination.getContenu();
			this.joueur.rammasserCoffre(coffre);
			if (this.log != null) {
				for (int i = 0; i < coffre.getTaille(); i++) {
					this.ecrireLog(this.joueur.getNom() + " rammasse " + coffre.getContenu().get(i).getNom());
				}
			}
			destination.supprContenu();
			return this.joueur.seDeplacer(destination);
		}
		
		return false;
	}
	
	private void ecrireLog(String message) {
		if (this.log != null)
			this.log.add(message);
	}
	
	public int saisieInt() {
		int val = sc.nextInt();
		
		// Cider le buffer du scanner pour eviter une double saisie
		sc.nextLine();
		
		return val;
	}
	
	
	
	
	/* --- GETTERS / SETTERS --- */
	
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public void setLog(Log log) {
		this.log = log;
	}
	
	public void setInterface(InterfaceTerm inter) {
		this.inter = inter;
	}
	
}
