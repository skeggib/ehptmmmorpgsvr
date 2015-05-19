package affichage.fenetre;

import affichage.Matrice;

public abstract class Fenetre {
	
	private int largeur;
	private int hauteur;
	private String titre;
	
	private Matrice matrice;
	
	/* --- CONTRUCTEURS --- */
	
	public Fenetre() {
		this.largeur = 1;
		this.hauteur = 1;
		this.setTitre("Fenetre");
		this.matrice = new Matrice(this.largeur, this.hauteur);
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
		this.matrice = new Matrice(this.largeur, this.hauteur);
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
	
	public Matrice getMatrice() {
		// On cree une matrice plus grande de 2 pixels (en h et en w)
		Matrice rtrn = new Matrice(this.matrice.getLargeur() + 2, this.matrice.getHauteur() + 2);
		
		// TODO: Creer la Matrice a retourner
		
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
