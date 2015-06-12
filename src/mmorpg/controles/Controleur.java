package mmorpg.controles;

import java.io.Serializable;
import java.util.Scanner;

import mmorpg.affichage.InterfaceTerm;
import mmorpg.carte.Carte;
import mmorpg.carte.Case;
import mmorpg.carte.Position;
import mmorpg.items.Arme;
import mmorpg.items.Item;
import mmorpg.items.Potion;
import mmorpg.items.Vetement;
import mmorpg.jeu.Log;
import mmorpg.personnage.Caracteristique;
import mmorpg.personnage.EntiteVivante;
import mmorpg.personnage.Joueur;
import mmorpg.personnage.ListeUnique;
import mmorpg.personnage.Ramassable;

public class Controleur implements Serializable {

	private static final long serialVersionUID = 3905422874543746084L;
	
	
	
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
			+ "\n\t p : Utiliser l'experience"
			+ "\n\t r : Retour"
			+ "\n\t t : Terminer le tour"
			+ "\n\t x : Quitter";
	
	private static final String TEXTE_AIDE_INVENTAIRE = 
			"Aide :"
			+ "\n\t h : Afficher cette aide"
			+ "\n\t e : Equiper un objet"
			+ "\n\t d : Desequiper un objet"
			+ "\n\t u : Uiliser un objet"
			+ "\n\t s : Supprimer un objet"
			+ "\n\t c : Afficher les caracteristiques d'un objet de l'inventaire"
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
	 * @return QUITTER ou TERMINER_TOUR
	 */
	public int saisieAction() {
		System.out.print("Que voulez vous faire ? (tapez 'h' pour afficher l'aide) ");
		
		// On fonction du mode dans lequel est l'interface
		switch (this.inter.getMode()) {
		
		case InterfaceTerm.MODE_JEU:
			return this.saisieActionJeu();
		case InterfaceTerm.MODE_INVENTAIRE:
			return this.saisieActionInventaire();
			
		}
		
		return -1;
	}
	
	
	
	/**
	 * Demande une saisie d'action en mode JEU et effectue l'action demandee
	 * @return QUITTER ou TERMINER_TOUR
	 */
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
			this.utiliserXP();
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
	
	
	
	/**
	 * Demande une saisie d'action en mode INVENTAIRE et effectue l'action demandee
	 * @return QUITTER ou TERMINER_TOUR
	 */
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
		case 's':
			this.supprimer();
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
	
	
	
	
	
	
	
	
	
	
	
	
	/* --- ACTIONS --- */

	/**
	 * Affiche l'aide en fonction du mode actuel
	 */
	private void afficherAide() {
		
		switch (this.inter.getMode()) {
		case InterfaceTerm.MODE_JEU:
			System.out.println(Controleur.TEXTE_AIDE_JEU);
			break;
		case InterfaceTerm.MODE_INVENTAIRE:
			System.out.println(Controleur.TEXTE_AIDE_INVENTAIRE);
			break;
		}
		
		Controleur.pause();
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
			return this.attaquer(ennemi);
		}
		
		// Si la destination contient un ramassable
		else if (destination.contientRamassable()) {
			Ramassable ramassable = (Ramassable) destination.getContenu();
			this.joueur.ramasser(ramassable);
			destination.supprContenu();
			
			ListeUnique<Item> liste = ramassable.getContenu();
			for (int i = 0; i < liste.size(); i++) {
				this.ecrireLog(this.joueur.getNom() + " rammasse " + liste.get(i).getNom());
			}
			
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
		
		int reponse = Controleur.saisieInt(1, listeCibles.size()) - 1;
		if (reponse < listeCibles.size())
			potion.affecterBonus(this.joueur, listeCibles.get(reponse));
		
		
		return true;
	}

	

