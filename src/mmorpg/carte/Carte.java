package mmorpg.carte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.Monstre;

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
	 * @throws Exception 
	 */
	public Carte(String chemin) throws Exception {
		this.chargerFichier(chemin);
	}
	
	/**
	 * Charge une carte a partir d'un fichier
	 * @param chemin Chemin du fichier carte a charger
	 * @return True si le fichier a ete charge
	 * @throws Exception 
	 */
	public boolean chargerFichier(String chemin) throws Exception {
		String str;
		
		try {
			str = LectureRessource.lire(chemin);
		} catch (Exception e) {
			throw new Exception("Impossible de charger la carte", e);
		}
		
		return this.chargerString(str);
	}
	
	/**
	 * Charge la carte a partir d'un String
	 * @param str String a charger
	 * @return True si le String a ete charge
	 */
	private boolean chargerString(String str) {
		String[] lignes = str.split("\n");
		
		// Verifier que toute les lignes ont les meme taille
		int lengthLine0 = lignes[0].length();
		for (int i = 0; i < lignes.length; i++) {
			if (lignes[i].length() != lengthLine0)
				return false;
		}
		
		this.creerTableau(lignes.length, lengthLine0);

		// On remplit le tableau
		for (int i = 0; i < lignes.length; i++) {
			for (int j = 0; j < lengthLine0; j ++) {
				switch (lignes[i].toLowerCase().charAt(j)) {
					case ' ':
						this.cases[i][j].changerContenu(new Vide());
						break;
					case 'm':
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
	
	/**
	 * Ajout des monstres aleatoirement sur une carte
	 * 
	 * @param carte
	 * @return La liste de monstres qui ont ete crees
	 */
	public ArrayList<Monstre> ajoutMonstres() {
		
		Random rand = new Random();
		int randInt;

		ArrayList<Monstre> liste = new ArrayList<Monstre>();
		ArrayList<Monstre> rtrn = new ArrayList<Monstre>(); // Liste de monstres
															// qui va etre
															// retournee
		Monstre tempMonstre;

		// Chance qu'a chaque case de recevoir un Monstre en %
		int chanceCase = 5;
		// Chance que chaque monstre a de devenir un groupe de monstres en %
		int chanceDevientGroupe = 10;

		// On ajoute des monstres aleatoirement dans la carte sur les cases
		// vides
		for (int i = 0; i < this.getHauteur(); i++) {
			for (int j = 0; j < this.getLargeur(); j++) {
				if (this.getCase(j, i).estVide()) {
					randInt = rand.nextInt(100);
					if (randInt < chanceCase) {
						tempMonstre = new Monstre();
						liste.add(tempMonstre);
						tempMonstre.initialiserPos(this.getCase(j, i));
					}
				}
			}
		}

		rtrn.addAll(liste);

		Position posM;

		// On creer les groupes de monstre
		// Pourque chaque monstre existant
		for (int i = 0; i < liste.size(); i++) {
			// On fait un rand pour savoir si le monstre va devenir un groupe
			randInt = rand.nextInt(100);
			if (randInt < chanceDevientGroupe) {
				posM = this.getPosContenu(liste.get(i));

				// Chaque case autours du monstre a 1 chance sur 3 de recevoir
				// un monstre
				for (int y = posM.getY() - 1; y <= posM.getY() + 1; y++) {
					for (int x = posM.getX() - 1; x <= posM.getX() + 1; x++) {
						randInt = rand.nextInt(100);
						if (randInt < 33) {
							tempMonstre = new Monstre();
							tempMonstre.initialiserPos(this.getCase(x, y));
							rtrn.add(tempMonstre);
						}
					}
				}
			}
		}

		return rtrn;
	}
}
