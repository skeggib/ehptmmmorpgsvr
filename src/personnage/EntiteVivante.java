package personnage;

import carte.ContenuCase;

public abstract class EntiteVivante implements ContenuCase {

	/*
	 * Variables
	 */

	private String nom;

	private int pointAction;

	private int vie;

	private int force;
	private int adresse;
	private int resistance;
	private Inventaire inventaire = new Inventaire();
	private Equipement equipement = new Equipement();
	private Effet effet = new Effet();

	/*
	 * Constante
	 */

	public static final int MAX_VIE = 7;
	public static final int MIN_VIE = 0;
	
	/*
	 * Methode d'acces
	 */
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPointAction() {
		return pointAction;
	}
	public void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getAdresse() {
		return adresse;
	}
	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	public Effet getEffet() {
		return effet;
	}
	public void setEffet(Effet effet) {
		this.effet = effet;
	}

}
