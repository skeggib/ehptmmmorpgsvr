package personnage;

import java.util.List;

import carte.ContenuCase;

public abstract class EntiteVivante implements ContenuCase {

	/*
	 * Variables
	 */

	private String nom;

	private int pointAction;

	private int vie = EntiteVivante.MAX_VIE;

	private int force;
	private int adresse;
	private int resistance;
	private Inventaire inventaire;
	private Equipement equipement;
	private List<Effet> effet;

	/*
	 * Constructeurs
	 */

	public EntiteVivante() {
		this.setForce(0);
		this.setAdresse(0);
		this.setResistance(0);
		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
	}

	/*
	 * Constante
	 */

	public static final int MAX_VIE = 7;
	public static final int MIN_VIE = 0;

	/*
	 * Methode
	 */
	
	public abstract String randNom ();

	public void ajouterVie(int vie) {
		if (vie > 0) {
			this.setVie(this.getVie() + vie);

			if (this.getVie() < EntiteVivante.MIN_VIE) {
				this.setVie(EntiteVivante.MIN_VIE);
			}
			if (this.getVie() > EntiteVivante.MAX_VIE) {
				this.setVie(EntiteVivante.MAX_VIE);
			}
		}
	}

	public void retirerVie(int vie) {
		this.setVie(this.getVie() - vie);
	}

	public boolean ajouterEffet(Effet effet) {
		if (!this.effet.contains(effet)) {
			this.effet.add(effet);
			if (this.effet.contains(effet)) {
				return true;
			}
		}
		return false;
	}

	public boolean retirerEffet(Effet effet) {
		if (this.effet.contains(effet)) {
			this.effet.remove(effet);
			if (!this.effet.contains(effet)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Methode d'acces
	 */

	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		if (this.nom == null) {
			this.nom = nom;
		}
	}

	public int getPointAction() {
		return pointAction;
	}

	private void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}

	public int getVie() {
		return vie;
	}

	private void setVie(int vie) {
		this.vie = vie;

		if (this.getVie() < EntiteVivante.MIN_VIE) {
			this.vie = EntiteVivante.MIN_VIE;
		}
		if (this.getVie() > EntiteVivante.MAX_VIE) {
			this.vie = EntiteVivante.MAX_VIE;
		}
	}

	public int getForce() {
		return force;
	}

	private void setForce(int force) {
		this.force = force;

		if (this.getForce() < 0) {
			this.force = 0;
		}
	}

	public int getAdresse() {
		return adresse;
	}

	private void setAdresse(int adresse) {
		this.adresse = adresse;

		if (this.getAdresse() < 0) {
			this.adresse = 0;
		}
	}

	public int getResistance() {
		return resistance;
	}

	private void setResistance(int resistance) {
		this.resistance = resistance;

		if (this.getResistance() < 0) {
			this.resistance = 0;
		}
	}

	public Equipement getEquipement() {
		return equipement;
	}

	private void setEquipement(Equipement equipement) {
		if (this.equipement == null) {
			this.equipement = equipement;
		}
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	private void setInventaire(Inventaire inventaire) {
		if (this.inventaire == null) {
			this.inventaire = inventaire;
		}
	}

}
