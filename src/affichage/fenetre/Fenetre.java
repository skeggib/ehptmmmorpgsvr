package affichage.fenetre;

import affichage.Matrice;
import affichage.Pixel;

public class Fenetre { // TODO:skeggib Mettre abstract
	
	private int largeur;
	private int hauteur;
	private String titre;
	
	private Matrice matrice;
	
	public static final int LARGEUR_CADRE = 2;
	
	/* --- CONTRUCTEURS --- */
	
	public Fenetre() {
		this.largeur = 1;
		this.hauteur = 1;
		this.setTitre("Fenetre");
		this.matrice = new Matrice(this.largeur - Fenetre.LARGEUR_CADRE, this.hauteur - Fenetre.LARGEUR_CADRE);
	}

	/**
	 * Constructeur par taille
	 * @param w Largeur
	 * @param h Hauteur
	 */
	public Fenetre(int w, int h) {
		this.largeur = w;
		this.hauteur = h;
		this.setTitre("Fenetre");
		this.matrice = new Matrice(this.largeur - Fenetre.LARGEUR_CADRE, this.hauteur - Fenetre.LARGEUR_CADRE);
	}
	
	/**
	 * Constructeur complet
	 * @param w Hauteur
	 * @param h Largeur
	 * @param titre Titre de la fenetre
	 */
	public Fenetre(int w, int h, String titre) {
		this(w, h);
		this.setTitre(titre);
	}
	
	/* METHODES */
	
	/**
	 * @return Une matrice contenant la representation de la fenetre
	 */
	public Matrice getMatrice() {
		// On cree une matrice plus grande de 2 pixels (en h et en w)
		Matrice rtrn = new Matrice(this.largeur, this.hauteur);
		
		// Lignes en haut et en bas
		Pixel ligneHorizontale = new Pixel('-', "BLACK", "WHITE");
		rtrn.dessinerRectangle(0, 0, rtrn.getLargeur(), 1, ligneHorizontale);
		rtrn.dessinerRectangle(0, rtrn.getHauteur() - 1, rtrn.getLargeur(), 1, ligneHorizontale);
		
		// Lignes a gauche et a droite
		Pixel ligneVerticale = new Pixel('|', "BLACK", "WHITE");
		rtrn.dessinerRectangle(0, 1, 1, rtrn.getHauteur() - 2, ligneVerticale);
		rtrn.dessinerRectangle(rtrn.getLargeur() - 1, 1, 1, rtrn.getHauteur() - 2, ligneVerticale);
		
		// Coins
		Pixel coin = new Pixel('+', "BLACK", "WHITE");
		rtrn.dessinerRectangle(0, 0, 1, 1, coin);
		rtrn.dessinerRectangle(rtrn.getLargeur() - 1, 0, 1, 1, coin);
		rtrn.dessinerRectangle(0, rtrn.getHauteur() - 1, 1, 1, coin);
		rtrn.dessinerRectangle(rtrn.getLargeur() - 1, rtrn.getHauteur() - 1, 1, 1, coin);
		
		// Titre
		String texte = " " + this.titre + " ";
		int posXTexte = rtrn.getLargeur() / 2 - texte.length() / 2;
		rtrn.dessinerTexte(posXTexte, 0, texte, "BLACK", "WHITE");
		
		// Insertion de la matrice
		rtrn.dessinerMatrice(1, 1, this.matrice);
		
		return rtrn;
	}
	
	/* GETTERS / SETTERS */

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
