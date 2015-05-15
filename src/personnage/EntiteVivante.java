package personnage;

import items.Objet;

import java.util.List;

import carte.Case;
import carte.ContenuCase;

public abstract class EntiteVivante implements ContenuCase {

	/*
	 * Constante
	 */

	public static final int MAX_VIE = 7;
	public static final int MIN_VIE = 0;

	public static final int BASE_PA = 20;
	public static final int MIN_PA = 0;

	/*
	 * Variables
	 */

	// Demi constante qui ne peut etre modifier qu'avec
	// une potion qui augmente le nombre de PA pour un
	// certains nombre de tour
	private int MAX_PA;

	private String nom;

	private int pointAction;

	private int vie;

	private Case emplacement;

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
		this.setVie(EntiteVivante.MAX_VIE);
		this.setMAX_PA(EntiteVivante.BASE_PA);
	}

	public EntiteVivante(int force, int adresse, int resistance) {
		this.setForce(force);
		this.setAdresse(adresse);
		this.setResistance(resistance);
		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(EntiteVivante.MAX_VIE);
		this.setMAX_PA(EntiteVivante.BASE_PA);
	}

	public EntiteVivante(int force, int adresse, int resistance, int vie) {
		this.setForce(force);
		this.setAdresse(adresse);
		this.setResistance(resistance);
		this.setVie(vie);
		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
	}

	/*
	 * Methode
	 */
	public void seDeplacer(Case destination) { // TODO:armya Faire un retour boolean (si le deplacement a ete fait ou non) SANS OUBLIER L'UML
		if (destination.ajoutContenu(this)) {
			if (this.emplacement != null) // skeggib : J'ai du rejouter ce test car si non ca me faisait un nullPointerExeption
				this.emplacement.supprContenu();
			this.setEmplacement(destination);
		}
	}

	public void attaquer(EntiteVivante cible) {
		cible.retirerVie(1);
	}

	public boolean rammasserObjet(Objet obj) {
		return this.inventaire.ajouterObjet(obj);
	}

	public boolean equiperObjet(Objet obj) {
		if (this.inventaire.retirerObjet(obj)) {
			if (!this.equipement.ajouterObjet(obj)) {
				return this.inventaire.ajouterObjet(obj);
			}
		}
		return false;
	}

	public boolean desequiperObjet(Objet obj) {
		if (this.equipement.retirerObjet(obj)) {
			if (!this.inventaire.ajouterObjet(obj)) {
				return this.equipement.ajouterObjet(obj);
			}
		}
		return false;
	}

	public boolean deposerObjet(Objet obj, Case destination) {
		return destination.ajoutContenu(obj);
	}

	public void ajouterVie(int vie) {
		if (vie > 0) {
			this.setVie(this.getVie() + vie);
		}
	}

	public void retirerVie(int vie) {
		if (vie < 0) {
			this.setVie(this.getVie() - vie);
		}
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

	public void controlerEffet() {
		for (int i = 0; i < this.effet.size(); i++) {
			if (this.effet.get(i).decrementerTour()) {
				this.retirerEffet(this.effet.get(i));
			}
		}
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

	public int getPointAction() {
		return pointAction;
	}

	private void setPointAction(int pointAction) {
		this.pointAction = pointAction;

		if (this.getPointAction() < EntiteVivante.MIN_PA) {
			this.pointAction = EntiteVivante.MIN_PA;
		}
		if (this.getPointAction() > EntiteVivante.BASE_PA) {
			this.pointAction = EntiteVivante.BASE_PA;
		}
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

	public Case getEmplacement() {
		return emplacement;
	}

	private void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}

	public int getMAX_PA() {
		return MAX_PA;
	}

	private void setMAX_PA(int max_pa) {
		MAX_PA = max_pa;
	}

}