	private void equiper() {
		
		System.out.print("Entrez le numero de l'objet a equiper : ");
		int numObj = Controleur.saisieInt(1, this.joueur.getInventaire().getTaille()) - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Item objAEquiper = this.joueur.getInventaire().get(numObj);
		if (this.joueur.equiper(objAEquiper))
			System.out.println("Vous avez equipe : " + objAEquiper.getNom());
	}
	
	

	private void desequiper() {
		System.out.println("Entrez le numero de l'objet a desequiper : ");
		int numObj = Controleur.saisieInt(1, this.joueur.getEquipement().getTaille()) - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Item objADesequiper = this.joueur.getEquipement().get(numObj);
		if (this.joueur.desequiper(objADesequiper))
			System.out.println("Vous avez desequipe : " + objADesequiper.getNom());
	}
	
	

	private void utiliser() {
		System.out.print("Entrez le numero de l'objet a utiliser : ");
		int numObj = Controleur.saisieInt(1, this.joueur.getInventaire().getTaille()) - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Item objAUtiliser = this.joueur.getInventaire().get(numObj);
		
		if (objAUtiliser instanceof Potion) {
			this.utiliserPotion((Potion)objAUtiliser);
		}
	}
	
	
	
	private void supprimer() {
		System.out.print("Entrez le numero de l'objet a utiliser : ");
		int numObj = Controleur.saisieInt(1, this.joueur.getInventaire().getTaille()) - 1;
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Item objASupprimer = this.joueur.getInventaire().get(numObj);
		this.joueur.supprimer(objASupprimer);
	}
	
	

