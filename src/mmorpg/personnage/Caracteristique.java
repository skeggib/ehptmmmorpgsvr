package mmorpg.personnage;

import java.io.Serializable;

/**
 * Contient les caracteristiques influant sur l'entite.</br>
 * 
 * @author armya
 *
 */
public class Caracteristique implements Serializable {

	private static final long serialVersionUID = 6709953235120947528L;

	private int force;
	private int adresse;
	private int resistance;
	private int maniabilite;
	private int impact;

	/*
	 * Constructeurs
	 */

	public Caracteristique() {
		this.setForce(0);
		this.setAdresse(0);
		this.setResistance(0);
		this.setManiabilite(0);
		this.setImpact(0);
	}

	public Caracteristique(int force, int adresse, int resistance,
			int maniabilite, int impact) {
		this.setForce(force);
		this.setAdresse(adresse);
		this.setResistance(resistance);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}

	public Caracteristique(Caracteristique car) {
		this.setForce(car.getForce());
		this.setAdresse(car.getAdresse());
		this.setResistance(car.getResistance());
		this.setManiabilite(car.getManiabilite());
		this.setImpact(car.getImpact());
	}

	/*
	 * Methode
	 */

	public void ajouter(Caracteristique car) {
		this.ajouterForce(car.getForce());
		this.ajouterAdresse(car.getAdresse());
		this.ajouterResistance(car.getResistance());
		this.ajouterManiabilite(car.getManiabilite());
		this.ajouterImpact(car.getImpact());
	}

	public void reinitialiser() {
		this.setForce(0);
		this.setAdresse(0);
		this.setResistance(0);
		this.setManiabilite(0);
		this.setImpact(0);
	}

	public void reinitialiser(int force, int adresse, int resistance,
			int maniabilite, int impact) {
		this.setForce(force);
		this.setAdresse(adresse);
		this.setResistance(resistance);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}

	public void ajouterForce(int force) {
		this.setForce(this.getForce() + force);
	}

	public void ajouterAdresse(int adresse) {
		this.setAdresse(this.getAdresse() + adresse);
	}

	public void ajouterResistance(int resistance) {
		this.setResistance(this.getResistance() + resistance);
	}

	public void ajouterManiabilite(int maniabilite) {
		this.setManiabilite(this.getManiabilite() + maniabilite);
	}

	public void ajouterImpact(int impact) {
		this.setImpact(this.getImpact() + impact);
	}

	/*
	 * Methode d'acces
	 */

	public int getForce() {
		return this.force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getAdresse() {
		return this.adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public int getResistance() {
		return this.resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getManiabilite() {
		return this.maniabilite;
	}

	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public int getImpact() {
		return this.impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}
}
