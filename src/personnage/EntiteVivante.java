package personnage;

import items.Objet;
import carte.Case;
import carte.ContenuCase;

public abstract class EntiteVivante implements ContenuCase { // TODO:skeggib
																// Verifier
																// toute cette
																// classe -> MAJ
																// UML

	/*
	 * Constante
	 */

	public static final int MAX_VIE = 7;
	public static final int MIN_VIE = 0;

	public static final int MIN_PA = 0;

	/*
	 * Variables
	 */

	private String nom;

	private int pointAction;

	private int vie;

	private Case emplacement;

	private Caracteristique caractEntite;
	private Caracteristique caractEquipe;

	private Inventaire inventaire;
	private Equipement equipement;
	private ListeUnique<Effet> effet;

	/*
	 * Constructeurs
	 */

	public EntiteVivante() {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(EntiteVivante.MAX_VIE);
		this.effet = new ListeUnique<Effet>();
	}

	public EntiteVivante(int force, int adresse, int resistance) {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(EntiteVivante.MAX_VIE);
		this.effet = new ListeUnique<Effet>();
	}

	public EntiteVivante(int force, int adresse, int resistance, int vie) {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(vie);
		this.effet = new ListeUnique<Effet>();
	}

	/*
	 * Methode
	 */

	/**
	 * Permet de se deplacer
	 * 
	 * @param destination
	 *            Case de destination
	 * @return true si le deplacement est reussi, false sinon
	 */
	public boolean seDeplacer(Case destination) {
		if (destination.ajoutContenu(this)) {
			this.emplacement.supprContenu();
			this.setEmplacement(destination);

			return (this.getEmplacement() == destination);
		}
		return false;
	}

	/**
	 * Initialise la position du joueur si ca n'a pas deja ete fait
	 * 
	 * @param position
	 *            Position de depart du joueur
	 * @return true si la position a ete initialiser, false sinon
	 */
	public boolean initialiserPos(Case position) {
		if (this.getEmplacement() == null) {
			this.setEmplacement(position);
			if (this.getEmplacement() == position) {
				return position.ajoutContenu(this);
			}
		}
		return false;
	}

	/**
	 * Attaque une cible
	 * 
	 * @param cible
	 *            Entite qui subira les degats
	 */
	public void attaquer(EntiteVivante cible) {
		cible.retirerVie(1);
	}

	/**
	 * Permet de ramasser un objet
	 * 
	 * @param obj
	 *            Objet a rammasser
	 * @return true si l'objet a ete ajouter a l'inventaire, false sinon
	 */
	public boolean rammasserObjet(Objet obj) {
		if ((!this.inventaire.contient(obj) && !this.equipement.contient(obj))) {
			return this.inventaire.ajouterObjet(obj);
		}
		return false;
	}

	/**
	 * Permet d'equiper un objet
	 * 
	 * @param obj
	 *            Objet a equipe (doit etre dans l'inventaire du joueur
	 * @return true si l'objet a ete equipe, false sinon
	 */
	public boolean equiperObjet(Objet obj) {
		if (this.inventaire.retirerObjet(obj)) {
			if (!this.equipement.ajouterObjet(obj)) {
				this.inventaire.ajouterObjet(obj);
				return false;
			} else {
				// this.majCaractEqui();
				return true;
			}
		}
		return false;
	}

	/**
	 * Permet de desequiper un objet
	 * 
	 * @param obj
	 *            Objet a desequipe (doit etre dans l'inventaire du joueur
	 * @return true si l'objet a ete desequipe, false sinon
	 */
	public boolean desequiperObjet(Objet obj) {
		if (this.equipement.retirerObjet(obj)) {
			if (!this.inventaire.ajouterObjet(obj)) {
				return this.equipement.ajouterObjet(obj);
			} else {
				// this.majCaractEqui();
				return true;
			}
		}
		return false;
	}

	/**
	 * Permet de mettre un Objet dans une case
	 * 
	 * @param obj
	 *            Objet a mettre dans la case
	 * @param destination
	 *            Case qui recevra l'objet
	 * @return
	 */
	public boolean deposerObjet(Objet obj, Case destination) {
		return destination.ajoutContenu(obj);
	}

	/**
	 * Retire un objet de l'inventaire
	 * 
	 * @param obj
	 *            Objet a retirer
	 */
	public void retirerObjet(Objet obj) { // TODO:skeggib ajouter UML
		this.inventaire.retirerObjet(obj);
	}

	/**
	 * Permet d'ajouter de la vie
	 * 
	 * @param vie
	 *            Nombre de point de vie a ajouter
	 */
	public void ajouterVie(int vie) {
		if (vie > 0) {
			this.setVie(this.getVie() + vie);
		}
	}

	/**
	 * Permet de retirrer de la vie
	 * 
	 * @param vie
	 *            Nombre de point de vie a retirer
	 */
	public void retirerVie(int vie) {
		if (vie < 0) {
			this.setVie(this.getVie() - vie);
		}
	}

	/**
	 * Controlle si l'entite est vivante
	 * 
	 * @return true si vie > 0, false sinon
	 */
	public boolean estVivant() {
		return !(this.getVie() <= 0);
	}

	/**
	 * Permet d'ajouter un effet a l'entite
	 * 
	 * @param effet
	 *            Effet a ajouter
	 * @return true si l'effet a ete ajoute, false sinon
	 */
	public boolean ajouterEffet(Effet effet) {
		if (!this.effet.contains(effet)) {
			this.effet.add(effet);
			if (this.effet.contains(effet)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Permet de retirer un effet a l'entite
	 * 
	 * @param effet
	 *            Effet a retirer
	 * @return true si l'effet a ete retirer, false sinon
	 */
	public boolean retirerEffet(Effet effet) {
		if (this.effet.contains(effet)) {
			this.effet.remove(effet);
		}
		return !this.effet.contains(effet);
	}

	/**
	 * Controlle les effets de l'entite Si l'effet prend fin, il sera supprime
	 */
	public void controlerEffet() {
		for (int i = 0; i < this.effet.size(); i++) {
			if (this.effet.get(i).decrementerTour()) {
				this.retirerEffet(this.effet.get(i));
			}
		}
	}
	
	public abstract void recupererPA (); //TODO:skeggib ajouter UML

	/**
	 * Met a jour les caracteristiques apportees par l'equipement
	 */
	// private void majCaractEqui(){ //TODO:skeggib Ajouter UML
	//
	// this.setForceEqui(0);
	// this.setAdresseEqui(0);
	// this.setResistanceEqui(0);
	// this.setManiabiliteArm(0);
	// this.setImpactArm(0);
	//
	// for(int i = 0; i < this.equipement.getTaille(); i++){
	// this.equipement.getObjet(i).affecterBonus(this, this);
	// }
	// }

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

	public void setPointAction(int pointAction) {
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

	private void setEquipement(Equipement equipement) {
		if (this.equipement == null) {
			this.equipement = equipement;
		}
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
		if (this.emplacement != emplacement) {
			this.emplacement = emplacement;
		}
	}

}
