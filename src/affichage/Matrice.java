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
		
		this.pxls = new Pixel[w][h];
		
		// Mettre tout les pixels par defaut
		Pixel defaultPixel = new Pixel();
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++)
				this.setPixel(i, j, defaultPixel);
		}
	}
	
	/**
	 * Set Pixel
	 * @param x Colonne
	 * @param y Ligne
	 * @param p Nouveau Pixel
	 * @return True si le Pixel à été changé, false si non
	 */
	private boolean setPixel(int x, int y, Pixel p) {
		// Si on ne dépasse pas de la matrice
		if (x <= this.largeur &&
			y <= this.hauteur &&
			x >= 0 &&
			y >= 0)
		{
			pxls[x][y] = p;
			return true;
		}
		else
			return false;
	}
}
