package affichage;

/**
 * "Image" qui peut etre inseree dans une Matrice
 * @author skeggib
 *
 */
public class Image {
	private int largeur;
	private int hauteur;
	private Pixel[][] pxls;
	
	/**
	 * Creer l'image a partir d'un String de la forme : "abcd\nabcd\nabcd" 
	 * qui donne l'Image :
	 * 
	 * abcd
	 * abcd
	 * abcd
	 * 
	 * @param str
	 * @return
	 */
	public boolean chargerString(String str) {
		// Enlever le dernier caractere s'il est '\n'
		if (str.charAt(str.length() - 1) == '\n')
			str = str.substring(0, str.length() - 1);
		
		String[] parts = str.split("\n");
		
		// Vérifier qu'il y a au moins une ligne
		if (parts.length == 0)
			return false;
		
		// Vérifier que chaque ligne a la même longueur
		for (int i = 1; i < parts.length; i++) {
			if (parts[i].length() != parts[i-1].length())
				return false;
		}
		
		// Enregistrer la hauteur et la largeur
		this.hauteur = parts.length;
		this.largeur = parts[0].length();
		
		// Créer le tableau
		this.pxls = new Pixel[hauteur][largeur];
		
		// Créer et charger les pixels
		for (int i = 0; i < parts.length; i++) {
			for (int j = 0; j < parts[i].length(); j++) {
				this.pxls[i][j] = new Pixel();
				this.pxls[i][j].setChar(parts[i].charAt(j));
			}
		}
		
		return true;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	/**
	 * Retourne le tableau qui contient les Pixels de l'image
	 * @return
	 */
	public Pixel[][] getTableau() {
		return this.pxls;
	}
	
	public String toString() {
		String str = new String();
		
		for (int i = 0; i < this.pxls.length; i++) {
			for (int j = 0; j < this.pxls[i].length; j++) {
				str += this.pxls[i][j].getChar();
			}
			str += "\n";
		}
		
		return str;
	}
}
