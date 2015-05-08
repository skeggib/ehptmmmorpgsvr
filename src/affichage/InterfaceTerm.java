package affichage;

import carte.Carte;
import carte.Case;
import personnage.Joueur;

public class InterfaceTerm {
	
	private static int LARGEUR_CASE_CARTE;
	private static int HAUTEUR_CASE_CARTE;
	private static final int NB_CASES_AFFICHEES_X = 13;
	private static final int NB_CASES_AFFICHEES_Y = 9;
	
	public static final String[] TAILLES = {"large", "normal", "small"};
	
	private int taille;
	
	private Matrice matrice;
	private Joueur joueur;
	private Carte carte;
	
	// Largeur des espaces entre chaque cases
	private static int LARGEUR_ESPACE_CARTE = 1;
	
	// Largeur de la marge autours de la carte
	private static final int MARGE_CARTE = 1;
	
	@SuppressWarnings("unused")
	private InterfaceTerm() {};
	
	public InterfaceTerm(int taille) {
		this.setTaille(taille);
	}
	
	private void setTaille(int t) {
		this.taille = t;
		switch (InterfaceTerm.TAILLES[t]) {
			case "large":
				InterfaceTerm.HAUTEUR_CASE_CARTE = 4;
				InterfaceTerm.LARGEUR_CASE_CARTE = 7;
				InterfaceTerm.LARGEUR_ESPACE_CARTE = 1;
				break;
			case "normal":
				InterfaceTerm.HAUTEUR_CASE_CARTE = 3;
				InterfaceTerm.LARGEUR_CASE_CARTE = 5;
				InterfaceTerm.LARGEUR_ESPACE_CARTE = 1;
				break;
			case "small":
				InterfaceTerm.HAUTEUR_CASE_CARTE = 1;
				InterfaceTerm.LARGEUR_CASE_CARTE = 1;
				InterfaceTerm.LARGEUR_ESPACE_CARTE = 0;
				break;
		}
		
		int largeurMatr = InterfaceTerm.MARGE_CARTE * 2 + InterfaceTerm.NB_CASES_AFFICHEES_X * (InterfaceTerm.LARGEUR_CASE_CARTE + InterfaceTerm.LARGEUR_ESPACE_CARTE);
		int hauteurMatr = InterfaceTerm.MARGE_CARTE * 2 + InterfaceTerm.NB_CASES_AFFICHEES_Y * (InterfaceTerm.HAUTEUR_CASE_CARTE + InterfaceTerm.LARGEUR_ESPACE_CARTE);
		this.matrice = new Matrice(largeurMatr, hauteurMatr);
	}
	
	public boolean setJoueur(Joueur j) {
		if (j == null)
			return false;
		
		this.joueur = j;
		
		return true;
	}
	
	public boolean setCarte(Carte carte) {
		if (carte == null)
			return false;
		
		this.carte = carte;
		
		return true;
	}
	
	/**
	 * Dessine une carte dans l'interface (ne l'affiche pas)
	 * @param carte Carte a dessiner
	 * @param joueur Joueur autour duquel la carte va etre centree
	 * @return True si la carte a ete dessinee, false si non
	 */
	public boolean dessinerCarte() { // TODO: Mettre en prive
		if (this.carte == null || this.joueur == null)
			return false;
		
		/* VARIABLES */
		
		// Case joueur (pour l'image)
		Case caseJoueur = new Case(Case.JOUEUR_PRINCIPAL);
		
		// Case actuelle
		Case caseAct;
		
		// Position de la case dans la matrice
		int posCaseMatrX;
		int posCaseMatrY;
		
		// Position (sur la carte) de la premiere case affichee
		int posPremCaseX;
		int posPremCaseY;
		
		/* CALCUL DE LA POSITION DE LA PREMIERE CASE AFFICHEE (pour centrer le joueur) */
		
		// Calcul de cette position
		posPremCaseX = this.joueur.getPositionX() - InterfaceTerm.NB_CASES_AFFICHEES_X / 2;
		posPremCaseY = this.joueur.getPositionY() - InterfaceTerm.NB_CASES_AFFICHEES_Y / 2;
		
		// Verifier le depassement et le corriger si besoin
		if (posPremCaseX > this.carte.getLargeur() - InterfaceTerm.NB_CASES_AFFICHEES_X)
			posPremCaseX = this.carte.getLargeur() - InterfaceTerm.NB_CASES_AFFICHEES_X;
		else if (posPremCaseX < 0)
			posPremCaseX = 0;
		if (posPremCaseY > this.carte.getHauteur() - InterfaceTerm.NB_CASES_AFFICHEES_Y)
			posPremCaseY = this.carte.getHauteur() - InterfaceTerm.NB_CASES_AFFICHEES_Y;
		else if (posPremCaseY < 0)
			posPremCaseY = 0;
		
		/* DESSIN DES CASES */
		
		for (int i = 0; i < InterfaceTerm.NB_CASES_AFFICHEES_Y; i++) {
			for (int j = 0; j < InterfaceTerm.NB_CASES_AFFICHEES_X; j++) {
				caseAct = this.carte.getCase(posPremCaseX + j, posPremCaseY + i);
				posCaseMatrX = InterfaceTerm.MARGE_CARTE + j * (InterfaceTerm.LARGEUR_CASE_CARTE + InterfaceTerm.LARGEUR_ESPACE_CARTE);
				posCaseMatrY = InterfaceTerm.MARGE_CARTE + i * (InterfaceTerm.HAUTEUR_CASE_CARTE + InterfaceTerm.LARGEUR_ESPACE_CARTE);
				
				this.matrice.dessinerImage(posCaseMatrX, posCaseMatrY, caseAct.getImage(this.taille));
				
				// Dessiner le joueur si la case actuelle correspond a sa position
				if (posPremCaseX + j == this.joueur.getPositionX() && posPremCaseY + i == this.joueur.getPositionY()) {
					this.matrice.dessinerImage(posCaseMatrX, posCaseMatrY, caseJoueur.getImage(this.taille));
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Affiche l'interface
	 */
	public void afficher() {
		this.dessinerCarte();
		this.matrice.afficher();
	}
}
