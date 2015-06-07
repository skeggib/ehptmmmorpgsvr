package mmorpg.items;

import java.io.Serializable;

import mmorpg.carte.ContenuCase;
import mmorpg.personnage.EntiteVivante;
import mmorpg.personnage.ListeUnique;
import mmorpg.personnage.Ramassable;

public abstract class Objet implements ContenuCase, Ramassable, Serializable {

	/*
	 * Variables
	 */

	private static final long serialVersionUID = -518488975585350727L;

	private String nom;

	/*
	 * Constructeur
	 */

	public Objet() {

	}

	/*
	 * Methodes
	 */

	public ListeUnique<Objet> getListeObjet() {
		ListeUnique<Objet> liste = new ListeUnique<Objet>();
		liste.add(this);
		return liste;
	}

	/**
	 * Attribut un nom aleatoire a l'objet
	 * 
	 * @return String nom correspondant a l'objet
	 */
	public abstract String randNom();

	/**
	 * Retourne une copie de l'objet
	 */
	public abstract Objet clone();

	/**
	 * Retoune ce qu'est l'objet (Un vetement, une arme, une potion)
	 * 
	 * @return Ce qu'est l'objet
	 */
	public abstract String getType();

	/**
	 * Affecte le bonus a l'objet
	 * 
	 * @param cible
	 *            Cible qui recoit le bonus
	 */
	public abstract void affecterBonus(EntiteVivante utilisateur,
			EntiteVivante cible);

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
