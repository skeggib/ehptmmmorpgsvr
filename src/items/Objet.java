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

	/**
	 * Attribut un nom aleatoire a l'objet
	 * 
	 * @return String nom correspondant a l'objet
	 */
	public abstract String randNom();

	/**
	 * Affecte le bonus a l'objet
	 * 
	 * @param cible
	 *            Cible qui recoit le bonus
	 */
	public abstract void affecterBonus(EntiteVivante cible);

	public int getNumero() {
		return ContenuCase.OBJET;
	}

	/*
	 * Methode d'acces
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (this.nom == null) {

			this.nom = nom;
		}
	}
}
