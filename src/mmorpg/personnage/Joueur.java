package mmorpg.personnage;

import mmorpg.carte.ContenuCase;

/**
 * 
 * Cette classe permet la gestion d'un Joueur (EntiteVivante controllee par une personne physique)
 * 
 * @author armya
 *
 */
public class Joueur extends EntiteVivante {

	public static final int BASE_PA = 20;

	/*
	 * Constructeur
	 */

	public Joueur() {
		super();
		this.setPointAction(Joueur.BASE_PA);
	}

	public Joueur(String nom) {
		super();
		this.setNom(nom);
		this.setPointAction(Joueur.BASE_PA);
	}

	public Joueur(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.setNom(nom);
		this.setPointAction(Joueur.BASE_PA);
	}

	public Joueur(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.setNom(nom);
		this.setPointAction(Joueur.BASE_PA);
	}

	/*
	 * Methodes
	 */

	public int getNumero() {
		return ContenuCase.JOUEUR;
	}

	public void recupererPA() {
		int pa = this.getPointAction();
		int newPa = pa + Joueur.BASE_PA / 2;

		if (newPa > Joueur.BASE_PA) {
			newPa = Joueur.BASE_PA;
		}
		this.setPointAction(newPa);
	}

}
