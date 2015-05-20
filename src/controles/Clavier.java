package controles;

import items.Objet;

import java.util.Scanner;

import carte.Carte;
import carte.Case;
import carte.Position;
import personnage.EntiteVivante;
import personnage.Joueur;

public class Clavier {
	
	public static final int HAUT = 1;
	public static final int BAS = 2;
	public static final int GAUCHE = 3;
	public static final int DROITE = 4;

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
			return str.charAt(0);
	}
	
	/**
	 * Demande la saisie d'une direction
	 * @return L'int correspondant a la direction ou -1 si la saisie ne correspond pas a la demande
	 */
	public void saisieDirection() { // TODO:skeggib Utiliser les fleches directionnelles
		System.out.print("Dans quelle direction ? (Haut -> 'z', Bas -> 's', Droite -> 'd', Gauche -> 'q') : ");
		char car = this.saisieCar();
		
		int direction = 0;
		
		if (car == 'z' || car == 'Z')
			direction = Clavier.HAUT;
		else if (car == 's' || car == 'S')
			direction = Clavier.BAS;
		else if (car == 'd' || car == 'D')
			direction = Clavier.DROITE;
		else if (car == 'q' || car == 'Q')
			direction = Clavier.GAUCHE;
		
		this.realiserAction(direction);
	}
	
	/**
	 * Ordonne au Joueur de realiser une action en fonction du contenu de la case
	 * @param direction Direction que l'utilisateur a choisit
	 * @return True si le Joueur s'est deplace
	 */
	private boolean realiserAction(int direction) {
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
		case Clavier.HAUT:
			posDest.setY(posDest.getY() - 1);
			break;
		case Clavier.BAS:
			posDest.setY(posDest.getY() + 1);
			break;
		case Clavier.GAUCHE:
			posDest.setX(posDest.getX() - 1);
			break;
		case Clavier.DROITE:
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
