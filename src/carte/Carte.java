package carte;

import fichiers.LectureFichier;

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
		this.creerTableau(hauteur, largeur);
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
		
		// Lire le fichier
		String lines[] = LectureFichier.lire(chemin);
		String str = new String();
		
		// Reconstituer les lines en une seule chaine
		for (int i = 0; i < lines.length; i++)
			str += lines[i] + "\n";
		
		this.chargerString(str);
		
		return true;
	}
	
	/**
	 * Charge la carte a partir d'un String
	 * @param str String a charger
	 * @return True si le String a ete charge
	 */
	private boolean chargerString(String str) {
		String[] lignes = str.split("\n");
		
		// Verifier que toute les lignes ont les même taille
		int lengthLine0 = lignes[0].length();
		for (int i = 0; i < lignes.length; i++) {
			if (lignes[i].length() != lengthLine0)
				return false;
		}
		
		this.creerTableau(lignes.length, lignes[0].length());
		
		// TODO: A finir
				
		return true;
	}
	
	private void creerTableau(int hauteur, int largeur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		this.cases = new Case[hauteur][largeur];
		
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++)
				this.cases[i][j] = new Case();
		}
	}
	
	public Case getCase(int x, int y) {
		return this.cases[y][x];
	}
	
	public int getHauteur() {
		return hauteur;
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public String toString() {
		String rtrn = "";
		
		rtrn += "Largeur : " + this.largeur + "\n";
		rtrn += "Hauteur : " + this.hauteur;
		
		return rtrn;
	}
	
}
