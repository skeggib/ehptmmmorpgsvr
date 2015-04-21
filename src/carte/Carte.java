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
	
	/**
	 * Constructeur par fichier, charge la carte a partir d'un fichier
	 * @param chemin Chemin du fichier
	 */
	public Carte(String chemin) { // TODO: A faire
		this(10, 10);
		this.chargerFichier("");
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	/**
	 * Charge la carte a partir d'un fichier
	 * @param chemin Chemin du fichier
	 * @return True si la carte a ete chargee, false si non
	 */
	private boolean chargerFichier(String chemin) { // TODO: A faire
		
		// Le fichier contiendra la hauteur, la largeur et le String qui correspond au cases
		
		String str = new String();
		str += "3;3;3;3;2;2;2;2;2;2\n";
		str += "3;3;3;3;2;2;2;2;2;2\n";
		str += "3;3;2;2;2;1;2;2;2;2\n";
		str += "2;2;2;2;2;2;2;2;2;2\n";
		str += "2;2;2;2;2;0;2;2;2;2\n";
		str += "2;2;2;2;2;2;2;2;2;2\n";
		str += "2;2;2;2;2;2;2;2;2;2\n";
		str += "2;2;2;2;2;2;2;2;2;2\n";
		str += "2;2;2;2;2;2;2;2;2;2\n";
		str += "2;2;2;2;2;2;2;2;2;2\n";
		
		if (!this.chargerString(str))
			return false;
		
		return true;
	}
	
	/**
	 * Charge la carte a partir d'un String
	 * @param str
	 * @return
	 */
	private boolean chargerString(String str) {
		// On split les lignes
		String[] lines;
		lines = str.split("\n");
		// On verifie que le nombre de lignes correspond
		if (lines.length != this.hauteur)
			return false;
		
		// On split chaque ligne pour avoir les cases
		String[][] cases = new String[lines.length][];
		for (int i = 0; i < lines.length; i++) {
			cases[i] = lines[i].split(";");
			// On verifie a chaque fois que le nombre de cases par ligne correspond
			if (cases[i].length != this.largeur)
				return false;
		}
		
		// On enregistre les cases
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j ++) {
				this.cases[i][j].setValeur(Integer.parseInt(cases[i][j]));
			}
		}
		
		return true;
	}
	
	public Case getCase(int x, int y) {
		return cases[y][x];
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
