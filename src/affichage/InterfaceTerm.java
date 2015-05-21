package affichage;

import jeu.Log;
import affichage.fenetre.FenetreCarte;
import affichage.fenetre.FenetreInfosJoueur;
import affichage.fenetre.FenetreLog;
import personnage.Joueur;
import carte.Carte;
import carte.Position;

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
	
	private FenetreCarte fenCarte;
	private FenetreLog fenLog;
	private FenetreInfosJoueur fenInfos;
	
	public InterfaceTerm() { // TODO:skeggib Regler la taille et le placement des fenetres en fonction de la taille
		// TODO:skeggib Faire une "grille"
		this.fenCarte = new FenetreCarte(0); // TODO: Choisir la taille
		this.fenLog = new FenetreLog(30, 10);
		
		int largeur = this.fenCarte.getLargeur() + this.fenLog.getLargeur();
		int hauteur = this.fenCarte.getHauteur();
		
		this.matrice = new Matrice(largeur, hauteur);
		
		this.fenInfos = new FenetreInfosJoueur(this.fenLog.getLargeur(), this.matrice.getHauteur() - this.fenLog.getHauteur());
	}

	public boolean afficher(Joueur joueur, Carte carte) {
		if (!this.dessinerInterface(joueur, carte))
			return false;
		
		this.matrice.afficher();
		
		return true;
	}
	
	private boolean dessinerInterface(Joueur joueur, Carte carte) { // TODO:skeggib Ajouter setter joueur et carte
		
		this.fenCarte.setCarte(carte);
		this.fenCarte.setJoueur(joueur);
		this.matrice.dessinerFenetre(0, 0, fenCarte);
		this.matrice.dessinerFenetre(this.fenCarte.getLargeur(), this.matrice.getHauteur() - this.fenLog.getHauteur(), fenLog);
		this.fenInfos.setJoueur(joueur);
		this.matrice.dessinerFenetre(this.fenCarte.getLargeur(), 0, this.fenInfos);
		
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
}
