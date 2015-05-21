package controles;

import items.Objet;

import java.util.ArrayList;
import java.util.Scanner;

import carte.Carte;
import carte.Case;
import carte.Position;
import personnage.EntiteVivante;
import personnage.Joueur;

public class Controleur { // TODO:skeggib UML
	
	public static final int HAUT = 1;
	public static final int BAS = 2;
	public static final int GAUCHE = 3;
	public static final int DROITE = 4;
	public static final int INVENTAIRE = 5;
	public static final int PERSONNAGE = 6;
	public static final int AIDE = 7;
	
	private static final String TEXTE_AIDE = 
			"Aide :"
			+ "\n\th : Afficher cette aide"
			+ "\n\tz : Haut"
			+ "\n\ts : Bas"
			+ "\n\tq : Gauche"
			+ "\n\td : Droite"
			+ "\n\ti : Ouvrir l'inventaire"
			+ "\n\tp : Ouvrir la fenetre personnage";

	private static Scanner sc = new Scanner(System.in);
	
	private Joueur joueur;
	private Carte carte;
	
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
		
		return false;
	}
	
	private void afficherAide() {
		System.out.println(Controleur.TEXTE_AIDE);
		System.out.println("\nAppuyez sur Entrer pour continuer...");
		sc.nextLine();
	}

	private boolean ouvrirPersonnage() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean ouvrirInventaire() {
		// TODO Auto-generated method stub
		return false;
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
			this.joueur.attaquer(ennemi);
		}
		
		// Si la dest contient un objet, on le ramasse puis on se deplace
		else if (destination.contientObjet()) {
			Objet obj = (Objet)destination.getContenu();
			System.out.println(obj);
			this.joueur.rammasserObjet(obj);
			destination.supprContenu();
			return this.joueur.seDeplacer(destination);
		}
		
		return false;
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
	
}
