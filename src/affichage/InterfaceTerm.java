package affichage;

import affichage.fenetre.FenetreCarte;
import personnage.Joueur;
import carte.Carte;
import carte.Position;

public class InterfaceTerm {
	
	private Matrice matrice;
	
	private FenetreCarte fenCarte;
	
	public InterfaceTerm() {
		this.fenCarte = new FenetreCarte(0); // TODO: Choisir la taille
		
		int largeur = this.fenCarte.getLargeur();
		int hauteur = this.fenCarte.getHauteur();
		
		this.matrice = new Matrice(largeur, hauteur);
	}

	public boolean afficher(Joueur joueur, Carte carte) {
		if (!this.dessinerInterface(joueur, carte))
			return false;
		
		this.matrice.afficher();
		
		return true;
	}
	
	private boolean dessinerInterface(Joueur joueur, Carte carte) {
		
		this.fenCarte.setCarte(carte);
		this.fenCarte.setJoueur(joueur);
		this.matrice.dessinerFenetre(0, 0, fenCarte);
		
		return true;
	}
	
	public String toString() {
		String rtrn = new String();
		rtrn += "Matrice : " + this.matrice.getLargeur() + "x" + this.matrice.getHauteur();
		
		return rtrn;
	}
}
