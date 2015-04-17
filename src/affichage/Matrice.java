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
		Pixel defaultPixel = new Pixel(); // TODO: Mettre à default
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
				str += this.pxls[i][j].toStringCouleur();
			}
			str += "\n";
		}
		
		System.out.print(str);
	}
	
	/**
	 * Dessine un rectangle dans la matrice
	 * @param x Colonne
	 * @param y Ligne
	 * @param w Largeur
	 * @param h Hauteur
	 * @param p Pixel qui va remplir le rectangle
	 * @return True si le rectangle a été dessiné, false si non
	 */
	public boolean dessinerRectangle(int x, int y, int w, int h, Pixel p) {
		// Tester si le rectangle est bien placé dans la matrice
		if (x < 0 || x > this.largeur ||
			y < 0 || y > this.hauteur ||
			p == null)
			return false;
		
		for	(int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				this.setPixel(i + x, j + y, p);
			}
		}
		
		return true;
	}
	
	/**
	 * Set Pixel
	 * @param y Ligne
	 * @param x Colonne
	 * @param p Nouveau Pixel
	 * @return True si le Pixel à été changé, false si non
	 */
	private boolean setPixel(int y, int x, Pixel p) {
		// Si on ne dépasse pas de la matrice
		if (x <= this.largeur &&
			y <= this.hauteur &&
			x >= 0 &&
			y >= 0)
		{
			this.pxls[y][x] = p;
			return true;
		}
		else
			return false;
	}
	
	public String toString() {
		String rtrn = new String();
		
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++) {
				rtrn += this.pxls[i][j].getChar();
			}
			rtrn += "\n";
		}
		
		return rtrn;
	}
}
