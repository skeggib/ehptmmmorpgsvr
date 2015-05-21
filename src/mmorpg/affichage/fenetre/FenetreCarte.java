package mmorpg.affichage.fenetre;

import mmorpg.affichage.Image;
import mmorpg.affichage.ImagesCases;
import mmorpg.affichage.InterfaceTerm;
import mmorpg.affichage.Matrice;
import mmorpg.carte.Carte;
import mmorpg.carte.Position;
import mmorpg.personnage.Joueur;

/**
 * @author skeggib
 *
 */
public class FenetreCarte extends Fenetre {

	private int largeurCaseCarte;
	private int hauteurCaseCarte;
	private static int NB_CASES_AFFICHEES_X = 9;
	private static int NB_CASES_AFFICHEES_Y = 9;
	
	private int taille;
	
	// Largeur des espaces entre chaque cases
	private static int LARGEUR_ESPACE_CARTE = 1;
	private boolean espace = false;
	
	private Joueur joueur;
	private Carte carte;
	
	/* --- CONSTRUCTEURS --- */
	
	public FenetreCarte() {
		this(0);
	}

	/**
	 * Constructeur par taille
	 * @param w Largeur
	 * @param h Hauteur
	 */
	public FenetreCarte(int w, int h) {
		this();
	}
	
	/**
	 * Constructeur complet
	 * @param w Hauteur
	 * @param h Largeur
	 * @param titre Titre de la fenetre
	 */
	public FenetreCarte(int w, int h, String titre) {
		this(w, h);
		this.setTitre(titre);
	}
	
	public FenetreCarte(int taille) {
		this.setTaille(taille);
		this.setTitre("Carte");
	}
	
	/* --- METHODES --- */
	
	private void setTaille(int taille) {
		// Si la taille passee en parametre correspond a une case de la liste des tailles
		if (taille >= 0 && taille < InterfaceTerm.TAILLES.length)
			this.taille = taille;
		else
			this.taille = 0;
		
		switch (InterfaceTerm.TAILLES[this.taille]) {
		case "large":
			this.largeurCaseCarte = 7;
			this.hauteurCaseCarte = 4;
			break;
		case "normal":
			this.largeurCaseCarte = 5;
			this.hauteurCaseCarte = 3;
			break;
		case "small":
			this.largeurCaseCarte = 1;
			this.hauteurCaseCarte = 1;
			break;
		}
		
		this.creerMatrice();
	}
	
	private void creerMatrice() {
		int largeur = this.largeurCaseCarte * FenetreCarte.NB_CASES_AFFICHEES_X;
		if (this.espace)
			largeur += FenetreCarte.LARGEUR_ESPACE_CARTE * (FenetreCarte.NB_CASES_AFFICHEES_X + 1);

		int hauteur = this.hauteurCaseCarte * FenetreCarte.NB_CASES_AFFICHEES_Y;
		if (this.espace)
			hauteur += FenetreCarte.LARGEUR_ESPACE_CARTE * (FenetreCarte.NB_CASES_AFFICHEES_Y + 1);
		
		this.setTaille(largeur + FenetreCarte.LARGEUR_CADRE, hauteur + FenetreCarte.LARGEUR_CADRE);
	}
	
	private boolean dessinerCarte() {
		
		if (this.carte == null)
			return false;
		if (this.joueur == null)
			return false;
		
		// Image a dessiner
		Image img;
		
		// Position de la case dans la matrice
		int posCaseMatrX;
		int posCaseMatrY;
		
		// Position (sur la this.carte) de la premiere case affichee
		int posPremCaseX;
		int posPremCaseY;
		
		/* CALCUL DE LA POSITION DE LA PREMIERE CASE AFFICHEE (pour centrer le joueur) */
		
		// Position du joueur sur la this.carte
		Position posJoueur = this.carte.getPosContenu(this.joueur);
		if (posJoueur == null)
			return false;
		
		// Calcul de cette position
		posPremCaseX = posJoueur.getX() - FenetreCarte.NB_CASES_AFFICHEES_X / 2;
		posPremCaseY = posJoueur.getY() - FenetreCarte.NB_CASES_AFFICHEES_Y / 2;
		
		// Verifier le depassement et le corriger si besoin
		if (posPremCaseX > this.carte.getLargeur() - FenetreCarte.NB_CASES_AFFICHEES_X)
			posPremCaseX = this.carte.getLargeur() - FenetreCarte.NB_CASES_AFFICHEES_X;
		else if (posPremCaseX < 0)
			posPremCaseX = 0;
		if (posPremCaseY > this.carte.getHauteur() - FenetreCarte.NB_CASES_AFFICHEES_Y)
			posPremCaseY = this.carte.getHauteur() - FenetreCarte.NB_CASES_AFFICHEES_Y;
		else if (posPremCaseY < 0)
			posPremCaseY = 0;
		
		/* DESSIN DES CASES */
		
		for (int i = 0; i < FenetreCarte.NB_CASES_AFFICHEES_Y; i++) {
			for (int j = 0; j < FenetreCarte.NB_CASES_AFFICHEES_X; j++) {
				img = new Image();
				img = ImagesCases.getImage(this.taille, this.carte.getCase(posPremCaseX + j, posPremCaseY + i));
				
				if (this.espace) {
					posCaseMatrX = FenetreCarte.LARGEUR_ESPACE_CARTE + j * (this.largeurCaseCarte + FenetreCarte.LARGEUR_ESPACE_CARTE);
					posCaseMatrY = FenetreCarte.LARGEUR_ESPACE_CARTE + i * (this.hauteurCaseCarte + FenetreCarte.LARGEUR_ESPACE_CARTE);
				}
				else {
					posCaseMatrX = j * this.largeurCaseCarte;
					posCaseMatrY = i * this.hauteurCaseCarte;
				}
				
				this.getMatrice().dessinerImage(posCaseMatrX, posCaseMatrY, img);
			}
		}
		
		return true;
	}
	
	public Matrice getMatriceFen() {
		this.dessinerCarte();
		return super.getMatriceFen();
	}
	
	/* --- GETTERS / SETTERS --- */

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Carte getCarte() {
		return this.carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
}
