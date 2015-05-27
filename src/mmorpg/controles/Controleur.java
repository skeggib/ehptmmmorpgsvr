package mmorpg.controles;

import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Case;
import mmorpg.carte.Position;
import mmorpg.items.Objet;
import mmorpg.jeu.Log;
import mmorpg.personnage.EntiteVivante;
import mmorpg.personnage.Joueur;

public class Controleur { // TODO:skeggib UML
	
	public static final int HAUT = 1;
	public static final int BAS = 2;
	public static final int GAUCHE = 3;
	public static final int DROITE = 4;
	public static final int INVENTAIRE = 5;
	public static final int PERSONNAGE = 6;
	public static final int AIDE = 7;
	public static final int QUITTER = 8;
	public static final int JEU = 9;
	
	private static final String TEXTE_AIDE = 
			"Aide :"
			+ "\n\th : Afficher cette aide"
			+ "\n\tz : Haut"
			+ "\n\ts : Bas"
			+ "\n\tq : Gauche"
			+ "\n\td : Droite"
			+ "\n\ti : Ouvrir l'inventaire"
			+ "\n\tp : Ouvrir la fenetre personnage"
			+ "\n\tx : Quitter";

	private static Scanner sc = new Scanner(System.in);
	
	private Joueur joueur;
	private Carte carte;
	private Log log;
	
	private InterfaceTerm inter;
	
	//TODO:skeggib Reparer le bug du "le joueur attaque "le vide" " si on entre pas une action attendu
	
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
	
	/**
	 * Demande la saisie d'une action
	 * @return L'int correspondant a la direction ou -1 si la saisie ne correspond pas a la demande
	 */
	public int saisieAction() {
		System.out.print("Que voulez vous faire ? (tapez 'h' pour afficher l'aide) ");
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
		case 'r':
			action = Controleur.JEU;
			break;
		}
		
		if (action != -1) {
			if (this.realiserAction(action))
				return action;
		}
		
		return -1;
	}
	
	/**
	 * Realise une action
	 * @param action Action a effectuer
	 * @return True si l'action a ete realisee
	 */
	private boolean realiserAction(int action) {
		
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
		
		else if (action == Controleur.JEU) {
			return this.ouvrirJeu();
		}
		
		return false;
	}
	
	private void afficherAide() {
		System.out.println(Controleur.TEXTE_AIDE);
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
		// Verifier que je joueur et la carte on ete defenis
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
			if (this.log != null)
			this.ecrireLog(this.joueur.getNom() + " attaque " + ennemi.getNom() + " (-" + degats + ")"); // TODO: Si l'attaque n'a pas échouée
		}
		
		// Si la dest contient un objet, on le ramasse puis on se deplace
		else if (destination.contientObjet()) {
			Objet obj = (Objet)destination.getContenu();
			this.joueur.rammasserObjet(obj);
			this.ecrireLog(this.joueur.getNom() + " rammasse " + obj.getNom());
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
		return sc.nextInt();
	}
	
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