	private boolean afficherCaracObjet() {
		System.out.println("Entrez le numero de l'objet : ");
		int numObj = Controleur.saisieInt(1, this.joueur.getInventaire().getTaille()) - 1;
		System.out.println("");
		// -1 car la numerotation des objets dans l'affichage commence a 1
		Item objet = this.joueur.getInventaire().get(numObj);
		
		if (objet == null) {
			return false;
		}
		
		// Nom de l'objet
		System.out.println(objet.getNom());
		
		// Les caracteristiques sont differentes pour les armes et les vetements
		
		if (objet instanceof Arme) {
			Arme arme = (Arme)objet;
			if (arme.getImpact() > 0)
				System.out.println("Impact : " + arme.getImpact());
			if (arme.getManiabilite() > 0)
				System.out.println("Maniabilite : " + arme.getManiabilite());
		}
		
		else if (objet instanceof Vetement) {
			Vetement vetement = (Vetement)objet;
			if (vetement.getAdresse() > 0)
				System.out.println("Adresse : " + vetement.getAdresse());
			if (vetement.getForce() > 0)
				System.out.println("Force : " + vetement.getForce());
			if (vetement.getResistance() > 0)
				System.out.println("Resistance : " + vetement.getResistance());
		}
		
		// Calcul de la diferrence de caracteristiques si on equipe l'objet
		
		System.out.println("\nEffet apres equipement : ");
		
		Joueur copieJoueur = new Joueur(this.joueur);
		copieJoueur.ramasser(objet);
		copieJoueur.equiper(objet);

		Caracteristique caracJoueur = this.joueur.getCaractEquip();
		Caracteristique caracCopie = copieJoueur.getCaractEquip();

		int diffForce = caracCopie.getForce() - caracJoueur.getForce();
		int diffAdresse = caracCopie.getAdresse() - caracJoueur.getAdresse();
		int diffResistance = caracCopie.getResistance() - caracJoueur.getResistance();
		int diffManiabilite = caracCopie.getManiabilite() - caracJoueur.getManiabilite();
		int diffImpact = caracCopie.getImpact() - caracJoueur.getImpact();

		if (diffForce != 0) {
			System.out.print("Force : ");
			if (diffForce > 0)
				System.out.print("+");
			System.out.println(diffForce);
		}
		if (diffAdresse != 0) {
			System.out.print("Adresse : ");
			if (diffAdresse > 0)
				System.out.print("+");
			System.out.println(diffAdresse);
		}
		if (diffResistance != 0) {
			System.out.print("Resistance : ");
			if (diffResistance > 0)
				System.out.print("+");
			System.out.println(diffResistance);
		}
		if (diffManiabilite != 0) {
			System.out.print("Maniabilite : ");
			if (diffManiabilite > 0)
				System.out.print("+");
			System.out.println(diffManiabilite);
		}
		if (diffImpact != 0) {
			System.out.print("Impact : ");
			if (diffImpact > 0)
				System.out.print("+");
			System.out.println(diffImpact);
		}
			
		

		Controleur.pause();
		
		return true;
	}
	
	
	
	
	private void utiliserXP() {
		
		int xp = this.joueur.getExperience();
		
		System.out.println("\nVous avez " + xp + " XP");
		System.out.println("Quelle caracteristique voulez-vous agmenter ?");
		
		Caracteristique carac = joueur.getCaractPrinc();
		int force = carac.getForce();
		int xpToNextForce = Joueur.expPourNiveauSuivant(force);
		int adresse = carac.getAdresse();
		int xpToNextAdresse = Joueur.expPourNiveauSuivant(adresse);
		int resistance = carac.getResistance();
		int xpToNextResistance = Joueur.expPourNiveauSuivant(resistance);
		
		System.out.println("0. Aucune");
		
		System.out.print("1. Force " + force + " -> " + (force + 1) + " ");
		if (xpToNextForce <= xp)
			System.out.println("(-" + xpToNextForce + " XP)");
		else
			System.out.println("(Pas assez d'XP)");
		
		System.out.print("2. Adresse " + adresse + " -> " + (adresse + 1) + " ");
		if (xpToNextAdresse <= xp)
			System.out.println("(-" + xpToNextAdresse + " XP)");
		else
			System.out.println("(Pas assez d'XP)");
		
		System.out.print("3. Force " + resistance + " -> " + (resistance + 1) + " ");
		if (xpToNextResistance <= xp)
			System.out.println("(-" + xpToNextResistance + " XP)");
		else
			System.out.println("(Pas assez d'XP)");
		
		
		
		int reponse  = Controleur.saisieInt(0, 3);
		
		switch (reponse) {
		case 1:
			this.joueur.augmenterNiveauForce();
			break;
		case 2:
			this.joueur.augmenterNiveauAdresse();
			break;
		case 3:
			this.joueur.augmenterNiveauResistance();
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	/* --- AUTRES METHODES --- */
	
	/**
	 * @return La liste des EntiteVivante autours du joueur
	 */
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
	
	
	
	/**
	 * Ecrit un message dans les logs (véfifie que les logs existent)
	 * @param message
	 */
	private void ecrireLog(String message) {
		if (this.log != null)
			this.log.add(message);
	}
	
	
	
	
	/**
	 * Demande la saisie d'un integer
	 * @return L'integer saisi
	 */
	public static int saisieInt() throws Exception{
		try{
			int val = sc.nextInt();			
			return val;
		} catch (Exception e){
			throw new Exception("Caractere entre invalide", e);
		} finally {
			sc.nextLine();
		}
	}
	
	
	
	
	/**
	 * Demande la saisie d'un integer securisee
	 * @param min Minimum
	 * @param max Maximum
	 * @return L'integer saisi
	 */
	public static int saisieInt(int min, int max) {
		
		int reponse;
		
		// Tant que la reponse n'est pas correcte
		do {
			// Gere les exception du genre : l'utilisateur entre un caractere
			try {
				System.out.print("(" + min + " - " + max + ") : ");
				reponse = Controleur.saisieInt();
			} catch (Exception e) {
				// On met une valeur inferieure a min pour redemander une saisie
				reponse = (min - 1);
			}
		} while (reponse < min || reponse > max);
		
		return reponse;
		
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
	
	
	/**
	 * Effectue une pause dans le terminal
	 */
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
