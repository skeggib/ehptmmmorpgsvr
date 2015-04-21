package affichage;

import carte.Carte;
import carte.Case;
import personnage.Joueur;

public class InterfaceTerm {
	
	private static final int LARGEUR_CASE_CARTE = 5;
	private static final int HAUTEUR_CASE_CARTE = 4;
	private static final int NB_CASES_AFFICHEES_X = 11;
	private static final int NB_CASES_AFFICHEES_Y = 11;
	
	private Matrice matrice;
	private Joueur joueur;
	
	public InterfaceTerm() {
		this.matrice = new Matrice(170, 47);
	}
	
	/**
	 * Constructeur par taille
	 * @param largeur Largeur de l'affichage
	 * @param hauteur Hauteur de l'affichage
	 */
	public InterfaceTerm(int largeur, int hauteur) {
		this.matrice  = new Matrice(largeur, hauteur);
	}
	
	public boolean setJoueur(Joueur j) {
		if (j == null)
			return false;
		
		this.joueur = j;
		
		return true;
	}
	
	/**
	 * Dessine une carte dans l'interface (ne l'affiche pas)
	 * @param carte Carte a dessiner
	 * @return True si la carte a ete dessinee, false si non
	 */
	public boolean dessinerCarte(Carte carte) { // TODO: Centrer le joueur
		if (carte == null)
			return false;
		
		Case caseActuelle;
		int posCaseX;
		int posCaseY;
		for (int i = 0; i < carte.getHauteur(); i ++) {
			for (int j = 0; j < carte.getLargeur(); j++) {
				caseActuelle = carte.getCase(j, i);
				posCaseX = j * InterfaceTerm.LARGEUR_CASE_CARTE;
				posCaseY = i * InterfaceTerm.HAUTEUR_CASE_CARTE;
				this.matrice.dessinerImage(posCaseX, posCaseY, caseActuelle.getImage());
			}
		}
		
		return true;
	}
	
	/**
	 * Affiche l'interface
	 */
	public void afficher() {
		this.matrice.afficher();
	}
}
