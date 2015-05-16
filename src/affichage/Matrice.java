package affichage;

public class Matrice {
	
	private int hauteur;
	private int largeur;
	private Pixel[][] pxls;
	
	/**
	 * Constructeur par taille
	 * @param w Largeur de l'affichage
	 * @param h Hauteur de l'affichage
	 */
	public Matrice(int w, int h) {
		this.largeur = w;
		this.hauteur = h;
		
		this.pxls = new Pixel[h][w];
		
		// Mettre tout les pixels par defaut
		Pixel defaultPixel = new Pixel();
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++)
				this.setPixel(i, j, defaultPixel);
		}
	}
	
	/**
	 * Affiche la matrice dans le terminal
	 */
	public void afficher() {
		String str = new String();
		
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++) {
				str += this.pxls[i][j].getPixelCouleur();
			}
			str += "\n";
		}
		
		System.out.print(str);
	}
	
	/**
	 * Verifier si les coordonnes depassent de la carte
	 * @param x Abcisse
	 * @param y Ordonne
	 * @return True si les coordonnes depassent
	 */
	private boolean depasse(int x, int y) {
		if (x < 0 || x >= this.largeur ||
			y < 0 || y >= this.hauteur)
			return true;
		
		return false;
	}
	
	/**
	 * Dessine un rectangle dans la matrice
	 * @param x Colonne
	 * @param y Ligne
	 * @param w Largeur
	 * @param h Hauteur
	 * @param p Pixel qui va remplir le rectangle
	 * @return True si le rectangle a ete dessine, false si non
	 */
	public boolean dessinerRectangle(int x, int y, int w, int h, Pixel p) {
		// Tester si le rectangle est bien place dans la matrice
		if (this.depasse(x, y) ||
			p == null)
			return false;
		
		for	(int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				this.setPixel(j + y, i + x, p);
			}
		}
		
		return true;
	}

	/**
	 * Dessine une Image dans la matrice
	 * @param x
	 * @param y
	 * @param img
	 * @return True si l'image a ete dessinee, false si non
	 */
	public boolean dessinerImage(int x, int y, Image img) {
		if (this.depasse(x, y) ||
			img == null)
			return false;
		
		Pixel[][] table = img.getTableau();
		for (int i = 0; i < img.getHauteur(); i++) {
			for (int j = 0; j < img.getLargeur(); j++) {
				this.setPixel(i + y, j + x, table[i][j]);
			}
		}
		
		return true;
	}
	
	/**
	 * Ecrit du texte dans la matrice
	 * @param x
	 * @param y
	 * @param texte Texte a ecrire
	 * @param couleur Couleur du texte
	 * @param couleurFond Couleur du fond
	 * @return True si le texte a ete ecrit
	 */
	public boolean dessinerTexte(int x, int y, String texte, String couleur, String couleurFond) {
		if (this.depasse(x, y) ||
			texte == null)
			return false;
		
		for (int i = 0; i < texte.length(); i++) {
			Pixel pix = new Pixel(); // TODO:skeggib Sortir le new de la boucle
			pix.setCouleur(couleur);
			pix.setCouleurFond(couleurFond);
			pix.setCar(texte.charAt(i));
			this.setPixel(y, x + i, pix);
		}
		
		return true;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public String toString() {
		String rtrn = new String();
		
		rtrn += this.largeur + "x" + this.largeur + "\n";
		
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++) {
				rtrn += this.pxls[i][j].getCar();
			}
			rtrn += "\n";
		}
		
		return rtrn;
	}
	
	private boolean setPixel(int y, int x, Pixel p) {
		// Si on ne depasse pas de la matrice
		if (x < this.largeur &&
			y < this.hauteur &&
			x >= 0 &&
			y >= 0)
		{
			this.pxls[y][x] = p;
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		Matrice matr = new Matrice(50, 20);
		
		matr.dessinerTexte(5, 10, "Salut !", "BLACK", "WHITE");
		
		matr.afficher();
		
	}

}
