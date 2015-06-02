package mmorpg.controles;

import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Case;
import mmorpg.carte.ContenuCase;
import mmorpg.carte.Position;
import mmorpg.items.Arme;
import mmorpg.items.Objet;
import mmorpg.items.Potion;
import mmorpg.items.PotionDeSoin;
import mmorpg.items.Vetement;
import mmorpg.jeu.Log;
import mmorpg.personnage.Coffre;
import mmorpg.personnage.EntiteVivante;
import mmorpg.personnage.Joueur;
import mmorpg.personnage.ListeUnique;

public class Controleur {
	
	
	
	
	/* --- ACTIONS --- */
	
	public static final int HAUT = 1;
	public static final int BAS = 2;
	public static final int GAUCHE = 3;
	public static final int DROITE = 4;
	public static final int QUITTER = 8;
	public static final int TERMINER_TOUR = 12;
	
	
	
	
	
	
	
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
			+ "\n\t t : Terminer le tour"
			+ "\n\t x : Quitter";
	
	private static final String TEXTE_AIDE_INVENTAIRE = 
			"Aide :"
			+ "\n\t h : Afficher cette aide"
			+ "\n\t e : Equiper un objet"
			+ "\n\t d : Desequiper un objet"
			+ "\n\t u : Uiliser un objet"
			+ "\n\t c : Afficher les caracteristiques d'un objet de l'inventaire"
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
	
	
	
	
	private int saisieActionJeu() {
		if (!this.joueur.actionDisponible())
			System.out.println("\nVous pouvez appuyer sur 't' pour terminer votre tour.");
		
		char car = this.saisieCar();
		
		switch (car) {
		case 'z':
			this.deplacement(Controleur.HAUT);
			break;
		case 's':
			this.deplacement(Controleur.BAS);
			break;
		case 'd':
			this.deplacement(Controleur.DROITE);
			break;
		case 'q':
			this.deplacement(Controleur.GAUCHE);
			break;
		case 'i':
			this.ouvrirInventaire();
			break;
		case 'p':
			this.ouvrirPersonnage();
			break;
		case 'h':
			this.afficherAide();
			break;
		case 'x':
			return Controleur.QUITTER;
		case 't':
			return Controleur.TERMINER_TOUR;
		}
		
		return -1;
	}
	
	
	
	
	private int saisieActionInventaire() {
		char car = this.saisieCar();
		
		switch (car) {
		case 'h':
			this.afficherAide();
			break;
		case 'e':
			this.equiper();
			break;
		case 'd':
			this.desequiper();
			break;
		case 'u':
			this.utiliser();
			break;
		case 'c':
			this.afficherCaracObjet();
			break;
		case 'r':
			this.ouvrirJeu();
			break;
		case 'x':
			return Controleur.QUITTER;
		}
		
		return -1;
	}

	
	
	
	private int saisieActionPersonnage() {
		char car = this.saisieCar();
		
		switch (car) {
		case 'h':
			this.afficherAide();
			break;
		case 'r':
			this.ouvrirJeu();
			break;
		case 'x':
			return Controleur.QUITTER;
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/* --- ACTIONS --- */

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
		
		Controleur.pause();
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

	

	private boolean deplacement(int direction) { // TODO:skeggib Factoriser
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
			return this.attaquer(ennemi);
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
			
			for (int i = 0; i < coffre.getTaille(); i++) {
				this.ecrireLog(this.joueur.getNom() + " rammasse " + coffre.getContenu().get(i).getNom());
			}
			
			destination.supprContenu();
			return this.joueur.seDeplacer(destination);
		}
		
		return false;
	}
	
	

	private boolean attaquer(EntiteVivante ennemi) {
		if (ennemi == null)
			return false;
		
		int degats = this.joueur.attaquer(ennemi);
		
		if (degats > 0)
			this.ecrireLog(this.joueur.getNom() + " attaque " + ennemi.getNom() + " (-" + degats + ")");
		else if (degats == -1)
			this.ecrireLog(ennemi.getNom() + " esquive !");
		
		return true;
	}
	
	

	private boolean utiliserPotion(Potion potion) {
		if (potion == null)
			return false;
		
		
		ListeUnique<EntiteVivante> listeCibles = this.getEntitesAlentours();
		
		System.out.println("Sur qui voulez vous utiliser " + potion.getNom() + " ?");
		for (int i = 0; i < listeCibles.size(); i++) {
			System.out.println(i+1 + ". " + listeCibles.get(i).getNom());
		}
		
		int reponse = Controleur.saisieInt() - 1;
		if (reponse < listeCibles.size())
			potion.affecterBonus(this.joueur, listeCibles.get(reponse));
		
		
		return true;
	}

	

	private void equiper() {
		
		System.out.print("Entrez le numero de l'objet a equiper : ");
		int numObj = Controleur.saisieInt() - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Objet objAEquiper = this.joueur.getInventaire().getObjet(numObj);
		if (this.joueur.equiperObjet(objAEquiper))
			System.out.println("Vous avez equipe : " + objAEquiper.getNom());
	}
	
	

	private void desequiper() {
		System.out.println("Entrez le numero de l'objet a desequiper : ");
		int numObj = Controleur.saisieInt() - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Objet objADesequiper = this.joueur.getEquipement().getObjet(numObj);
		if (this.joueur.desequiperObjet(objADesequiper))
			System.out.println("Vous avez desequipe : " + objADesequiper.getNom());
	}
	
	

	private void utiliser() {
		System.out.print("Entrez le numero de l'objet a utiliser : ");
		int numObj = Controleur.saisieInt() - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Objet objAUtiliser = this.joueur.getInventaire().getObjet(numObj);
		
		if (objAUtiliser instanceof Potion) {
			this.utiliserPotion((Potion)objAUtiliser);
		}
	}
	
	

	private boolean afficherCaracObjet() {
		System.out.println("Entrez le numero de l'objet : ");
		int numObj = Controleur.saisieInt() - 1;
		System.out.println("");
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Objet objet = this.joueur.getInventaire().getObjet(numObj);
		
		if (objet == null) {
			return false;
		}
		
		// Faire un joueur temporaire pour les calcules de difference
		// Joueur tempJoueur = new Joueur(this.joueur); // TODO:skeggib A faire
		
		// Nom de l'objet
		System.out.println(objet.getNom());
		
		// Les caracteristiques sont differentes pour les armes et les vetements
		
		if (objet instanceof Arme) {
			Arme arme = (Arme)objet;
			if (arme.getImpact() > 0)
				System.out.println("Impact : " + arme.getImpact());
			if (arme.getManiabilite() > 0)
				System.out.println("Maniabilite : " + arme.getManiabilite());
			Controleur.pause();
		}
		
		else if (objet instanceof Vetement) {
			Vetement vetement = (Vetement)objet;
			if (vetement.getAdresse() > 0)
				System.out.println("Adresse : " + vetement.getAdresse());
			if (vetement.getForce() > 0)
				System.out.println("Force : " + vetement.getForce());
			if (vetement.getResistance() > 0)
				System.out.println("Resistance : " + vetement.getResistance());
			Controleur.pause();
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	/* --- AUTRES METHODES --- */
	
	private ListeUnique<EntiteVivante> getEntitesAlentours() {
		if (this.joueur == null)
			return new ListeUnique<EntiteVivante>();
		
		ListeUnique<EntiteVivante> liste = new ListeUnique<EntiteVivante>();
		
		Position posJoueur = this.carte.getPosContenu(this.joueur);
		int distance = 1;
		for (int i = -distance; i <= distance; i++) {
			for (int j = -distance; j <= distance; j++) {
				
				Case caseAct = this.carte.getCase(posJoueur.getX() + i, posJoueur.getY() + j); 
				
				if (caseAct.contientEntite())
					liste.add((EntiteVivante)caseAct.getContenu());
			}
		}
		
		return liste;
	}
	
	private void ecrireLog(String message) {
		if (this.log != null)
			this.log.add(message);
	}
	
	public static int saisieInt() {
		int val = sc.nextInt();
		
		// Cider le buffer du scanner pour eviter une double saisie
		sc.nextLine();
		
		return val;
	}
	
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
	
	private static void pause() {
		System.out.println("\nAppuyez sur Entrer pour continuer...");
		sc.nextLine();
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
