package mmorpg.affichage;

import mmorpg.affichage.fenetre.FenetreCarte;
import mmorpg.affichage.fenetre.FenetreInfosJoueur;
import mmorpg.affichage.fenetre.FenetreLog;
import mmorpg.carte.Carte;
import mmorpg.carte.Position;
import mmorpg.jeu.Log;
import mmorpg.personnage.Joueur;

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
