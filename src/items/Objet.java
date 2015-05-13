package items;

import personnage.EntiteVivante;
import carte.ContenuCase;

public abstract class Objet implements ContenuCase {

	/*
	 * Variables
	 */

	public static final String[] NOM = null;

	private String nom;

	/*
	 * Constructeur
	 */

	public Objet() {

	}
	
	/*
	 * Methodes
	 */
	
	public abstract String randNom ();
	
	public abstract void affecterBonus (EntiteVivante cible);
	
	public int getNumero(){
		return ContenuCase.OBJET;
	}

	/*
	 * Methode d'acces
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
