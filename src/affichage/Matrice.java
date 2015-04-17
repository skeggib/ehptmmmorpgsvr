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
		if (x <= largeur &&
			y <= hauteur &&
			x >= 0 &&
			y >= 0)
		{
			pxls[x][y] = p;
			return true;
		}
		else
			return false:
	}
}
