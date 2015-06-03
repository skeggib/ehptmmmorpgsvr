package mmorpg.carte;

import java.io.Serializable;

import mmorpg.fichiers.LectureFichier;

public class Carte implements Serializable{

	private static final long serialVersionUID = -8071199923180382885L;
	
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
	public boolean chargerFichier(String chemin) { //TODO skeggib : Revoir cette methode (voir issue)
		
		// Lire le fichier
		String lines[] = LectureFichier.lireT(chemin);
		String str = new String();
		
		// Reconstituer les lines en une seule chaine
		for (int i = 0; i < lines.length; i++)
			str += lines[i] + "\n";
		
		this.chargerString(str);
		
		return true; //TODO skeggib : Retourne tout le temps True.. Autant faire "return this.chargerString(str)"
	}
	
	/**
	 * Charge la carte a partir d'un String
	 * @param str String a charger
	 * @return True si le String a ete charge
	 */
	private boolean chargerString(String str) { //TODO skeggib : Revoir cette methode (voir issue)
		String[] lignes = str.split("\n");
		
		// Verifier que toute les lignes ont les meme taille
		int lengthLine0 = lignes[0].length();
		for (int i = 0; i < lignes.length; i++) {
			if (lignes[i].length() != lengthLine0)
				return false;
		}
		
		this.creerTableau(lignes.length, lignes[0].length()); //TODO Skeggib : lignes[0].length() est deja instancié dans int lengthLine0 (ligne 69)
																//En plus tu le reutilise ligne 79, soit logique jusqu'au bout
		// On remplit le tableau
		for (int i = 0; i < lignes.length; i++) {
			for (int j = 0; j < lengthLine0; j ++) {
				switch (lignes[i].charAt(j)) { //TODO skeggib : Utilise un str.toLowerCase() : evite de faire un "case 'M' "
					case ' ':
						this.cases[i][j].changerContenu(new Vide());
						break;
					case 'm':
						this.cases[i][j].changerContenu(new Mur());
						break;
					case 'M':
						this.cases[i][j].changerContenu(new Mur());
						break;
					default:
						this.cases[i][j].changerContenu(new Inconnu());
						break;
				}
			}
		}
				
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
	
	public Position getPosContenu(ContenuCase contenu) {
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (contenu == this.cases[i][j].getContenu())
					return new Position(j, i);
			}
		}
		
		return null;
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
		rtrn += "Hauteur : " + this.hauteur + "\n";
		rtrn += "\n";
		
		for (int i = 0; i < this.cases.length; i ++) {
			for (int j = 0; j < this.cases[i].length; j ++) {
				if (this.cases[i][j].getContenu().getNumero() == ContenuCase.VIDE)
					rtrn += " ";
				else
					rtrn += this.cases[i][j].getContenu().getNumero();
			}
			rtrn += "\n";
		}
		
		return rtrn;
	}
}
