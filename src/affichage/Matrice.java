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
	
	public void afficher() {
		String str = new String();
		
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++) {
				str += this.pxls[i][j].toStringCouleur();
			}
			str += "\n";
		}
		
		System.out.println(str);
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
