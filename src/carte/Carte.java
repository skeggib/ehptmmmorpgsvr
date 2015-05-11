package carte;

public class Carte {

	private int hauteur;
	private int largeur;
	
	private Case[][] cases;
	
	/**
	 * Constructeur vide
	 */
	public Carte() {
		
	}
	
	/**
	 * Contructeur par taille
	 * @param hauteur
	 * @param largeur
	 */
	public Carte(int hauteur, int largeur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		this.cases = new Case[hauteur][largeur];
		
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++)
				this.cases[i][j] = new Case();
		}
	}
	
	/**
	 * Constructeur par chemin
	 * @param chemin Chemin du fichier carte a charger
	 */
	public Carte(String chemin) {
		this.chargerFichier(chemin);
	}
	
	/**
	 * Charge une carte a partir d'un fichier
	 * @param chemin Chemin du fichier carte a charger
	 * @return True si le fichier a ete charge
	 */
	public boolean chargerFichier(String chemin) {
		// TODO: A faire
		return true;
	}
	
	/**
	 * Charge la carte a partir d'un String
	 * @param str String a charger
	 * @return True si le String a ete charge
	 */
	private boolean chargerString(String str) {
		// TODO: A faire
		return true;
	}
	
	public Case getCase(int x, int y) {
		return this.cases[y][x];
	}
	
	public int getHauteur() {
		return hauteur;
	}
	
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public String toString() {
		String rtrn = "";
		
		rtrn += "Largeur : " + this.largeur + "\n";
		rtrn += "Hauteur : " + this.hauteur;
		
		return rtrn;
	}
	
}
