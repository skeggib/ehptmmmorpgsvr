package personnage;

import java.util.Random;

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

	public static final int PA_UTILISE_POTION = 1;
	public static final int PA_DEPLACEMENT = 2;
	public static final int PA_ATTAQUE = 2;

	public static final int MAX_VIE = 7;
	public static final int MIN_VIE = 0;

	public static final int MIN_PA = 0;

	/*
	 * Variables
	 */

	private String nom;

	private int experience;
	
	private int pointAction;

	private int vie;

	private Case emplacement;

	private Caracteristique caractPrinc;
	private Caracteristique caractEquip;
	private Caracteristique caractEffet;

	private Inventaire inventaire;
	private Equipement equipement;
	private ListeUnique<Effet> effet;

	/*
	 * Constructeurs
	 */

	public EntiteVivante() {

		this.setVie(EntiteVivante.MAX_VIE);

		this.caractPrinc = new Caracteristique();
		this.caractEquip = new Caracteristique();
		this.caractEffet = new Caracteristique();

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());

		this.effet = new ListeUnique<Effet>();
	}

	public EntiteVivante(int force, int adresse, int resistance) {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(EntiteVivante.MAX_VIE);
		this.effet = new ListeUnique<Effet>();

		this.caractPrinc = new Caracteristique();
		this.caractEquip = new Caracteristique();
		this.caractEffet = new Caracteristique();

		this.caractPrinc.setForce(force);
		this.caractPrinc.setAdresse(adresse);
		this.caractPrinc.setResistance(resistance);
	}

	public EntiteVivante(int force, int adresse, int resistance, int vie) {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(vie);
		this.effet = new ListeUnique<Effet>();

		this.caractPrinc = new Caracteristique();
		this.caractEquip = new Caracteristique();
		this.caractEffet = new Caracteristique();

		this.caractPrinc.setForce(force);
		this.caractPrinc.setAdresse(adresse);
		this.caractPrinc.setResistance(resistance);
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
		// cible.retirerVie(1);

		System.out.println("\n==================");
		int adresseCible = cible.getCaractTotal().getAdresse();
		int encombrementCible = (cible.getEquipement().getTaille() * 2);

		int esquiveCible = Capacite.getRandomEsquive(adresseCible,
				encombrementCible);
		System.out.println("esquive cible " + esquiveCible);

		int adresseJ = this.getCaractTotal().getAdresse();
		int maniabiliteJ = this.getCaractTotal().getManiabilite();

		int attaqueJ = Capacite.getRandomAttaque(adresseJ, maniabiliteJ);
		System.out.println("attaque joueur " + attaqueJ);

		if ((new Random().nextInt(100) + 1) > esquiveCible) {

			int resistanceCible = cible.getCaractTotal().getResistance();

			int defenseCible = Capacite.getRandomDefense(resistanceCible);
			System.out.println("defense cible " + defenseCible);

			int forceJ = this.getCaractTotal().getForce();
			int impactJ = this.getCaractTotal().getImpact();

			int degatJ = Capacite.getRandomDegat(forceJ, impactJ);
			System.out.println("degat joueur " + degatJ);

			int degatSubit = degatJ * ((100 - defenseCible) + attaqueJ) / 100;

			// if (degatJ > defenseCible) {
			// int degatSubit = degatJ - defenseCible;
			System.out.println("degat subit " + degatSubit);
			//
			int vieEnMoins = degatSubit * 40 / 100;
			System.out.println("VIE EN MOINS : " + vieEnMoins);

			System.out.println("Vie avant attaque : " + cible.getVie());
			cible.retirerVie(vieEnMoins);
			System.out.println("Vie apres attaque : " + cible.getVie());
			// } else {
			//
			// }

		} else {

		}

		System.out.println("==================");
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
				this.majCaractEqui();
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
				this.majCaractEqui();
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
		if (vie > 0) {
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
				this.majCaractEffet();
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
			this.majCaractEffet();
		}
		return !this.effet.contains(effet);
	}

	/**
	 * Controlle les effets de l'entite Si l'effet prend fin, il sera supprime
	 */
	private void controlerEffet() { // TODO:skeggib Ajouter UML?
		for (int i = 0; i < this.effet.size(); i++) {
			if (this.effet.get(i).decrementerTour()) {
				this.retirerEffet(this.effet.get(i));
			}
		}
	}

	/**
	 * Controlle le montant de PA
	 * 
	 * @return true s'il en reste assez pour effectuer une action, false sinon
	 */
	public boolean actionDisponible() { // TODO:skeggib Ajouter UML
		return (this.getPointAction() != 0);
	}

	/**
	 * Effectue les actions necessaires a chaque debut de tour
	 */
	public void debutTour() { // TODO:skeggib Ajouter UML
		this.controlerEffet();
		this.ajouterVie(1);
		this.recupererPA();
	}

	/**
	 * Calcul les caracteristiques total de l'entite
	 * 
	 * @return Caracteristique total
	 */
	public Caracteristique getCaractTotal() { // TODO:skeggib Ajouter UML
		Caracteristique c = new Caracteristique();

		c.ajouter(this.caractPrinc);
		c.ajouter(this.caractEquip);
		c.ajouter(this.caractEffet);

		return c;
	}

	public abstract void recupererPA(); // TODO:skeggib Ajouter UML

	/**
	 * Met a jour les caracteristiques apportees par l'equipement (reinitialise
	 * les caracteristiques a 0 pour tout recalculer)
	 */
	private void majCaractEqui() { // TODO:skeggib Ajouter UML
		this.caractEquip.reinitialiserCaract();

		for (int i = 0; i < this.equipement.getTaille(); i++) {
			this.equipement.getObjet(i).affecterBonus(this, this);
		}
	}

	/**
	 * Met a jour les caracteristiques apportees par les effets (reinitialise
	 * les caracteristiques a 0 pour tout recalculer)
	 */
	private void majCaractEffet() { // TODO:skeggib Ajouter UML
		this.caractEffet.reinitialiserCaract();

		for (int i = 0; i < this.effet.size(); i++) {
			this.effet.get(i).appliquerEffet(this);
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

	public Inventaire getInventaire() {
		return inventaire;
	}

	private void setInventaire(Inventaire inventaire) {
		if (this.inventaire == null) {
			this.inventaire = inventaire;
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

	public Case getEmplacement() {
		return emplacement;
	}

	private void setEmplacement(Case emplacement) {
		if (this.emplacement != emplacement) {
			this.emplacement = emplacement;
		}
	}

	public Caracteristique getCaractPrinc() {
		return this.caractPrinc;
	}

	public Caracteristique getCaractEquip() {
		return this.caractEquip;
	}

	public Caracteristique getCaractEffet() {
		return this.caractEffet;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
