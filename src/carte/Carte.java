package carte;

public class Carte {
	private Case[][] cases;
	private int hauteur;
	private int largeur;
	
	/**
	 * Constructeur par taille
	 * @param largeur
	 * @param hauteur
	 */
	public Carte(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		this.cases = new Case[hauteur][largeur];
		
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++)
				this.cases[i][j] = new Case(Case.VIDE);
		}
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public String toString() {
		String str = new String();
		
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				str += this.cases[i][j];
			}
			str += "\n";
		}
		
		return str;
	}
}
