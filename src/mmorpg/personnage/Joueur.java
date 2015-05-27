package mmorpg.personnage;

import mmorpg.carte.Case;
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
		this.setPointAction(BASE_PA);
	}

	public Joueur(String nom) {
		super();
		this.setNom(nom);
		this.setPointAction(BASE_PA);
	}

	public Joueur(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.setNom(nom);
		this.setPointAction(BASE_PA);
	}

	public Joueur(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.setNom(nom);
		this.setPointAction(BASE_PA);
	}

	/*
	 * Methodes
	 */

	public int getNumero() {
		return ContenuCase.JOUEUR;
	}

	public boolean seDeplacer(Case destination) {
		if (this.getPointAction() >= Joueur.PA_DEPLACEMENT) {
			if (super.seDeplacer(destination)) {
				this.setPointAction(this.getPointAction()
						- Joueur.PA_DEPLACEMENT);
				return true;
			}
		}
		return false;
	}

	public int attaquer(EntiteVivante cible) {
		if (this.getPointAction() >= Joueur.PA_ATTAQUE) {
			this.setPointAction(this.getPointAction() - Joueur.PA_ATTAQUE);
			return super.attaquer(cible);
		}
		return 0;
	}

	public void recupererPA() {
		int pa = this.getPointAction();
		int newPa = pa + this.getMAX_PA() / 2;

		if (newPa > this.getMAX_PA()) {
			newPa = this.getMAX_PA();
		}
		this.setPointAction(newPa);
	}

	/*
	 * Methode d'acces
	 */

	public int getMAX_PA() {
		return Joueur.BASE_PA;
	}

}
