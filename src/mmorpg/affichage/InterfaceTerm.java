package mmorpg.affichage;

import mmorpg.affichage.fenetre.FenetreCarte;
import mmorpg.affichage.fenetre.FenetreInfosJoueur;
import mmorpg.affichage.fenetre.FenetreInventaire;
import mmorpg.affichage.fenetre.FenetreLog;
import mmorpg.carte.Carte;
import mmorpg.jeu.Log;
import mmorpg.personnage.Joueur;

/**
 * 
 * Interface textuelle du jeu "ehptmmorpgsvr".</br>
 * </br>
 * Affiche la carte du jeu, des informations</br>
 * relatives au joueur et les logs.</br>
 * 
 * pour l'itiliser il suffit de l'instancier avec</br>
 * son constructeur par default puis de lui donner :</br>
 * </br>
 *     - Un objet Joueur</br>
 *     - Une objet Carte</br>
 *     - Un objet Log</br>
 * </br>
 * Ex:</br>
 * </br>
 * <pre>{@code
 * InterfaceTerm inter = new InterfaceTerm();
 * inter.setLog(log);
 * inter.setCarte(carte);
 * inter.setJoueur(joueur);
 * }</pre>
 * 
 * @author Sébastien Klasa
 *
 */
public class InterfaceTerm {
	
	private Matrice matrice;
	
	private int largeur;
	private int hauteur;
	
	private FenetreCarte fenCarte;
	private FenetreLog fenLog;
	private FenetreInfosJoueur fenInfos;
	private FenetreInventaire fenInventaire;
	
	// Modes dans lequels peut être l'interface
	public static final int MODE_JEU = 1;
	public static final int MODE_INVENTAIRE = 2;
	public static final int MODE_PERSONNAGE = 3;
	
	private int mode;
	
	/**
	 * Tailles de l'interface possibles
	 */
	public static final String[] TAILLES = {"large", "normal", "small"};
	int taille;
	
	public InterfaceTerm() {
		this(0);
	}
	
	public InterfaceTerm(int taille) {
		this.mode = InterfaceTerm.MODE_JEU;
		this.taille = taille;
		this.autoPositionTailleFen();
		this.matrice = new Matrice(this.largeur, this.hauteur);
	}
	
	private void autoPositionTailleFen() {
		
		switch (InterfaceTerm.TAILLES[this.taille]) {
		case "large":
			
			this.fenCarte = new FenetreCarte(this.taille);
			
			this.fenCarte.setPosX(0);
			this.fenCarte.setPosY(0);
			
			this.fenLog = new FenetreLog(this.fenCarte.getLargeur() / 3 * 2, this.fenCarte.getHauteur());
			this.fenLog.setPosX(this.fenCarte.getLargeur());
			this.fenLog.setPosY(0);
			
			this.fenInfos = new FenetreInfosJoueur(this.fenLog.getLargeur(), this.fenCarte.getHauteur() + this.fenLog.getHauteur());
			this.fenInfos.setPosX(this.fenCarte.getLargeur() + this.fenLog.getLargeur());
			this.fenInfos.setPosY(0);
			
			this.largeur = this.fenCarte.getLargeur() + this.fenLog.getLargeur() + this.fenInfos.getLargeur();
			this.hauteur = this.fenCarte.getHauteur();
			
			break;
			
		case "normal":
			
			this.fenCarte = new FenetreCarte(this.taille);
			
			this.fenCarte.setPosX(0);
			this.fenCarte.setPosY(0);
			
			this.fenLog = new FenetreLog(this.fenCarte.getLargeur() / 3 * 2, this.fenCarte.getHauteur());
			this.fenLog.setPosX(this.fenCarte.getLargeur());
			this.fenLog.setPosY(0);
			
			this.fenInfos = new FenetreInfosJoueur(this.fenLog.getLargeur(), this.fenCarte.getHauteur() + this.fenLog.getHauteur());
			this.fenInfos.setPosX(this.fenCarte.getLargeur() + this.fenLog.getLargeur());
			this.fenInfos.setPosY(0);
			
			this.largeur = this.fenCarte.getLargeur() + this.fenLog.getLargeur() + this.fenInfos.getLargeur();
			this.hauteur = this.fenCarte.getHauteur();
			
			break;
			
		case "small":
			
			this.fenCarte = new FenetreCarte(this.taille);
			
			this.fenLog = new FenetreLog(this.fenCarte.getLargeur() * 2, this.fenCarte.getHauteur());
			this.fenLog.setPosX(0);
			this.fenLog.setPosY(0);
			
			this.fenCarte.setPosX(0);
			this.fenCarte.setPosY(this.fenLog.getHauteur());
			
			this.fenInfos = new FenetreInfosJoueur(this.fenLog.getLargeur(), this.fenCarte.getHauteur() + this.fenLog.getHauteur());
			this.fenInfos.setPosX(this.fenLog.getLargeur());
			this.fenInfos.setPosY(0);
			
			this.largeur = this.fenLog.getLargeur() + this.fenInfos.getLargeur();
			this.hauteur = this.fenCarte.getHauteur() + this.fenLog.getHauteur();
			
			break;
		}
		
		this.fenInventaire = new FenetreInventaire(this.largeur, this.hauteur);
		this.fenInventaire.setPosX(0);
		this.fenInventaire.setPosY(0);
	}

	public boolean afficher() {
		if (!this.dessinerInterface())
			return false;
		
		this.matrice.afficher();
		
		return true;
	}
	
	private boolean dessinerInterface() { // TODO:skeggib Doit pouvoir lever une exception (ModeNotSetException)
		
		switch (this.mode) {
		
		case InterfaceTerm.MODE_JEU:
			this.matrice.dessinerFenetre(this.fenCarte);
			this.matrice.dessinerFenetre(this.fenLog);
			this.matrice.dessinerFenetre(this.fenInfos);
			break;
			
		case InterfaceTerm.MODE_INVENTAIRE:
			this.matrice.dessinerFenetre(this.fenInventaire);
			break;
			
		case InterfaceTerm.MODE_PERSONNAGE:
			// TODO:skeggib A faire
			break;
			
		default:
				
			break;
		}
		
		return true;
	}
	
	public String toString() {
		String rtrn = new String();
		rtrn += "Matrice : " + this.matrice.getLargeur() + "x" + this.matrice.getHauteur();
		
		return rtrn;
	}

	public void setLog(Log log) {
		this.fenLog.setLog(log);
	}
	
	public void setCarte(Carte carte) {
		this.fenCarte.setCarte(carte);
	}
	
	public void setJoueur(Joueur joueur) {
		this.fenCarte.setJoueur(joueur);
		this.fenInfos.setJoueur(joueur);
		this.fenInventaire.setJoueur(joueur);
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public int getMode() {
		return this.mode;
	}
}
