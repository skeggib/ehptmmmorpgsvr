package affichage;

import java.awt.Color;

import carte.Carte;
import carte.Case;
import personnage.Joueur;

public class InterfaceTerm {
	
	private static final int LARGEUR_CASE_CARTE = 5;
	private static final int HAUTEUR_CASE_CARTE = 4;
	private static final int NB_CASES_AFFICHEES_X = 9;
	private static final int NB_CASES_AFFICHEES_Y = 9;
	
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
	 * @param joueur Joueur autour duquel la carte va etre centree
	 * @return True si la carte a ete dessinee, false si non
	 */
	public boolean dessinerCarte(Carte carte, Joueur joueur) { // TODO: Centrer le joueur
		if (carte == null || joueur == null)
			return false;
		
		/* VARIABLES */
		
		// Case joueur (pour l'image)
		Case caseJoueur = new Case(Case.JOUEUR_PRINCIPAL);
		
		// Case actuelle
		Case caseAct;
		
		// Position de la case dans la matrice
		int posCaseMatrX;
		int posCaseMatrY;
		
		// Largeur des espaces entre chaque cases
		int largeurEspace = 1;
		
		// Largeur de la marge autours de la carte
		int marge = 1;
		
		// Position (sur la carte) de la premiere case affichee
		int posPremCaseX;
		int posPremCaseY;
		
		/* CALCUL DE LA POSITION DE LA PREMIERE CASE AFFICHEE (pour centrer le joueur) */
		
		// Calcul de cette position
		posPremCaseX = joueur.getPositionX() - InterfaceTerm.NB_CASES_AFFICHEES_X / 2;
		posPremCaseY = joueur.getPositionY() - InterfaceTerm.NB_CASES_AFFICHEES_Y / 2;
		
		// Verifier le depassement et le corriger si besoin
		if (posPremCaseX > carte.getLargeur() - InterfaceTerm.NB_CASES_AFFICHEES_X)
			posPremCaseX = carte.getLargeur() - InterfaceTerm.NB_CASES_AFFICHEES_X;
		else if (posPremCaseX < 0)
			posPremCaseX = 0;
		if (posPremCaseY > carte.getHauteur() - InterfaceTerm.NB_CASES_AFFICHEES_Y)
			posPremCaseY = carte.getHauteur() - InterfaceTerm.NB_CASES_AFFICHEES_Y;
		else if (posPremCaseY < 0)
			posPremCaseY = 0;
		
		/* DESSIN DES CASES */
		
		for (int i = 0; i < InterfaceTerm.NB_CASES_AFFICHEES_Y; i++) {
			for (int j = 0; j < InterfaceTerm.NB_CASES_AFFICHEES_X; j++) {
				caseAct = carte.getCase(posPremCaseX + j, posPremCaseY + i);
				posCaseMatrX = marge + j * (InterfaceTerm.LARGEUR_CASE_CARTE + largeurEspace);
				posCaseMatrY = marge + i * (InterfaceTerm.HAUTEUR_CASE_CARTE + largeurEspace);
				
				this.matrice.dessinerImage(posCaseMatrX, posCaseMatrY, caseAct.getImage());
				
				// Dessiner le joueur si la case actuelle correspond a sa position
				if (posPremCaseX + j == joueur.getPositionX() && posPremCaseY + i == joueur.getPositionY()) {
					System.out.println("posPremCaseX + j = " + posPremCaseX + j);
					System.out.println("posPremCaseY + i = " + posPremCaseY + i);
					this.matrice.dessinerImage(posCaseMatrX, posCaseMatrY, caseJoueur.getImage());
				}
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
